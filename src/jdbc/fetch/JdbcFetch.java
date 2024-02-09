package jdbc.fetch;

import java.sql.*;

public class JdbcFetch {
    public static void main(String[] arg) {

            // Database connection parameters
            String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcinsertexample";
            String username = "root";
            String password = "*****";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create an SQL SELECT statement
            String select = "SELECT User_ID, First_Name, Last_Name, Email FROM UserInfo";

            // Create a PreparedStatement to execute the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            // Execute the SELECT statement and retrieve the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Loop and process the result set
            while (resultSet.next()) {
                int userId = resultSet.getInt("User_ID");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String email = resultSet.getString("Email");

                System.out.println("User ID: " + userId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println();
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
