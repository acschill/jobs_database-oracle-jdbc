package src;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Table that tells the skills that each person has
 */
public class HasSkill {
	Connection con;
	
	
	/**
	 * Constructor
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public HasSkill(Connection conn) throws SQLException {
		con = conn;
	}
	
	
	/**
	 * Creates the table in the database
	 * 
	 * @throws SQLException
	 */
	public void createTable() throws SQLException {
	    String createString =
	        "create table HAS_SKILL " +
	        "(ks_code	numeric(4,0), " +
	        "per_id		numeric(2,0), " +
	        "primary key (ks_code, per_id), " +
	        "foreign key (ks_code) REFERENCES knowledge_skill (ks_code), " +
	        "foreign key (per_id) REFERENCES person (per_id))";
	    
	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(createString);
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	/**
	 * Adds a new tuple in the table
	 * 
	 * @param ks_code
	 * @param per_id
	 * @throws SQLException
	 */
	public void addHasSkill(String ks_code, String per_id) throws SQLException {
		
		String query = "INSERT INTO HAS_SKILL VALUES(" + ks_code + ", " + per_id + ")";
		
		Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(query);    
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	/**
	 * Deletes a row from the database
	 * 
	 * @param ks_code
	 * @param per_id
	 */
	public void deleteSkill(String ks_code, String per_id) {
		String sql = "DELETE FROM Has_Skill WHERE ks_code = ? AND per_id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
 
            // set the corresponding param
            pstmt.setString(1, ks_code);
            pstmt.setString(2, per_id);
            
            // execute the delete statement
        	pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	/**
	 * Populates the table with data
	 * 
	 * @throws SQLException
	 */
	public void populateTable() throws SQLException {

	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(492.0,1.0)");

	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(12.0,1.0)");

	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	        	"values(32.0,1.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(354.0,1.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(591.0,1.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(23.0,1.0)");
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(224.0,2.0)");

	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(354.0,2.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(201.0,2.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(721.0,2.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(28.0,2.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(602.0,2.0)");
        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	       	    "values(492.0,3.0)");
        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(23.0,3.0)");
        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(354.0,3.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(801.0,3.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(251.0,3.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(197.0,3.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(678.0,4.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(201.0,4.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(54.0,4.0)");
        
	        stmt.executeUpdate(
	            "insert into Has_Skill " + 
	            "values(251.0,4.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(433.0,4.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(213.0,4.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(492.0,5.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " + 
	            "values(354.0,5.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " + 
	            "values(201.0,5.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(251.0,5.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(589.0,5.0)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            "values(28.0,5.0)");	        
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}
