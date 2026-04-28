package smarttraffic;

import java.sql.*;
import java.util.*;

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

    public static int getViolationCount(String vehicleId) {

        String sql = "SELECT COUNT(*) FROM violations WHERE vehicle_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehicleId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Map<String, Integer> getZoneStats() {

        Map<String, Integer> map = new HashMap<>();

        String sql = "SELECT zone, COUNT(*) FROM violations GROUP BY zone";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                map.put(rs.getString(1), rs.getInt(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}