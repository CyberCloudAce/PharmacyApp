import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addMedicineMenu {
	
	//initialize form elements
	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	//initialize form contents	
	JLabel infoLabel1 = new JLabel("Add a new Medicine");
	JLabel nameLabel = new JLabel("Name");
	JLabel descriptionLabel = new JLabel("Description");
	JLabel sideEffectsLabel = new JLabel("Side Effects");
	JRadioButton genericRadio = new JRadioButton("Generic");
	JRadioButton nameBrandRadio = new JRadioButton("Name Brand");
	
	JTextField nameText = new JTextField();
	JTextField descriptionText = new JTextField();
	JTextField sideEffectsText = new JTextField(4);
	JButton submitButton = new JButton("Save Changes");
	JButton exitButton = new JButton("Exit Program");
	JFrame bFrame = new JFrame();
	
	public void startGui(JFrame aFrame){
		bFrame = aFrame;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,260);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(MainPanel,BorderLayout.CENTER);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(MainPanel,BorderLayout.CENTER);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		MainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bottomPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		frame.setLocationRelativeTo(null);
		
		//Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
		topPanel.setLayout(new GridLayout(1,1,0,0));
	    MainPanel.setLayout(new GridLayout(4,2,10,10));
	    bottomPanel.setLayout(new GridLayout(1,2,10,10));
	    topPanel.add(infoLabel1);
		MainPanel.add(nameLabel);
		MainPanel.add(nameText);
		MainPanel.add(descriptionLabel);
		MainPanel.add(descriptionText);
		MainPanel.add(sideEffectsLabel);
		MainPanel.add(sideEffectsText);
		bottomPanel.add(submitButton);
		bottomPanel.add(exitButton);
		
		submitButton.addActionListener(new submitButtonListener());
	    exitButton.addActionListener(new exitButtonListener());
	    
		frame.setVisible(true);
	}
	class submitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Controller.addMedication(nameText.getText(),descriptionText.getText(),sideEffectsText.getText());
		}
	}
	class exitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
