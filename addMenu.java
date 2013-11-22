import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class addMenu {

	JButton patientButton = new JButton("Add New Patient");
	JButton physicianButton = new JButton("Add New Physician");
	JButton medicineButton = new JButton("Add New Medicine");
	//JButton perscriptionButton = new JButton("Add New Perscription");
	JButton insuranceButton = new JButton("Add New Insurance");
	JButton exitButton = new JButton("Exit Program");

	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JLabel infoLabel1 = new JLabel("Click a button to add a new record");

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
	    MainPanel.setLayout(new GridLayout(3,2,10,10));
	    topPanel.add(infoLabel1);
	    MainPanel.add(patientButton);
	    MainPanel.add(physicianButton);
	    MainPanel.add(medicineButton);
	    //MainPanel.add(perscriptionButton);
	    MainPanel.add(insuranceButton);
	    MainPanel.add(exitButton);
	    
	    //Classes below are called on Button Click
	    patientButton.addActionListener(new patientButtonListener());
	    physicianButton.addActionListener(new physicianButtonListener());
	    medicineButton.addActionListener(new medicineButtonListener());
	   // perscriptionButton.addActionListener(new perscriptionButtonListener());
	    insuranceButton.addActionListener(new insuranceButtonListener());
	    exitButton.addActionListener(new exitButtonListener());
	  
	    //Opens form window
	    frame.setVisible(true);
	}
	class patientButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addPatientMenu view3 = new addPatientMenu();
			view3.startGui();
			frame.setVisible(false);
		}
	}
	class physicianButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addPhysicianMenu view3 = new addPhysicianMenu();
			view3.startGui();
			frame.setVisible(false);
		}
	}
	class medicineButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addMedicineMenu view3 = new addMedicineMenu();
			view3.startGui();
			frame.setVisible(false);
		}
	}
	/*class perscriptionButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addPerscriptionMenu view3 = new addPerscriptionMenu();
			view3.startGui();
			frame.setVisible(false);
		}
	}*/
	class insuranceButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addInsuranceMenu view3 = new addInsuranceMenu();
			view3.startGui();
			frame.setVisible(false);
		}
	}
	class exitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}