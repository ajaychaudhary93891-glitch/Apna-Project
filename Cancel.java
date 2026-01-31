package airlinemanagementsystem; 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, cancellation, lblcode,lbldate;
    JButton flight,fetchButton;

    public Cancel() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Cancellation");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        // Image 
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/airlinemanagementsystem/icons/Cut.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        image.setBounds(460, 120, 250, 250);
        add(image);
        
                

        // PNR number 
        
        JLabel lblaadhar = new JLabel("PNR Number:");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setFont(new Font("Tahoma",Font.PLAIN,16));
        fetchButton.setBounds(380, 80, 150, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        // NAME
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 250, 25);
        add(tfname);

        // NATIONALITY
        Random random = new Random();
        
        JLabel lblnationality = new JLabel("Cancellation No.");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnationality);

        cancellation = new JLabel(""+ random.nextInt(1000000));
        cancellation.setBounds(220, 180, 250, 25);
        add(cancellation);

        // ADDRESS
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbladdress);

        lblcode = new JLabel();
        lblcode.setBounds(220, 230, 250, 25);
        add(lblcode);

        // GENDER
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblgender);

        lbldate = new JLabel();
        lbldate.setBounds(220, 280, 250, 25);
        add(lbldate);


        // CHECK FLIGHT BUTTON
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 150, 25);
        flight.addActionListener(this);
        add(flight);

        setSize(800,450);
        setLocation(350,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // FETCH BUTTON CLICKED
        if(ae.getSource() == fetchButton){

            String pnr = tfpnr.getText();

            try{
                Conne conn = new Conne();

                String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()) {
                    tfname.setText(rs.getString("name"));
                    lblcode.setText(rs.getString("flightcode"));
                    lbldate.setText(rs.getString("ddate"));
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please Enter Correct PNR");
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        else if(ae.getSource() == flight){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellation.getText();
            String fcode =  lblcode.getText();
            String date = lbldate.getText();

            try{
                Conne conn = new Conne();

                String query = "Insert into cancel values ('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
                conn.s.executeUpdate(query);
                
                conn.s.executeUpdate("delete from reservation where PNR =  '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null,"Ticked Canceled");
                setVisible(false);
 
            } catch(Exception e){
                e.printStackTrace();
            }
        } 
    }
    public static void main(String args[]) {
        new Cancel();
    }
}
