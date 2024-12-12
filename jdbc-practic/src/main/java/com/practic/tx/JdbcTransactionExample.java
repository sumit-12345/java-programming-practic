package com.practic.tx;

import java.sql.*;

public class JdbcTransactionExample {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/javaprojs", "root", "Sambit.joshi@01");
            System.out.println("Connection Established..");
            stmt = conn.createStatement();
            System.out.println("Statement Crated...");

            conn.setAutoCommit(false);

            String insertQuery1 = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (1, 'John Doe', '123 Main St, City', 101, 85.5)";
            String insertQuery2 = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (2, 'Sam', '123 Main St, City', 101, 85.5)";
            String insertQuery3 = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (3, 'Mike', '123 Main St, City', 101, 85.5)";
            String insertQuery4 = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (4, 'Nick', '123 Main St, City', 102, 85.5)";
            String insertQuery5 = "INSERT INTO student (id, name, address, roll_no, mark) " +
                    "VALUES (5, 'Goutam', '123 Main St, City', 101, 85.5)";

            int rowsInserted = stmt.executeUpdate(insertQuery1);
            System.out.println("Rows1 inserted: " + rowsInserted);

            rowsInserted = stmt.executeUpdate(insertQuery2);
            System.out.println("Rows2 inserted: " + rowsInserted);

            rowsInserted = stmt.executeUpdate(insertQuery3);
            System.out.println("Rows3 inserted: " + rowsInserted);

            rowsInserted = stmt.executeUpdate(insertQuery4);
            System.out.println("Rows4 inserted: " + rowsInserted);

            rowsInserted = stmt.executeUpdate(insertQuery5);
            System.out.println("Rows5 inserted: " + rowsInserted);

            conn.commit();

        } catch (SQLException e) {
            // If there's an error, roll back the transaction
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transaction rolled back due to error");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            // Close the resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
