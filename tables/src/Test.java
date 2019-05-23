package src;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Test {
	Connection con;
	
	public Test(Connection conn) throws SQLException {
		con = conn;
		createTable();
	}
	
	
	public void createTable() throws SQLException {
	    String createString =
	        "create table Test " +
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
	public void insert(String ks_code, String per_id) throws SQLException {
		
		String query = "INSERT INTO Test VALUES(" + ks_code + ", " + per_id + ")";
		
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
	public void delet(String ks_code, String per_id) {
		String sql = "DELETE FROM Test WHERE ks_code = ? AND per_id = ?";
		
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
	
	
	public void populateTable() throws SQLException {

	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(
	            "insert into Test " +
	            "values(492.0,1.0)");
      
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}
