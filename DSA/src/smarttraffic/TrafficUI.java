package smarttraffic;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

public class TrafficUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Smart Traffic System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(7, 2, 10, 10));

        JTextField vehicleField = new JTextField();
        JTextField speedField = new JTextField();
        JTextField zoneField = new JTextField();
        JCheckBox emergencyBox = new JCheckBox("Emergency Vehicle");

        JTextArea outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        JButton processBtn = new JButton("Process Event");

        frame.add(new JLabel("Vehicle ID:"));
        frame.add(vehicleField);

        frame.add(new JLabel("Speed:"));
        frame.add(speedField);

        frame.add(new JLabel("Zone:"));
        frame.add(zoneField);

        frame.add(emergencyBox);
        frame.add(new JLabel(""));

        frame.add(processBtn);
        frame.add(new JScrollPane(outputArea));

        processBtn.addActionListener(_ -> {
            try {
                String id = vehicleField.getText();
                double speed = Double.parseDouble(speedField.getText());
                String zone = zoneField.getText();
                boolean isEmergency = emergencyBox.isSelected();

                VehicleEvent event = new VehicleEvent(
                        id, speed, zone, isEmergency,
                        System.currentTimeMillis()
                );

                List<VehicleEvent> events = List.of(event);

                List<Violation> violations =
                        SmartTrafficSystem.processEvents(events);

                if (violations.isEmpty()) {
                    outputArea.setText("No violation detected.");
                } else {
                    Violation v = violations.get(0);
                    outputArea.setText(
                            "🚨 Violation Detected!\n" +
                                    "Vehicle: " + v.vehicleId + "\n" +
                                    "Speed: " + v.speed + "\n" +
                                    "Zone: " + v.zone + "\n" +
                                    "Fine: Rs." + v.fine
                    );
                }

            } catch (NumberFormatException ex) {
                outputArea.setText("Speed must be a valid number!");
            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}