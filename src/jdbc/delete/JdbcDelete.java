package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteEx {
    public static void main(String [] arg) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcinsertexample";
        String username = "root";
        String password = "*****";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Define the delete SQL statement with a placeholder
            String deleteSql = "DELETE FROM UserInfo WHERE User_ID = ?";

            // Create a PreparedStatement to execute the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);

            // Set the User_ID of the record to delete
            int userIdToDelete = 3; // Delete the user with User_ID 1

            // Set the value for the placeholder
            preparedStatement.setInt(1, userIdToDelete);

            // Execute the DELETE statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No records were deleted.");
            }

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
