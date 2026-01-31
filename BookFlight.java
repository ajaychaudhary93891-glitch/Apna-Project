/*
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event .*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;


public class BookFlight extends JFrame implements ActionListener {
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress,lblphone,labelgender,labelname,labelcode;
    JButton bookflight,flight,fatchButton;
    Choice source,destination;
    JDateChooser dcdate;
    
    
   public BookFlight()
   {
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       // ADD CUSTOMER DETAILS
       
       JLabel heading = new JLabel("Book Flight");
       heading.setBounds(420, 20, 500, 35);
       heading.setFont(new Font("Tahoma",Font.BOLD,32));
       heading.setForeground(Color.BLUE);
       add(heading);
       
       // AAdhar
       
       JLabel lblaadhar = new JLabel("Aadhar");
       lblaadhar.setBounds(60, 80, 150, 25);
       lblaadhar.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblaadhar);
        
       tfaadhar = new JTextField();
       tfaadhar.setBounds(220, 80, 150, 25);
       add(tfaadhar);
       
       fatchButton = new JButton("Fatch");
       fatchButton.setBackground(Color.BLACK);
       fatchButton.setFont(new Font("Tahoma",Font.PLAIN,16));
       fatchButton.setBounds(380, 80, 120, 25);
       add(fatchButton);
       
       // Name
       
       JLabel lblname = new JLabel("Name");
       lblname.setBounds(60, 80, 150, 25);
       lblname.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblname);
        
       tfname = new JLabel();
       tfname.setBounds(220, 80, 150, 25);
       add(tfname);
       
       // Nationality
       
       JLabel lblnationality = new JLabel("Nationality");
       lblnationality.setBounds(60, 180, 150, 25);
       lblnationality.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblnationality);
        
       tfnationality = new JLabel();
       tfnationality.setBounds(220, 180, 150, 25);
       add(tfnationality);
       
       // Address
       
       JLabel lbladdress = new JLabel("Address");
       lbladdress.setBounds(60, 230, 150, 25);
       lbladdress.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lbladdress);
        
       tfaddress = new JLabel();
       tfaddress.setBounds(220, 230, 150, 25);
       add(tfaddress);
       
       // Gender
       
       JLabel lblgender = new JLabel("Gender");
       lblgender.setBounds(60, 280, 150, 25);
       lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblgender);
       
       labelgender = new JLabel("Gender");
       labelgender.setBounds(220, 280, 150, 25);
       add(labelgender);
       
       // Source 
       
       JLabel lblsource = new JLabel("Source");
       lblsource.setBounds(60, 380, 150, 25);
       lblsource.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblsource);
       
       source = new Choice();
       source.setBounds(220, 330, 150, 25);
       add(source);
       
       // Destination
       
       JLabel lbdest = new JLabel("Destination");
       lbdest.setBounds(60, 280, 150, 25);
       lbdest.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lbdest);
       
       destination = new Choice();
       destination.setBounds(220, 380, 150, 25);
       add(destination);
       
       // Connct Source and Destination data
       
       try{
            Conne conn = new Conne();
            String query = "Select * from flight";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next())
            {
                source.add(rs.getString("Source"));
                destination.add(rs.getString("destination"));
            }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

       // CHECK FLIGHT
       
       flight = new JButton("CHECK FLIGHT");
       flight.setBackground(Color.BLACK);
       flight.setForeground(Color.WHITE);
       flight.setBounds(380, 380, 120, 25);
       flight.addActionListener(this);
       add(flight);
       
       //  Flight Name
       
       JLabel lblfname = new JLabel("Flight Name");
       lblfname.setBounds(60, 430, 150, 25);
       lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblfname); 
       
       labelgender = new JLabel();
       labelgender.setBounds(220, 280, 150, 25);
       add(labelgender);
       
       //  Flight Code
       
       JLabel lblfcode = new JLabel("Flight Code");
       lblfcode.setBounds(60, 480, 150, 25);
       lblfcode.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lblfcode); 
       
       labelcode = new JLabel("Gender");
       labelcode.setBounds(220, 280, 150, 25);
       add(labelcode);
       
       //  Date of Travel
       
       JLabel lbldate = new JLabel("Date of Travel");
       lbldate.setBounds(60, 530, 150, 25);
       lbldate.setFont(new Font("Tahoma",Font.BOLD,16));
       add(lbldate); 
       
       dcdate = new JDateChooser();
       dcdate.setBounds(220, 530, 150, 25);
       add(dcdate);

       // ImageIcon 
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.png"));
       Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
       ImageIcon image = new ImageIcon(i2);
       JLabel lblimage = new JLabel(i1);
       lblimage.setBounds(550, 80, 500, 410);
       add(lblimage);
       
       // CHECK FLIGHT
       
       bookflight = new JButton("BOOk    FLIGHT");
       bookflight.setBackground(Color.BLACK);
       bookflight.setForeground(Color.WHITE);
       bookflight.setBounds(220, 580, 150, 25);
       bookflight.addActionListener(this);
       add(bookflight);
       
       setSize(1100,700);
       setLocation(250,100);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource() == fatchButton){
           String aadhar = tfaadhar.getText();
       }
       try{
           Conne conn = new Conne();
   
           String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
            ResultSet rs = conn.s.executeQuery(query);

           if(rs.next())
           {
               tfname.setText(rs.getString("name"));
               tfnationality.setText(rs.getString("nationality"));
               tfaddress.setText(rs.getString("address"));
               labelgender.setText(rs.getString("gender"));
           }
           else
           {
               JOptionPane.showMessageDialog(null, "User don't Exists Plrase Enter Correct Aadhar");
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   public static void main(String args[])
   {
   new BookFlight();
   }
}
*/

package airlinemanagementsystem; 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress,labelgender,labelcode,labelfname;
    JButton bookflight,flight,fetchButton;
    Choice source,destination;
    JDateChooser dcdate;

    public BookFlight() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        heading.setForeground(Color.BLUE);
        add(heading);

        // AADHAR
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);

        fetchButton = new JButton("Fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setFont(new Font("Tahoma",Font.PLAIN,16));
        fetchButton.setBounds(380, 80, 120, 25);
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
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 250, 25);
        add(tfnationality);

        // ADDRESS
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 250, 25);
        add(tfaddress);

        // GENDER
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 250, 25);
        add(labelgender);

        // SOURCE
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        // DESTINATION
        JLabel lbdest = new JLabel("Destination");
        lbdest.setBounds(60, 380, 150, 25);
        lbdest.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbdest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        // LOAD SOURCE & DESTINATION
        try{
            Conne conn = new Conne();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");

            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        // CHECK FLIGHT BUTTON
        flight = new JButton("CHECK FLIGHT");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 150, 25);
        flight.addActionListener(this);
        add(flight);

        // FLIGHT NAME
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 250, 25);
        add(labelfname);

        // FLIGHT CODE
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfcode);

        labelcode = new JLabel();
        labelcode.setBounds(220, 480, 250, 25);
        add(labelcode);

        // DATE
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        // ImageIcon 
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/Book.png"));
       Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
       ImageIcon image = new ImageIcon(i2);

       JLabel lblimage = new JLabel(image);
       lblimage.setBounds(550, 80, 500, 600);
       add(lblimage);

       
        // BOOK BUTTON
        bookflight = new JButton("BOOK FLIGHT");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        setSize(1100,700);
        setLocation(140,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // FETCH BUTTON CLICKED
        if(ae.getSource() == fetchButton){

            String aadhar = tfaadhar.getText();

            try{
                Conne conn = new Conne();

                String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                }
                else {
                    JOptionPane.showMessageDialog(null,"User not found — Enter correct Aadhar");
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        else if(ae.getSource() == flight){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try{
                Conne conn = new Conne();

                String query = "SELECT * FROM flight WHERE source = '" + src + "' and destination = '"+dest+"'";
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()) {
                    labelfname.setText(rs.getString("f_name"));
                    labelcode.setText(rs.getString("f_code"));
                } 
                else {
                    JOptionPane.showMessageDialog(null,"No Flights found");
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try{
                Conne conn = new Conne();
                String query ="INSERT INTO reservation VALUES ('PNR-" + random.nextInt(1000000) + "','TIC-" + random.nextInt(10000) +"','" + aadhar +"','" + name +"','" + nationality +"','" + flightname +"','" + flightcode +"','" + src +"','" + dest +"','" + ddate + "')";
             
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        new BookFlight();
    }
}
