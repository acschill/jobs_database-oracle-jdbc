package src;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


/**
 * Position table
 */
public class Position {
	Connection con;
	
	
	/**
	 * Constructor
	 */
	public Position(Connection conn) throws SQLException {
		con = conn;
	}
	
	
	/**
	 * Creates the table in the database
	 */
	public void createTable() throws SQLException {
	    String createString =
	        "create table POSITION " + 	    	
	        "(pos_code numeric(2,0) NOT NULL, " + 
	    	"emp_mode varchar(9), " + 
	    	"pay_rate numeric(8,2), " + 
	    	"pay_type varchar(6), " + 
	    	"company varchar2(255), " + 
	    	"cate_code numeric(4,0), " + 
	    	"primary key (pos_code), " + 
	    	"foreign key (cate_code) REFERENCES job_category (job_cate))";
	    
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
	 * Adds a tuple in the table
	 * 
	 * @param pos_code
	 * @param emp_momde
	 * @param pay_rate
	 * @param pay_type
	 * @param company
	 * @param cate_code
	 * @throws SQLException
	 */
	public void addAPosition(String pos_code, String emp_momde, String pay_rate, String pay_type, 
			String company, String cate_code) throws SQLException {
		
		String query = "INSERT INTO PERSON VALUES (" + pos_code + ", " + emp_momde + ", " + pay_rate + 
				", " + pay_type + ", " + company + ", " + cate_code + ")";
		
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
	 * Deletes a tuple from the table
	 * 
	 * @param pos_code
	 */
	public void deletePosition(String pos_code) {
		String sql = "DELETE FROM Position WHERE pos_code = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
 
            // set the corresponding param
            pstmt.setString(1, pos_code);
            
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
	            "insert into Position " +
	            "VALUES (1, 'full-time', 40, 'wage', '1', 1211)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (2, 'full-time', 45, 'wage', '2', 1212)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (3, 'full-time', 85000, 'salary', '3', 1221)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (4, 'full-time', 70000, 'salary', '4', 1231)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (5, 'full-time', 50, 'wage', '5', 1232)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (6, 'part-time', 52, 'wage', '6', 1241)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (7, 'part-time', 75000, 'salary', '7', 1242)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (8, 'part-time', 80000, 'salary', '8', 1243)");
	        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (9, 'part-time', 55, 'wage', '9', 1244)");	        
        
	        stmt.executeUpdate(
	            "insert into Position " +
	            "VALUES (10, 'part-time', 100000, 'salary', '10', 1251)");      
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
}
