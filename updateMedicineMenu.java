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

public class updateMedicineMenu {
	
	//initialize form elements
	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	//initialize form contents	
	JLabel infoLabel1 = new JLabel("Update a Medication");
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
	
	public void startGui(JFrame aFrame, String name, String desc, String effects){
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
		nameText.setText(name);
		MainPanel.add(descriptionLabel);
		MainPanel.add(descriptionText);
		descriptionText.setText(desc);
		MainPanel.add(sideEffectsLabel);
		MainPanel.add(sideEffectsText);
		sideEffectsText.setText(effects);
		MainPanel.add(genericRadio);
		MainPanel.add(nameBrandRadio);
		bottomPanel.add(submitButton);
		bottomPanel.add(exitButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(genericRadio);
		group.add(nameBrandRadio);

		submitButton.addActionListener(new submitButtonListener());
	    exitButton.addActionListener(new exitButtonListener());
	    
		frame.setVisible(true);
	}
	class submitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		Controller.updateMedication(nameText.getText(), descriptionText.getText(), sideEffectsText.getText());
		// radio button submit? JRadioButtonMenuItem()
      		frame.setVisible(false);
      		bFrame.setVisible(true);
		}
	}
	class exitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
