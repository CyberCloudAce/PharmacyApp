import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewPerscriptionMenu {

	//initialize form elements
    JFrame frame = new JFrame("Main Menu");
    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    //initialize form contents
    JLabel infoLabel1 = new JLabel("Current Perscriptions:");
    JLabel infoMedicineLabel = new JLabel("Medicine Name:");
    JLabel infoRefillLabel = new JLabel("Number of Refills:");
    JLabel infoStDateLabel = new JLabel("Start Date:");
    JLabel infoEndDateLabel = new JLabel("End Date:");
	JLabel infoPhysicianLabel = new JLabel("Physician:");
    JLabel medicineLabel = new JLabel("");
    JLabel refillLabel = new JLabel("");
    JLabel stDateLabel = new JLabel("");
    JLabel endDateLabel = new JLabel("");
    JLabel physicianLabel = new JLabel("");
    JButton returnButton = new JButton("Return");
    JButton exitButton = new JButton("Exit Program");
    JFrame bFrame = new JFrame();
    
    public void startGui(String medication, String refill, String startDate, String endDate, String physician, JFrame aFrame){
	bFrame = aFrame;
    	//Set up form and panels
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,220);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

        frame.setLocationRelativeTo(null);
        medicineLabel.setText(medication);
        refillLabel.setText(refill);
        stDateLabel.setText(startDate);
        endDateLabel.setText(endDate);
        physicianLabel.setText(physician);
                
        //Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
        topPanel.setLayout(new GridLayout(1,1,0,0));
        mainPanel.setLayout(new GridLayout(3,2,10,10));
        bottomPanel.setLayout(new GridLayout(1,2,10,10));
        topPanel.add(infoLabel1);
        mainPanel.add(infoMedicineLabel);
        mainPanel.add(medicineLabel);
        mainPanel.add(infoRefillLabel);
        mainPanel.add(refillLabel);
        mainPanel.add(infoStDateLabel);
        mainPanel.add(stDateLabel);
        mainPanel.add(infoEndDateLabel);
        mainPanel.add(endDateLabel);
        mainPanel.add(infoPhysicianLabel);
        mainPanel.add(physicianLabel);
        bottomPanel.add(returnButton);
        bottomPanel.add(exitButton);        
        returnButton.addActionListener(new returnButtonListener());
        exitButton.addActionListener(new exitButtonListener());
            
        frame.setVisible(true);
    }
    class returnButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
               bFrame.setVisible(true);
        }
    }
    class exitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
