package repository;
import utils.DatabaseConnection;
import java.sql.*;

public class MediaRepository {
    public void save(String title, String type) throws SQLException {
        String sql = "INSERT INTO media (title, type) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, type);
            pstmt.executeUpdate();
        }
    }
}