package src;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/*
 * A company hires a new employee:
 *
 * You can assume the information of the person is already in the system. So the process starts 
 * with a per_id and a pos_code. Then the application should automate the steps shown below by 
 * interacting with the user.
 *
 * Step 1 Upload the person's transcripts and input the course taking information into table Takes;
 * Step 2 Populate table Has_Skill with more rows derived from the courses this person have taken;
 * Step 3 Verify if this person has every skill required by the given pos_code;
 * Step 4 If a skill gap is identified, propose a training plan for this person.
 */
public class EmployeeHiring {

    private Connection conn;
    private String pos_code;
    private String per_id;
    
    
    /**
     * Constructor
     * 
     * @param conn
     * @throws SQLException
     */
    public EmployeeHiring(Connection conn, String pos_code, String per_id) throws SQLException {
        this.conn = conn;
        this.pos_code = pos_code;
        this.per_id = per_id;
    }
    
    
    /**
     * Returns the courses that are required for the given job position
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList<String[]> findTrainingProg() throws SQLException {
    	try {
			readTranscript();
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	if(missesSkills() && getOneCourse().isEmpty()) {
    		return getCourseSet();
    	} else if (missesSkills() && !getOneCourse().isEmpty()) {
    		return getOneCourse();
    	} else {
    		return null;
    	}
    }
    	//TEST pos_code = 2, per_id = 1, filename = transcript_test.txt
    /**
     * Reads in transcript of new employee from a .txt file
     * 
     * @return void
     * @throws SQLException, ParseException
     */
    public void readTranscript() throws SQLException, ParseException 
    {

    	System.out.println("Enter transcript filename: ");
    	Scanner readFilename = new Scanner(System.in);
    	String filename = readFilename.nextLine();
    	readFilename.close();
    	
    	File file = new File("tables/src/" + filename);
    	//File file = new File("tables/src/transcript_test.txt"); 	// File object to read in transcript.txt 	
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
            conn.commit();							// commit changes
        	conn.setAutoCommit(true);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } 
        catch (SQLException e)  {
        	conn.rollback();						// rollback upon error
 			System.out.println(e.getMessage());
        }
        //finally {
        	//conn.commit();							// commit changes
        	//conn.setAutoCommit(true);				// turn AutoCommit back on
        //}
    }
    
    
    /**
     * Updates the TAKES tables with new transcript information
     * 
     * @param updateInfo
     * @return void
     * @throws SQLException, ParseException
     */
    public void updateTakes(String[] updateInfo) throws SQLException, ParseException
    {   
 	   PreparedStatement pstmt = null;
 	   int sectionIn = Integer.parseInt(updateInfo[0]);		// section number
 	   int courseIn = Integer.parseInt(updateInfo[1]);		// course number
 	   int perid = Integer.parseInt(per_id);				// per_id in
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

 			pstmt.setInt(1, perid);		//per_id						// set first parameter in insertTableSQL to person
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
    public void updateHasSkill(int course, int perid) throws Exception
    {   
       int ks_code = get_ks_code_with_ccode(course);
 	   PreparedStatement pstmt = null;
 	   
 	   String insertSQL = "INSERT INTO has_skill"				// INSERT statement of type String
 				+ "(KS_CODE, PER_ID) VALUES"
 				+ "(?,?)";
 	   
 		try {
 			
 			pstmt = conn.prepareStatement(insertSQL);	// assign value to prepared statement as part of open connection, passing in INSERT statement (type String)		

 			pstmt.setInt(1, ks_code);		//ks_code		// set first parameter in insertSQL to ks_code
 			pstmt.setInt(2, perid);			//per_id		// set second parameter in insertSQL to per_id

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
    public int get_ks_code_with_ccode(int c_code) throws Exception
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
   
   /**
	 * Returns true if the person misses skills for the given position code
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public boolean missesSkills() throws SQLException {
		
		String str = "(SELECT ks_code, title " + 
					" FROM req_skill NATURAL JOIN knowledge_skill " + 
					" WHERE pos_code = ?) " + 
					" MINUS " + 
					" (SELECT ks_code, title " + 
					" FROM has_skill NATURAL JOIN knowledge_skill " + 
					" WHERE per_id = ?)";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
           PreparedStatement pstmt = conn.prepareStatement(str);
           pstmt.setString(1, per_id);
           pstmt.setString(2, pos_code);
           
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
               String[] line = new String[2];
               line[0] = rs.getString("ks_code");
               line[1] = rs.getString("title");
               al.add(line);
           }
           if (al.size() == 0) {
        	   return false;
           }
           return true;
        	   
       } catch(SQLException sqle) {
           throw new SQLException();
       }
	}
	
	
	/**
	 * Returns the course that can teach the missing skills for the given person and the given position
	 * 
	 * @return
	 */
	public ArrayList<String[]> getOneCourse() {
		
		String str1Course = "WITH missing_skills(ks_code) AS ( " + 
				"    (SELECT ks_code " + 
				"    FROM req_skill NATURAL JOIN knowledge_skill " + 
				"    WHERE pos_code = ?) " + 
				"    MINUS " + 
				"    (SELECT ks_code " + 
				"    FROM has_skill NATURAL JOIN knowledge_skill " + 
				"    WHERE per_id = ?) " + 
				") " + 
				"SELECT c_code, title " + 
				"FROM teaches T NATURAL JOIN knowledge_skill " + 
				"WHERE NOT EXISTS( " + 
				"    (SELECT ks_code " + 
				"    FROM missing_skills) " + 
				"    MINUS " + 
				"    (SELECT ks_code " + 
				"    FROM teaches T2 " + 
				"    WHERE T.c_code = T2.c_code))";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
           PreparedStatement pstmt = conn.prepareStatement(str1Course);
           pstmt.setString(1, pos_code);
           pstmt.setString(2, per_id);
           
           ResultSet rs = pstmt.executeQuery();
        	   
           while (rs.next()) {
               String[] line = new String[2];
               line[0] = rs.getString("c_code");
               line[1] = rs.getString("title");
               al.add(line);
           }
       } catch(SQLException sqle) {
           sqle.printStackTrace();
       }
		return al;
	}
	
	
	/**
	 * Finds the course set that teaches the missing skills for the given person and the given job
	 *
	 * @return
	 */
	public ArrayList<String[]> getCourseSet() {
		
		String strCourseSet = "WITH missing_skill(ks_code) AS ( " + 
				"        (SELECT ks_code " + 
				"        FROM req_skill " + 
				"        WHERE pos_code = ?) " + 
				"        MINUS " + 
				"        (SELECT ks_code " + 
				"        FROM has_skill " + 
				"        WHERE per_id = ?) " + 
				"    ), " + 
				"    cover_cset(cset_id, set_size) AS ( " + 
				"        SELECT cset_id, cset_size " + 
				"        FROM course_set cset " + 
				"        WHERE NOT EXISTS ( " + 
				"            (SELECT ks_code " + 
				"            FROM missing_skill) " + 
				"            MINUS " + 
				"            (SELECT ks_code " + 
				"            FROM course_set_skill cssk " + 
				"            WHERE cssk.cset_id = cset.cset_id)) " + 
				") " + 
				"SELECT cset_id, c_code1, c_code2, c_code3 " + 
				"FROM cover_cset NATURAL JOIN course_set " + 
				"WHERE cset_size = (SELECT MIN(set_size) FROM Cover_CSet)";
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		
		try {
           PreparedStatement pstmt = conn.prepareStatement(strCourseSet);
           pstmt.setString(1, pos_code);
           pstmt.setString(2, per_id);
           
           ResultSet rs = pstmt.executeQuery();
        	   
           while (rs.next()) {
               String[] line = new String[4];
               line[0] = rs.getString("cset_id");
               line[1] = rs.getString("c_code1");
               line[2] = rs.getString("c_code2");
               line[3] = rs.getString("c_code3");
               al.add(line);
           }
       } catch(SQLException sqle) {
    	   sqle.printStackTrace();
       }
		return al;
	}
}
