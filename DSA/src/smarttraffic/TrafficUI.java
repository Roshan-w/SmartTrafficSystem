package smarttraffic;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

// JFreeChart
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class TrafficUI {

    public static void main(String[] args) {

        // ✅ System Look & Feel (important for production look)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Smart Traffic System");
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== SIDEBAR =====
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        JButton processBtn = createMenuButton("Process");
        JButton dashboardBtn = createMenuButton("Dashboard");
        JButton graphBtn = createMenuButton("Analytics");

        JLabel title = new JLabel("  Traffic System");
        title.setForeground(Color.BLACK);

        sidebar.add(title);
        sidebar.add(processBtn);
        sidebar.add(dashboardBtn);
        sidebar.add(graphBtn);

        frame.add(sidebar, BorderLayout.WEST);

        // ===== MAIN PANEL =====
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ===== INPUT PANEL =====
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 12));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(220, 220, 220)),
                        "Vehicle Input"
                )
        );

        JTextField vehicle = new JTextField();
        JTextField speed = new JTextField();
        JTextField zone = new JTextField();
        JCheckBox emergency = new JCheckBox("Emergency");

        emergency.setBackground(Color.WHITE);

        inputPanel.add(label("Vehicle ID"));
        inputPanel.add(vehicle);
        inputPanel.add(label("Speed"));
        inputPanel.add(speed);
        inputPanel.add(label("Zone"));
        inputPanel.add(zone);
        inputPanel.add(new JLabel(""));
        inputPanel.add(emergency);

        // ===== OUTPUT =====
        JTextArea output = new JTextArea();
        output.setBackground(Color.WHITE);
        output.setForeground(Color.BLACK);
        output.setFont(new Font("Consolas", Font.PLAIN, 13));
        output.setEditable(false);

        JScrollPane outputPane = new JScrollPane(output);
        outputPane.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(new Color(220, 220, 220)),
                        "Live Output"
                )
        );

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(outputPane, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====
        processBtn.addActionListener(_ -> {
            try {
                VehicleEvent e = new VehicleEvent(
                        vehicle.getText(),
                        Double.parseDouble(speed.getText()),
                        zone.getText(),
                        emergency.isSelected(),
                        System.currentTimeMillis()
                );

                List<Violation> v = SmartTrafficSystem.processEvents(List.of(e));

                if (v.isEmpty()) {
                    output.setText("No violation detected.");
                } else {
                    Violation x = v.get(0);
                    output.setText(
                            "Violation Detected\n\n" +
                                    "Vehicle: " + x.vehicleId +
                                    "\nSpeed: " + x.speed +
                                    "\nZone: " + x.zone +
                                    "\nFine: Rs." + x.fine
                    );
                }

            } catch (Exception ex) {
                output.setText("Invalid input.");
            }
        });

        dashboardBtn.addActionListener(_ -> showDashboard());
        graphBtn.addActionListener(_ -> showGraph());

        frame.setVisible(true);
    }

    // ===== UI HELPERS =====

    static JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(245, 245, 245));
        btn.setForeground(Color.BLACK);
        btn.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        return btn;
    }

    static JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(Color.DARK_GRAY);
        return l;
    }

    // ===== DASHBOARD =====
    static void showDashboard() {
        JFrame f = new JFrame("Violations");
        f.setSize(700, 400);

        try {
            var conn = DBConnection.getConnection();
            var rs = conn.createStatement().executeQuery(
                    "SELECT vehicle_id, speed, zone, fine FROM violations"
            );

            java.util.List<Object[]> list = new java.util.ArrayList<>();

            while (rs.next()) {
                list.add(new Object[]{
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getInt(4)
                });
            }

            JTable table = new JTable(
                    list.toArray(new Object[0][]),
                    new String[]{"Vehicle", "Speed", "Zone", "Fine"}
            );

            f.add(new JScrollPane(table));

        } catch (Exception e) {
            e.printStackTrace();
        }

        f.setVisible(true);
    }

    // ===== GRAPH =====
    static void showGraph() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> map = ViolationDAO.getZoneStats();

        map.forEach((zone, count) ->
                dataset.addValue(count, "Violations", zone)
        );

        JFreeChart chart = ChartFactory.createBarChart(
                "Violations by Zone",
                "Zone",
                "Count",
                dataset
        );

        JFrame frame = new JFrame("Analytics");
        frame.setSize(600, 400);
        frame.add(new ChartPanel(chart));
        frame.setVisible(true);
    }
}