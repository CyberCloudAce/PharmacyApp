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

public class updatePatientMenu {

        //initialize form elements
        JFrame frame = new JFrame("Main Menu");
        JPanel MainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        //initialize form contents        
        JLabel infoLabel1 = new JLabel("Add a new Patient");
        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last Name");
        JLabel dobLabel = new JLabel("Date of Birth");
        JLabel insuranceLabel = new JLabel("Insurance");        
        JTextField firstNameText = new JTextField();
        JLabel phoneLabel = new JLabel("Phone");        
        JTextField phoneText = new JTextField();
        JTextField lastNameText = new JTextField();
        JTextField dobText = new JTextField();
        JTextField insuranceBox = new JTextField();
        JButton perscriptionButton = new JButton("Update Perscription in Patient's history");
        JButton submitButton = new JButton("Save Changes");
        JButton exitButton = new JButton("Exit Program");
        public String bName;
        public JFrame bFrame = new JFrame();

        public void startGui(JFrame aFrame){
                bFrame = aFrame;
                
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
                
                
                //Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
                topPanel.setLayout(new GridLayout(1,1,0,0));
            MainPanel.setLayout(new GridLayout(6,2,10,10));
            bottomPanel.setLayout(new GridLayout(1,2,10,10));
            topPanel.add(infoLabel1);
                MainPanel.add(firstNameLabel);
                MainPanel.add(firstNameText);
                MainPanel.add(lastNameLabel);
                MainPanel.add(lastNameText);
                MainPanel.add(dobLabel);
                MainPanel.add(dobText);
                MainPanel.add(phoneLabel);
                MainPanel.add(phoneText);
                MainPanel.add(insuranceLabel);
                MainPanel.add(insuranceBox);
                MainPanel.add(perscriptionButton);
                bottomPanel.add(submitButton);
                bottomPanel.add(exitButton);
                
                perscriptionButton.addActionListener(new perscriptionButtonListener());
                submitButton.addActionListener(new submitButtonListener());
                exitButton.addActionListener(new exitButtonListener());
            
                frame.setVisible(true);
        }
        class perscriptionButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        bName = firstNameText.getText() +  " " + lastNameText.getText();
                        Controller.updatePerscriptionMenuStart(frame,bName);
                        
                }
        }
        class submitButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        Controller.updatePatient(
                        firstNameText.getText(),
                        lastNameText.getText(),
                        phoneText.getText(),
                        dobText.getText(),
                        insuranceBox.getText());
                        bFrame.setVisible(true);
                        frame.setVisible(false);
                }
        }
        class exitButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                }
        }
}
