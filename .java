import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Method to insert user information into the database
    public static void insertUser(String username, String email, String phone, String gender, String birthDate, String address, String password) {
        String sql = "INSERT INTO users (username, email, phone, gender, birth_date, address, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, gender);
            statement.setString(5, birthDate);
            statement.setString(6, address);
            statement.setString(7, password);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
