/*
 * Created on Jul 18, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.new_employee_program;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

//import java.sql.*;
/**
 * @author Shengru Tu
 */
public class DBConnection {

    private String dbLocation;
    final String oraThinProtocol = "jdbc:oracle:thin";
    // final String msSQLProtocol = "jdbc:sqlserver";
    //final String dbLocation = "@dbsvcs.cs.uno.edu:1521:orcl";

    /** two constructors
     */
    public DBConnection (String sID) { 
        this.dbLocation = "@localhost:1521:" + sID;
    }

    public DBConnection (String host, int port, String sID) {
        this.dbLocation = "@" + host + ":" + port + ":" + sID; // for Oracle
        // this.dbLocation = "//" + host + ":" + port + ";" + sID; // for MS SQL
    }

    /** create a JDBC connection 	 */
    public Connection getDBConnection(String username, String password) throws SQLException {
        // register the JDBC driver.
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); // for Oracle
        String url = oraThinProtocol + ':' + dbLocation;
        // DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver()); // for MS SQL
        // Create the connection
        // String url = msSQLProtocol + ':' + dbLocation;
        System.out.println("[TableInfo:] url = " + url);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /** create a JDBC connection 	 */
    public Connection getDBConnection() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Name: ");
        String username = scanner.nextLine();
        System.out.println("passcode: ");
        String dbpassword = scanner.nextLine();
        scanner.close();
        return getDBConnection(username, dbpassword);
    }
}
