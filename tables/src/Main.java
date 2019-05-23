package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Connection conn;
    final String host = "dbsvcs.cs.uno.edu";
    final int port = 1521;
    final String sID = "orcl";

    // three constructors
    public Main(	String host,
                           int port,
                           String sID,
                           String username,
                           String passwd) throws SQLException {
        conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);
    }

    public Main(String username, String passwd) throws SQLException {
        this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd);  // for Oracle
        // this.conn = new DBConnection(sID).getDBConnection(username, passwd);  // for MS SQL
    }

    public Main(Connection conn) throws SQLException {
        this.conn = conn;
    }

    // Application related queries

    /**
     * List the sections of a course offered no later than a given date in the order of their starting date
     * Course(c_code, title, dept, cr_hr, level, description, retail_price)
     * Section(c_code, secno, sem, yr, price, start_date, note)
     */
    // date_by is of format MM/dd/yyyy
    public ArrayList<String[]> listSectionByCourse(String c_code, String date_by) {
        String str = "SELECT c_code, secno, price, start_date "
                + "FROM course NATURAL JOIN Section "
                + "WHERE c_code = ? AND start_date <= ? "
                + "ORDER BY start_date ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(date_by, formatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        ArrayList<String[]> al = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(str);
            pstmt.setString(1, c_code);
            pstmt.setDate(2, sqlDate);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] line = new String[4];
                line[0] = rs.getString("c_code");
                line[1] = rs.getString("secno");
                line[2] = rs.getDouble("price") + "";
                line[3] = rs.getDate(4) + "";
                al.add(line);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        return al;
    }

    /**
     * List the cheapest section(s) of each course of the given level if it is cheaper than
     * the course retail price by the specified percentage.
     * Course(c_code, title, dept, cr_hr, level, description, retail_price)
     * Section(c_code, secno, sem, yr, price, start_date, note)
     */
    // course_level has to be senior, junior, sophomore or freshman
    // percent is is the minimum discount percentage
    public ArrayList<String[]> listCheapSection(String course_level, int percent) {
        String str = "WITH CheapSection AS SELECT c_code, secno, MIN(price) AS cheap_price "
                + "		FROM course NATURAL JOIN Section "
                + "		WHERE level = ?"
                + "		GROUP BY c_code "
                + "SELECT c_code, secno, cheap_price "
                + "FROM course NATURAL JOIN CheapSection "
                + "WHERE price = cheap_price AND cheap_price <= retail_price / 100 * (100 - ?)";
        ArrayList<String[]> al = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(str);
            pstmt.setString(1, course_level);
            pstmt.setInt(2, percent);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] line = new String[3];
                line[0] = rs.getString("c_code");
                line[1] = rs.getString("secno");
                line[2] = rs.getDouble("price") + "";
                al.add(line);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        return al;
    }

    // General purpose queries

    /** list all the user's table names	 */
    public String[] listTableName() throws SQLException {
        String str = "SELECT Table_Name FROM USER_TABLES";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(str);
        ArrayList<String> al = new ArrayList<String>();
        while (rs.next()) {
            al.add(rs.getString("Table_Name"));
        }
        String[] tn = al.toArray(new String[1]);
        return tn;
    }

    /** return the columns' titles of a table as an array of String */
    public static String[] getColumnName(ResultSet rs) throws SQLException {
        ResultSetMetaData rmd = rs.getMetaData();
        int colNum = rmd.getColumnCount();
        String[] col = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            col[i] = rmd.getColumnName(i+1);
        }
        return col;
    }

    /** return the columns' types
     * wonder how types are in int?   https://docs.oracle.com/javase/7/docs/api/  */
    public static int[] getColumnType(ResultSet rs) throws SQLException {
        ResultSetMetaData rmd = rs.getMetaData();
        int colNum = rmd.getColumnCount();
        int[] colType = new int[colNum];
        for (int i = 0; i < colNum; i++) {
            colType[i] = rmd.getColumnType(i+1);
        }
        return colType;
    }

    /**
     * return the ResultSet object of a table
     * This is for illustration ONLY, NOT practically useful.  The string tn (suppose to be a table name) invites
     * grave vulnerability.  You can test on it.
     */
    public ResultSet getTable(String tn) throws SQLException {
        String str = "SELECT * FROM " + tn;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(str);
        return rs;
    }

    /** convert a ResultSet to a two-dimensional array of String
     */
    public ArrayList<String[]> resultSet2DArray(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int col = rsmd.getColumnCount();
        ArrayList<String[]> al = new ArrayList<String[]>(1);
        while (rs.next()) {
            String[] row = new String[col];
            for (int i = 0; i < col; i++) {
                Object obj = rs.getObject(i+1);
                if (obj != null)
                    row[i] = obj.toString();
                else
                    row[i] = "";
            }
            al.add(row);
        }
        return al;
    }

    /** tester
     */
    public static void main(String[] args) throws SQLException {
        if (args.length == 1) {
            System.out.println("usage: java SampleQuery db-IP dp-SID");
            System.exit(1);
        }
        DBConnection dbc;
        if (args.length == 0)
            dbc = new DBConnection("dbsvcs.cs.uno.edu", 1521, "orcl");
        else
            dbc = new DBConnection(args[0], 1521, args[1]);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("User Name: ");
//        String username = scanner.nextLine();
//        System.out.println("passcode: ");
//        String dbpassword = scanner.nextLine();
//        scanner.close();

        //Connection conn = dbc.getDBConnection(username, dbpassword);
        //Connection conn = dbc.getDBConnection("aschill", "KHqM7k9j");
        Connection conn = dbc.getDBConnection("ssavoie1", "bHHq3Rxr");	//auto login
        Controller controller = new Controller(conn);
        
        controller.showMenu();
    }
}

