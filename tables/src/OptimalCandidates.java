package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * This process finds the best choice of people for a job position with training
 * User interface for queries #16 and #18
 * 16: Given a position code, list all the names along with the emails of the persons who are qualified for this position.
 * 18: Suppose there is a new position that has nobody qualified. List the persons who miss the least number of skills
that are required by this pos_code and report the “least number”.
 *
 */
public class OptimalCandidates {
	
	String pos_code;
	Connection con;
	
	
	/**
	 * Constructor
	 * 
	 * @param pos_code
	 * @param con
	 */
	public OptimalCandidates(String pos_code, Connection con) {
		this.pos_code = pos_code;
		this.con = con;
	}
	
	/**
	 * Returns the names, ids and emails of the persons that are qualified for the job position. (Query 16)
	 * 
	 * @return
	 */
	public ArrayList<String[]> getQualifiedPeople() {
		
		String query16 = "SELECT per_id, name, email " + 
				"FROM person P " + 
				"WHERE NOT EXISTS( " + 
				"    (SELECT ks_code " + 
				"    FROM req_skill " + 
				"    WHERE pos_code = ?) " + 
				"    MINUS " + 
				"    (SELECT ks_code " + 
				"    FROM has_skill H " + 
				"    WHERE P.per_id = H.per_id))";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
            PreparedStatement pstmt = con.prepareStatement(query16);
            pstmt.setString(1, pos_code);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] line = new String[3];
                line[0] = rs.getString("per_id");
                line[1] = rs.getString("name");
                line[2] = rs.getString("email");
                al.add(line);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
		return al;
	}
	
	
	/**
	 * Returns the names, ids and emails of the persons that are almost qualified for the job position. (Query 18)
	 * 
	 * @return
	 */
	public ArrayList<String[]> getAlmostQualifiedPeople() {
		
		String query18 = "WITH nb_req_skills(value, pos_code) AS ( " + 
				"        SELECT COUNT(ks_code), pos_code " + 
				"        FROM req_skill " + 
				"        WHERE pos_code = ? " + 
				"        GROUP BY pos_code " + 
				"    ), " + 
				"    personRequiredSkillCnt(per_id, skill_cnt) AS ( " + 
				"        (SELECT per_id, COUNT(ks_code) " + 
				"        FROM has_skill NATURAL JOIN req_skill NATURAL JOIN nb_req_skills " + 
				"        GROUP BY per_id) " + 
				"        UNION " + 
				"        (SELECT per_id, 0 " + 
				"        FROM person) " + 
				"        MINUS " + 
				"        (SELECT per_id, 0 " + 
				"        FROM has_skill NATURAL JOIN req_skill NATURAL JOIN nb_req_skills) " + 
				"    ), " + 
				"    missing_skills(per_id, missing_k) AS ( " + 
				"        SELECT per_id, (N.value - P.skill_cnt) AS missing_k " + 
				"        FROM personRequiredSkillCnt P, nb_req_skills N " + 
				"    ), " + 
				"    min_k(value) AS ( " + 
				"        SELECT MIN(missing_k) " + 
				"        FROM missing_skills " + 
				") " + 
				"SELECT per_id, missing_k AS least_number " + 
				"FROM personRequiredSkillCnt NATURAL JOIN missing_skills, min_k " + 
				"WHERE missing_k = min_k.value";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
            PreparedStatement pstmt = con.prepareStatement(query18);
            pstmt.setString(1, pos_code);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] line = new String[2];
                line[0] = rs.getString("per_id");
                line[1] = rs.getString("least_number");
                al.add(line);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
		return al;
	}
}
