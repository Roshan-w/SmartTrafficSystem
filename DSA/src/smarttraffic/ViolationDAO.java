package smarttraffic;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ViolationDAO {

    public static void saveViolation(Violation v, long timestamp) {

        String sql = "INSERT INTO violations (vehicle_id, speed, zone, fine, timestamp) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.vehicleId);
            ps.setDouble(2, v.speed);
            ps.setString(3, v.zone);
            ps.setInt(4, v.fine);
            ps.setLong(5, timestamp);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
