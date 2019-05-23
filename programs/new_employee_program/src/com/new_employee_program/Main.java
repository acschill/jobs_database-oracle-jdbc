
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
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class Main {

    private static Connection conn;
    final String host = "dbsvcs.cs.uno.edu";
    final int port = 1521;
    final String sID = "orcl";

    // three constructors
    public Main(String host, int port, String sID, String username, String passwd) throws SQLException {
        conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);
    }

    public Main(String username, String passwd) throws SQLException {
        this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);  // for Oracle
        // this.conn = new DBConnection(sID).getDBConnection(username, passwd);  // for MS SQL
    }

    public Main(Connection conn) throws SQLException {
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
        //conn = dbc.getDBConnection("aschill", "KHqM7k9j");	//auto login
        conn = dbc.getDBConnection("ssavoie1", "bHHq3Rxr");	//auto login
        
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
    
    /**
     * Reads in transcript of new employee from a .txt file
     * 
     * @return void
     * @throws SQLException, ParseException
     */
    public static void readTranscript() throws SQLException, ParseException 
    {

    	System.out.println("Enter transcript filename: ");
    	Scanner readFilename = new Scanner(System.in);
    	String filename = readFilename.nextLine();
    	readFilename.close();
    	
    	File file = new File("src/resources/" + filename);
    	//File file = new File("src/resources/transcript_test.txt"); 	// File object to read in transcript.txt
    	String[] updateInfo = new String[3];
    	int i = 0;
    	
    	
    	
        try {
        	conn.setAutoCommit(false);			// turn off AutoCommit
            Scanner sc = new Scanner(file);		// scanner for reading contents of transcript.txt

            while (sc.hasNextLine()) {
            	
                String segment = sc.next();
                updateInfo[i] = segment;		// storing each element of line in transcript.txt in String array
                
               if(i == 2) {
            	   updateTakes(updateInfo);		// send current line information to be inserted into TAKES table
            	   
            	   i = 0;
               } else {
            	   i++;  
               }
       
            }
            sc.close();
            System.out.println("Record is inserted into TAKES table!\n");		// Confirmation that insertions have been completed
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } 
        catch (SQLException e)  {
        	conn.rollback();						// rollback upon error
 			System.out.println(e.getMessage());
        }
        finally {
        	conn.commit();				// commit changes
        	conn.setAutoCommit(true);				// turn AutoCommit back on
        }
    }
    
    
    /**
     * Updates the TAKES tables with new transcript information
     * 
     * @param updateInfo
     * @return void
     * @throws SQLException, ParseException
     */
    public static void updateTakes(String[] updateInfo) throws SQLException, ParseException
    {   
 	   PreparedStatement pstmt = null;
 	   int sectionIn = Integer.parseInt(updateInfo[0]);		// section number
 	   int courseIn = Integer.parseInt(updateInfo[1]);		// course number
 	  // int perid = Integer.parseInt(per_id);				// per_id in
 	   String dateString = updateInfo[2];					// completion date of type String
 	   Date utilDate = null;								// Date object for converting String if non-NULL
 	   java.sql.Date sqlDate = null;						// java.sql.Date object for converting Date object
 	   int nullCheck = 0;
 	   int intoHasSkill = 0;
 	   
 	   if (dateString.equals("null")) {											// completed date == NULL
 		   nullCheck = 1;
 	   }   
 	   else {																	// completed date == non-NULL
 		   utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);		// convert completed date of type String to type Date
 		   sqlDate = new java.sql.Date(utilDate.getTime());						// convert completed date of type Date to type java.sql.Date (allows to work on prepared statement)
 		   intoHasSkill = 1;
 	   }
 	   
 	   String insertTableSQL = "INSERT INTO takes"								// INSERT statement of type String
 				+ "(PER_ID, SEC_NO, C_CODE, COMPLETE_DATE) VALUES"
 				+ "(?,?,?,?)";
 	   
 		try {
 			
 			pstmt = conn.prepareStatement(insertTableSQL);				// assign value to prepared statement as part of open connection, passing in INSERT statement (type String)		

 			pstmt.setInt(1, 1);		//per_id						// set first parameter in insertTableSQL to person
 			pstmt.setInt(2, sectionIn);	//sec_no						// set second parameter in insertTableSQL to section number
 			pstmt.setInt(3, courseIn);	//c_code						// set third parameter in insertTableSQL to course number

 			if (nullCheck == 1) { // complete_date == null				// check if complete_date is NULL
 				pstmt.setNull(4, java.sql.Types.DATE);					// if so, set fourth parameter to NULL w/ .setNull() fcn
 			}
 			else {  // complete_date == a value							// complete_date != NULL
 				pstmt.setDate(4, sqlDate);								// set fourth parameter to var sqlDate of type java.sql.Date
 			}

 			pstmt.executeUpdate();		// execute insert SQL statement
 			
 		if (intoHasSkill == 1) {
 			updateHasSkill(courseIn, 1);
 		}
 			
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 		}
    }
    
    /**
     * Updates the HAS_SKILL table with valid skill
     * 
     * @param course, perid
     * @return void
     * @throws Exception
     */
    public static void updateHasSkill(int course, int perid) throws Exception
    {   
       int ks_code = get_ks_code_with_ccode(course);
 	   PreparedStatement pstmt = null;
 	   
 	   String insertSQL = "INSERT INTO has_skill"								// INSERT statement of type String
 				+ "(KS_CODE, PER_ID) VALUES"
 				+ "(?,?)";
 	   
 		try {
 			
 			pstmt = conn.prepareStatement(insertSQL);				// assign value to prepared statement as part of open connection, passing in INSERT statement (type String)		

 			pstmt.setInt(1, ks_code);		//ks_code						// set first parameter in insertSQL to ks_code
 			pstmt.setInt(2, perid);			//per_id						// set second parameter in insertSQL to per_id

 			pstmt.executeUpdate();		// execute insert SQL statement
 			System.out.println("\nRecord is inserted into HasSkill table!\n");
 			
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 		}
    }
    
    /**
     * Retrieves ks_code pertaining to c_code
     * 
     * @param course
     * @return int
     * @throws Exception
     */
    public static int get_ks_code_with_ccode(int c_code) throws Exception
    {   
 	   int ks_code = 0;
 	   
 	   String selectSQL = "SELECT ks_code " + 
				"FROM teaches " + 
				"WHERE c_code = ?";
		
		try {
            PreparedStatement pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, c_code);	//c_code in	
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String ks_string = rs.getString("ks_code");
                ks_code = Integer.parseInt(ks_string);
                //System.out.println("c_code: " + c_code + " has ks_code: " + ks_code);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
		return ks_code;
    }

}

