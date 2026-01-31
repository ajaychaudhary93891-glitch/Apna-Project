package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    public Home() {
    setLayout(null);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airline_home.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(-40, 0, 1600, 800);
    add(image);
    
    JLabel heading = new JLabel("Welcome to India — Fly the Skies with Us");
    heading.setBounds(420, 60, 700, 100);
    heading.setForeground(Color.BLUE);
    heading.setFont(new Font("serif",Font.PLAIN,36));
    image.add(heading);
    
    JMenuBar menubar = new JMenuBar();
    setJMenuBar(menubar);
    
    JMenu details = new JMenu("Details");
    menubar.add(details);
    
    JMenuItem flightDetails = new JMenuItem("Flight Details");
    flightDetails.addActionListener(this);
    details.add(flightDetails);
    
    JMenuItem customerDetails = new JMenuItem("Add Customer Details");
    customerDetails.addActionListener(this);
    details.add(customerDetails);
    
    JMenuItem bookFlight = new JMenuItem("Book Flight");
    bookFlight.addActionListener(this);
    details.add(bookFlight);
    
    JMenuItem journeyDetails = new JMenuItem("Journey Details");
    journeyDetails.addActionListener(this);
    details.add(journeyDetails);
    
    JMenuItem  ticketCancellation= new JMenuItem("Ticket Cancel");
    ticketCancellation.addActionListener(this);
    details.add(ticketCancellation);
    
    JMenu tickets = new JMenu("Tickes");
    menubar.add(tickets);
    
    JMenuItem boardingPass = new JMenuItem("Boarding Pass");
    boardingPass.addActionListener(this);
    tickets.add(boardingPass);
    

    setExtendedState(JFrame.MAXIMIZED_BOTH); // Autometic full size Screen image
    setVisible(true);   
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer(); 
        }
        else if(text.equals("Flight Details")){
            new Flightinfo();
        }
        else if(text.equals("Book Flight")){
            new BookFlight();
        }
        else if(text.equals("Journey Details")){
            new JourneyDetails();  
        }
        else if(text.equals("Ticket Cancel")){
            new Cancel();
        }
        else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
