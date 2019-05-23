package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Program that supports a person's job hunting.
 * User interface for query #15:
 * "Given a person's identifier, find the job position with the highest
 * pay rate for this person according to his/her skill possession.
 *
 */
public class JobHunting {
	
	String per_id;
	Connection con;
	
	
	/**¸
	 * Constructor
	 * 
	 * @param per_id
	 * @param conn
	 */
	public JobHunting(String per_id, Connection conn) {
		this.per_id = per_id;
		this.con = conn;
	}
	
	
	/**
	 * Returns the jobs with the higest salary given the person's identifier
	 * 
	 * @return
	 */
	public ArrayList<String[]> getJobWithHighestSalary() {
		
		String str = "WITH jobs(pos_code, pay) AS ( " + 
				"        SELECT pos_code, " + 
				"        CASE WHEN pay_type = 'wage' then pay_rate * 1920 " + 
				"            ELSE pay_rate END AS pay  " + 
				"        FROM position P " + 
				"        WHERE NOT EXISTS(" + 
				"            (SELECT ks_code " + 
				"            FROM req_skill R " + 
				"            WHERE P.pos_code = R.pos_code) " + 
				"            MINUS " + 
				"            (SELECT ks_code " + 
				"            FROM person NATURAL JOIN has_skill " + 
				"            WHERE per_id = ?)) " + 
				"    ), " + 
				"    max_sal(value) AS ( " + 
				"        SELECT MAX(pay) " + 
				"        FROM jobs " + 
				") " + 
				"SELECT pos_code, max_sal.value AS salary " + 
				"FROM jobs, max_sal " + 
				"WHERE pay = max_sal.value";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
            PreparedStatement pstmt = con.prepareStatement(str);
            pstmt.setString(1, per_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] line = new String[2];
                line[0] = rs.getString("pos_code");
                line[1] = rs.getString("salary");
                al.add(line);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
		return al;
	}
}
