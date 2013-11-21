import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//Coded by Jeff Andolora, 11/19/13
//GUI For Main Menu

public class MainGUI {
	
	//Instantiating form elements
	JButton viewButton = new JButton("View Existing");
	JButton updateButton = new JButton("Update Existing");
	JButton addButton = new JButton("Add New");
	JButton exitButton = new JButton("Exit Program");
	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JLabel infoLabel1 = new JLabel("Click a button to open that section of the program");

	public void startGUI() {
		
		//Set up form and panels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(MainPanel,BorderLayout.CENTER);
		topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		MainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.setLocationRelativeTo(null); 
		
		//Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
		topPanel.setLayout(new GridLayout(1,1,0,0));
	    MainPanel.setLayout(new GridLayout(2,2,10,10));
	    topPanel.add(infoLabel1);
	    MainPanel.add(addButton);
	    MainPanel.add(viewButton);
	    MainPanel.add(updateButton);
	    MainPanel.add(exitButton);
	    
	    //Classes below are called on Button Click
	    addButton.addActionListener(new addButtonListener());
	    viewButton.addActionListener(new viewButtonListener());
	    updateButton.addActionListener(new updateButtonListener());
	    exitButton.addActionListener(new exitButtonListener());

	    //Opens form window
	    frame.setVisible(true);
	}

	class addButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addButton.setBackground(Color.PINK);
			addMenu view2 = new addMenu();
			view2.startGUI();
			frame.setVisible(false);
		}
	}
	class viewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			viewButton.setBackground(Color.PINK);	
		}		
	}
	class updateButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			updateButton.setBackground(Color.PINK);
		}
	}
	class exitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
	
	
	
	