package smarttraffic;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return "Vehicle: " + vehicleId +
                " | Speed: " + speed +
                " | Zone: " + zone +
                " | Fine: Rs." + fine;
    }
}

class TrafficRules {

    static Predicate<VehicleEvent> violationFilter = event ->
            event.speed > 80 && !event.emergency;

    static Function<Double, Integer> fineCalculator = speed -> {
        if (speed > 120) return 5000;
        else if (speed > 100) return 2000;
        else return 1000;
    };
}

public class SmartTrafficSystem {

    public static List<Violation> processEvents(List<VehicleEvent> events) {

        return events.stream()
                .filter(event -> event.speed > 0)
                .filter(TrafficRules.violationFilter)
                .map(event -> {

                    String vehicleId = Optional.ofNullable(event.vehicleId).orElse("UNKNOWN");
                    String zone = Optional.ofNullable(event.zone).orElse("UNKNOWN_ZONE");
                    int fine = TrafficRules.fineCalculator.apply(event.speed);

                    Violation v = new Violation(vehicleId, event.speed, zone, fine);

                    // DB SAVE
                    ViolationDAO.saveViolation(v, event.timestamp);

                    return v;
                })
                .toList(); // Java 16+
    }

    public static void main(String[] args) {

        List<VehicleEvent> events = List.of(
                new VehicleEvent("MH12DV1234", 90, "Pune-West", false, System.currentTimeMillis()),
                new VehicleEvent("MH12AB5678", 130, "Pune-East", false, System.currentTimeMillis()),
                new VehicleEvent("MH11SD4444", 110, null, false, System.currentTimeMillis()),
                new VehicleEvent("MH12DV1234", 70, "Mumbai", false, System.currentTimeMillis()),
                new VehicleEvent("MH12DV1234", 140, "Pune-West", true, System.currentTimeMillis())
        );

        List<Violation> violations = processEvents(events);

        violations.forEach(System.out::println);

        int totalFine = violations.stream()
                .map(v -> v.fine)
                .reduce(0, Integer::sum);

        long totalViolations = violations.size();

        System.out.println("\nTotal Violations: " + totalViolations);
        System.out.println("Total Fine Collected: Rs." + totalFine);

        Map<String, Long> violationsByZone = violations.stream()
                .collect(Collectors.groupingBy(v -> v.zone, Collectors.counting()));

        System.out.println("\nViolations by Zone:");
        violationsByZone.forEach((zone, count) ->
                System.out.println(zone + " -> " + count));
    }
}