
/*
 * A company hires a new employee:
 *
 * You can assume the information of the person is already in the system. So the process starts 
 * with a per_id and a pos_code. Then the application should automate the steps shown below by 
 * interacting with the user.
 *
 * Step 1 Upload the person’s transcripts and input the course taking information into table Takes;
 * Step 2 Populate table Has_Skill with more rows derived from the courses this person have taken;
 * Step 3 Verify if this person has every skill required by the given pos_code;
 * Step 4 If a skill gap is identified, propose a training plan for this person.
 */


package com.new_employee_program;

import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class working_main_new_employee {

    private static Connection conn;
    final String host = "dbsvcs.cs.uno.edu";
    final int port = 1521;
    final String sID = "orcl";

    // three constructors
    public working_main_new_employee(String host, int port, String sID, String username, String passwd) throws SQLException {
        conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);
    }

    public working_main_new_employee(String username, String passwd) throws SQLException {
        this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);  // for Oracle
        // this.conn = new DBConnection(sID).getDBConnection(username, passwd);  // for MS SQL
    }

    public working_main_new_employee(Connection conn) throws SQLException {
        this.conn = conn;
    }

     
    /*
     * Main 
     */
    public static void main(String[] args) throws SQLException, ParseException {
    	
        if (args.length == 1) {
            System.out.println("usage: java SampleQuery db-IP dp-SID");
            System.exit(1);
        }
        
        DBConnection dbc;
        
        if (args.length == 0)
            dbc = new DBConnection("dbsvcs.cs.uno.edu", 1521, "orcl");
        else
            dbc = new DBConnection(args[0], 1521, args[1]);

        // moved username & pw stuff to bottom
       
        //Connection conn = dbc.getDBConnection(username, dbpassword);
        conn = dbc.getDBConnection("aschill", "KHqM7k9j");	//auto login
        
        // step 1
        readTranscript();
              
       // step 2
       	// populate Has_Skill using the complete courses in takes
       
       // step 3
       	// verify if person has every skill required for position (w/ pos_code)
       
       // step 4
       	// if missing skills, propose training plan

        
        //Main sqObj = new Main(conn);
        
        // test the queries for application
//        ArrayList<String[]> str2d = sqObj.listCourseByCode(1);
//        for (String[] line : str2d) {
//            System.out.printf("%s %s %s %s", line[0], line[1], line[2], line[3]);
//        }
        
    }
    
    public static void readTranscript() throws SQLException, ParseException 
    {
    	File file = new File("src/resources/transcript_test.txt");
    	String[] updateInfo = new String[3];
    	int i = 0;
    	
        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
            	
                String segment = sc.next();
                updateInfo[i] = segment;
                System.out.println(i); 
                
               if(i == 2) {
            	   updateTakes(updateInfo);
            	   
            	   i = 0;
               } else {
            	   i++;  
               }
       
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
			if (conn != null) {
				conn.close();
			}
        }
    }
    
   	// input transcripts into takes tables
    // takes(per_id, sec_no, c_code, complete_date)
   public static void updateTakes(String[] updateInfo) throws SQLException, ParseException
   {   
	   PreparedStatement pstmt = null;
	   int sectionIn = Integer.parseInt(updateInfo[0]);
	   int courseIn = Integer.parseInt(updateInfo[1]);
	   String dateString = updateInfo[2];
	   Date utilDate = null;
	   java.sql.Date sqlDate = null;
	   int nullCheck = 0;
	   
	   if (dateString.equals("null")) {
		   nullCheck = 1;
	   }   
	   else {
		   utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		   sqlDate = new java.sql.Date(utilDate.getTime());
	   }
	   
	   String insertTableSQL = "INSERT INTO takes"
				+ "(PER_ID, SEC_NO, C_CODE, COMPLETE_DATE) VALUES"
				+ "(?,?,?,?)";
	   
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(insertTableSQL);

			pstmt.setInt(1, 1);			//per_id
			pstmt.setInt(2, sectionIn);	//sec_no
			pstmt.setInt(3, courseIn);	//c_code

			if (nullCheck == 1) { // complete_date == null
				pstmt.setNull(4, java.sql.Types.DATE);
			}
			else {  // complete_date == a value
				pstmt.setDate(4, sqlDate);	
			}

			// execute insert SQL statement
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("Record is inserted into TAKES table!");
			
		} catch (SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			conn.setAutoCommit(true);
		}
   }

}

