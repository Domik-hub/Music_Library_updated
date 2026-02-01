package repository;

import model.Media;
import model.Song;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MediaRepository implements CrudRepository<Media> {

    @Override
    public void create(Media entity) throws Exception {
        String sql = "INSERT INTO media (title, artist, type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTitle());
            if (entity instanceof Song) {
                pstmt.setString(2, ((Song) entity).getArtist());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            pstmt.setString(3, entity.getType());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Media> getAll() throws Exception {
        List<Media> list = new ArrayList<>();
        String sql = "SELECT * FROM media";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Song(rs.getInt("id"), rs.getString("title"), rs.getString("artist")));
            }
        }
        return list;
    }

    @Override
    public Media getById(int id) throws Exception {
        String sql = "SELECT * FROM media WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Song(rs.getInt("id"), rs.getString("title"), rs.getString("artist"));
                }
            }
        }
        return null;
    }

    @Override
    public void update(Media entity) throws Exception {
        String sql = "UPDATE media SET title = ?, artist = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getTitle());
            if (entity instanceof Song) {
                pstmt.setString(2, ((Song) entity).getArtist());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            pstmt.setInt(3, entity.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM media WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}