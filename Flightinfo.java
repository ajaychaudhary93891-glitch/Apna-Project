@package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flightinfo extends JFrame {

    JTable table;

    public Flightinfo() {

        setTitle("Flight Information");
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // Initialize table
        table = new JTable();

        // Add table inside scroll pane
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

        // Load data from database
        loadFlightData();

        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    private void loadFlightData() {
        try {
            Conne conn = new Conne();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");

            // Convert ResultSet to JTable Model
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading flight data");
        }
    }

    public static void main(String args[]) {
        new Flightinfo();
    }
}
