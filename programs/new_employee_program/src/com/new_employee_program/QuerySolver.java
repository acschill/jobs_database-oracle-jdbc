package com.new_employee_program;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QuerySolver {
    Connection conn;

    public QuerySolver(String host, int port, String dbSID) throws SQLException {
        conn = new DBConnection(host, port, dbSID).getDBConnection();
    }
    
    public ArrayList<Row> listStaffSalary(String companyName) throws SQLException {
        ArrayList<Row> result = new ArrayList<Row>();
        String sqlStr = "SELECT pid, name, salary FROM person NATUARL JOIN works NATURAL JOIN company " +
                "WHERE payType = 'Salary' AND companyname = ? ORDER BY slary DESC";
        PreparedStatement pStmt = conn.prepareStatement(sqlStr);
        pStmt.setString(1, companyName);
        ResultSet rst = pStmt.executeQuery();
        while (rst.next()) {
            String pid = rst.getString(1);
            String name = rst.getString("name");
            double salary = rst.getDouble(3);
            result.add(new Row(pid, name, salary));
        }
        return result;
    }
    public ArrayList<Row> listEmployeePay(String companyName, String payType) throws SQLException {
        ArrayList<Row> result = new ArrayList<Row>();
        String sqlStr = "SELECT pid, name, salary FROM person NATUARL JOIN works NATURAL JOIN company " +
                "WHERE companyname = ? AND payType = ? D ORDER BY slary DESC";
        PreparedStatement pStmt = conn.prepareStatement(sqlStr);
        pStmt.setString(1, companyName);
        pStmt.setString(2, payType);
        ResultSet rst = pStmt.executeQuery();
        while (rst.next()) {
            String pid = rst.getString(1);
            String name = rst.getString("name");
            double salary = rst.getDouble(3);
            result.add(new Row(pid, name, salary));
        }
        return result;
    }
    public static void main(String[] args) throws SQLException {
        if (args.length != 3) {
            System.out.println("usage: java QuerySolver db-IP db-port dp-SID");
            System.exit(1);
        }
        int port = Integer.parseInt(args[1]);
        QuerySolver qs = new QuerySolver(args[0], port, args[2]);
        ArrayList<Row> result = qs.listStaffSalary("GE Digital");
        for (Row row : result) {
            System.out.printf("%s %s: $%8.2f%n", row.getpId(), row.getName(), row.getAmount());
        }
        result = qs.listEmployeePay("GE Digital", "Wage");
        for (Row row : result) {
            System.out.printf("%s %s: $%8.2f%n", row.getpId(), row.getName(), row.getAmount());
        }
    }
    class Row {
        String pId, name;
        double amount;
        Row(String id, String name, double amount) {
            this.pId = id; this.name = name; this.amount = amount;
        }
        public String getpId() {
            return pId;
        }
        public String getName() {
            return name;
        }
        public double getAmount() {
            return amount;
        }
    }
}

