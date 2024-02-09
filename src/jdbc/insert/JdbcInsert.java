package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcinsertexample";
        String username = "root";
        String password = "*****";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create an SQL INSERT statement with placeholders
            String insert1 = "INSERT INTO UserInfo (First_Name, Last_Name, Email, Password) VALUES (?, ?, ?, ?)";
            String insert2 = "INSERT INTO UserInfo (First_Name, Last_Name, Email, Password) VALUES (?, ?, ?, ?)";
            String insert3 = "INSERT INTO UserInfo (First_Name, Last_Name, Email, Password) VALUES (?, ?, ?, ?)";

            // Create PreparedStatements to execute the SQL statements
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(insert2);
            PreparedStatement preparedStatement3 = connection.prepareStatement(insert3);

            // Data to be inserted for the first record
            String first_name1 = "Oseh";
            String last_name1 = "Akhigbe";
            String email1 = "oseh_akhigbe@yahoo.com";
            String pass1 = "osehakhi2023";

            // Data to be inserted for the second record
            String first_name2 = "Bianca";
            String last_name2 = "Rosetti";
            String email2 = "biancarose@yahoo.com";
            String pass2 = "rose_b127";

            // Data to be inserted for the third record
            String first_name3 = "Joseph";
            String last_name3 = "Morgan";
            String email3 = "joemorg@gmail.com";
            String pass3 = "josephjaphat";

            // Set values for the placeholders for the first record
            preparedStatement1.setString(1, first_name1);
            preparedStatement1.setString(2, last_name1);
            preparedStatement1.setString(3, email1);
            preparedStatement1.setString(4, pass1);

            // Set values for the placeholders for the second record
            preparedStatement2.setString(1, first_name2);
            preparedStatement2.setString(2, last_name2);
            preparedStatement2.setString(3, email2);
            preparedStatement2.setString(4, pass2);

            // Set values for the placeholders for the third record
            preparedStatement3.setString(1, first_name3);
            preparedStatement3.setString(2, last_name3);
            preparedStatement3.setString(3, email3);
            preparedStatement3.setString(4, pass3);

            // Execute the INSERT statements for all three records
            int rowsAffected1 = preparedStatement1.executeUpdate();
            int rowsAffected2 = preparedStatement2.executeUpdate();
            int rowsAffected3 = preparedStatement3.executeUpdate();

            if (rowsAffected1 > 0) {
                System.out.println("Record 1 inserted successfully.");
            } else {
                System.out.println("Failed to insert record 1.");
            }

            if (rowsAffected2 > 0) {
                System.out.println("Record 2 inserted successfully.");
            } else {
                System.out.println("Failed to insert record 2.");
            }

            if (rowsAffected3 > 0) {
                System.out.println("Record 3 inserted successfully.");
            } else {
                System.out.println("Failed to insert record 3.");
            }

            // Close resources
            preparedStatement1.close();
            preparedStatement2.close();
            preparedStatement3.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
