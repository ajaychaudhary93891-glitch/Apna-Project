package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {

    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails() {

        setTitle("Flight Information");
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // ---------- TOP PANEL ----------
        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);
        top.setLayout(null);
        top.setPreferredSize(new Dimension(800, 100));

        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 30, 100, 25);
        top.add(lblpnr);

        pnr = new JTextField();
        pnr.setBounds(160, 30, 120, 25);
        top.add(pnr);

        show = new JButton("Show");
        show.setBounds(300, 30, 100, 25);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(this);
        top.add(show);

        add(top, BorderLayout.NORTH);

        // ---------- TABLE ----------
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        add(jsp, BorderLayout.CENTER);

        // ---------- WINDOW ----------
        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }

    // -------- BUTTON CLICK EVENT --------
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == show){
            loadTableData();
        }
    }

    // -------- DB SE DATA TABLE ME --------
    public void loadTableData() {
        try {
            Conne conn = new Conne();
            ResultSet rs = conn.s.executeQuery(
                "SELECT * FROM reservation WHERE PNR = '" + pnr.getText() + "'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void main(String args[]) {
        new JourneyDetails();
    }
}
