package smarttraffic;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.time.LocalTime;

// ================= VEHICLE EVENT =================
class VehicleEvent {
    String vehicleId;
    double speed;
    String zone;
    boolean emergency;
    long timestamp;

    public VehicleEvent(String vehicleId, double speed, String zone, boolean emergency, long timestamp) {
        this.vehicleId = vehicleId;
        this.speed = speed;
        this.zone = zone;
        this.emergency = emergency;
        this.timestamp = timestamp;
    }
}

// ================= VIOLATION =================
class Violation {
    String vehicleId;
    double speed;
    String zone;
    int fine;

    public Violation(String vehicleId, double speed, String zone, int fine) {
        this.vehicleId = vehicleId;
        this.speed = speed;
        this.zone = zone;
        this.fine = fine;
    }
}

// ================= TRAFFIC RULES =================
class TrafficRules {

    static Predicate<VehicleEvent> violationFilter = event -> {
        double limit = getSpeedLimit(event.zone);

        // Anomaly detection
        if (event.speed > 200) {
            System.out.println("⚠ Suspicious speed: " + event.speed);
        }

        return event.speed > limit && !event.emergency;
    };

    static double getSpeedLimit(String zone) {
        LocalTime now = LocalTime.now();

        if ("School".equalsIgnoreCase(zone)
                && now.isAfter(LocalTime.of(8, 0))
                && now.isBefore(LocalTime.of(16, 0))) {
            return 40;
        }
        return 80;
    }

    static Function<Double, Integer> fineCalculator = speed -> {
        if (speed > 120) return 5000;
        else if (speed > 100) return 2000;
        else return 1000;
    };
}

// ================= MAIN SYSTEM =================
public class SmartTrafficSystem {

    public static List<Violation> processEvents(List<VehicleEvent> events) {

        return events.stream()
                .filter(e -> e.speed > 0)
                .filter(TrafficRules.violationFilter)
                .map(event -> {

                    String vehicleId = Optional.ofNullable(event.vehicleId).orElse("UNKNOWN");
                    String zone = Optional.ofNullable(event.zone).orElse("UNKNOWN_ZONE");

                    int fine = TrafficRules.fineCalculator.apply(event.speed);

                    // Repeat offender logic
                    int count = ViolationDAO.getViolationCount(vehicleId);
                    if (count >= 3) fine *= 2;

                    Violation v = new Violation(vehicleId, event.speed, zone, fine);

                    // Notification
                    System.out.println("📩 ALERT: " + vehicleId + " fined Rs." + fine);

                    // Save to DB
                    ViolationDAO.saveViolation(v, event.timestamp);

                    return v;
                })
                .collect(Collectors.toList());
    }
}