import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addPerscriptionMenu {

	//initialize form elements
	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	//initialize form contents	
	JLabel infoLabel1 = new JLabel("Add a new Perscription");
	JLabel nameLabel = new JLabel("Medicine Name");
	JLabel refillsLabel = new JLabel("Number of Refills");
	JLabel startDateLabel = new JLabel("Start Date");
	JLabel endDateLabel = new JLabel("End Date");
	JLabel physicianLabel = new JLabel("Physician");
	JComboBox nameBox = new JComboBox();
	JTextField refillsText = new JTextField();
	JTextField startDateText = new JTextField();
	JTextField endDateText = new JTextField();
	JComboBox physicianBox = new JComboBox();
	JButton submitButton = new JButton("Save Changes");
	JButton exitButton = new JButton("Exit Program");

	public void startGui(){
		
		//Set up form and panels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(MainPanel,BorderLayout.CENTER);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		MainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bottomPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		frame.setLocationRelativeTo(null);
		
		//for (int i = 0; i < Medicines.length(); i++){
		//      nameBox.addItem(Medicines(i));  
		//}
		
		//Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
		topPanel.setLayout(new GridLayout(1,1,0,0));
	    MainPanel.setLayout(new GridLayout(5,2,10,10));
	    bottomPanel.setLayout(new GridLayout(1,2,10,10));
	    topPanel.add(infoLabel1);
		MainPanel.add(nameLabel);
		MainPanel.add(nameBox);
		MainPanel.add(refillsLabel);
		MainPanel.add(refillsText);
		MainPanel.add(startDateLabel);
		MainPanel.add(startDateText);
		MainPanel.add(endDateLabel);
		MainPanel.add(endDateText);
		MainPanel.add(physicianLabel);
		MainPanel.add(physicianBox);
		bottomPanel.add(submitButton);
		bottomPanel.add(exitButton);
		
		submitButton.addActionListener(new submitButtonListener());
	    exitButton.addActionListener(new exitButtonListener());
	    
		frame.setVisible(true);
	}
	class submitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Physician aDoctor = new Physician;
		}
	}
	class exitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
