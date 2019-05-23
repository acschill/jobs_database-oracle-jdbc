package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Person table
 */
public class Person {
	Connection con;
		
	
	/**
	 * Constructor
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public Person(Connection conn) throws SQLException {
		con = conn;
	}
	
	
	/**
	 * Creates the table in the database
	 * 
	 * @throws SQLException
	 */
	public void createTable() throws SQLException {
	    String createString =
	        "create table Person " +
	        "(per_id numeric(2,0) NOT NULL, " +
	        "name varchar2(255) NOT NULL, " +
	        "email varchar2(255), " +
	        "gender varchar(6), " +
	        "street_number numeric(5,0), " +
	    	"street_name varchar2(255), " +
	    	"apt_number	varchar(10), "+
	    	"city varchar2(255), " +
	    	"state varchar2(255), " +
	    	"zip_code numeric(5,0), " +
	    	"primary key (per_id))";
	    	
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
	 * Adds a tuple in the database
	 * 
	 * @param per_id
	 * @param name
	 * @param email
	 * @param gender
	 * @param street_number
	 * @param street_name
	 * @param apt_number
	 * @param city
	 * @param state
	 * @param zip_code
	 * @throws SQLException
	 */
	public void addAPerson(String per_id, String name, String email, String gender, 
			String street_number, String street_name, String apt_number, String city, 
			String state, String zip_code) throws SQLException {
		
		String query = "INSERT INTO PERSON VALUES (" + per_id + ", " + name + ", " + email + 
				", " + gender + ", " + street_number + ", " + name + ", " + apt_number + ", "
				+ city + ", " + state + ", " + zip_code + ")";
		
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
	 * Deletes a tuple from the database
	 * 
	 * @param per_id
	 */
	public void deletePerson(String per_id) {
		String sql = "DELETE FROM Person WHERE per_id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
 
            // set the corresponding param
            pstmt.setString(1, per_id);
            
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
	            ".Person " +
	            "VALUES (1, 'Ann Jones', 'ann@hotmail.com', "
	            + "'female', 12, 'Curie', '1', "
	            + "'New York', 'New York', 78789)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            ".Person " +
	            "VALUES (2, 'Elvis Presley', "
	            + "'elvis@hotmail.com', 'male', "
	            + "143, 'Pasteur', , 'Dallas', 'Texas', 45456)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            ".Person " +
	            "VALUES (3, 'John Lee', 'john@hotmail.com', "
	            + "'male', 456, 'Wurtele', '2', "
	            + "'Boston', 'Massachusetts', 12123)");
        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            ".Person " +
	            "VALUES (4, 'Abigail Nolan', 'abigail@hotmail.com', "
	            + "'female', 386, 'Orleans', , "
	            + "'Chicago', 'Illinois', 60623)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            ".Person " +
	            "VALUES (5, 'Robert Page', 'robert@hotmail.com', "
	            + "'male', 277, 'Franklin', , 'New Orleans', "
	            + "'Louisiana', 70189)");
	        
	        stmt.executeUpdate(
	            "insert into Has_Skill " +
	            ".Person " +
	            "VALUES (6, 'Roberta Lee', 'roberta@hotmail.com', "
	            + "'female', 200, 'Oak', , 'New Orleans', "
	            + "'Louisiana', 70190)");
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
}
