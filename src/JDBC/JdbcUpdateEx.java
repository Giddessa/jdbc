package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateEx {
    public static void main(String[] args) {

        //Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcinsertexample";
        String username = "root";
        String password = "*****";

        try{
            //Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            //Define the update SQL statement with placeholders
            String updateSql = "UPDATE USerInfo SET Email = ? WHERE User_ID = ?";

            //Create a PreparedStatement to execute the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);

            //Set the new email and User ID values
            String newEmail = "joseph_morgan@yahoo.com";
            int userIdToUpdate = 3;

            //Set the value for the placeholder
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, userIdToUpdate);

            // Execute the UPDATE statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No records were updated.");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
}
