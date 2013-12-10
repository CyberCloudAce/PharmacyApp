import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class updateMenu {

        JButton patientButton = new JButton("Update Patient");
        JButton physicianButton = new JButton("Update Physician");
        JButton medicineButton = new JButton("Update Medicine");
        JButton insuranceButton = new JButton("Update Insurance");
        JButton exitButton = new JButton("Exit Program");

        JFrame frame = new JFrame("Main Menu");
        JPanel MainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JLabel infoLabel1 = new JLabel("Click a button to update a record");

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
            MainPanel.add(insuranceButton);
            MainPanel.add(exitButton);
            
            //Classes below are called on Button Click
            patientButton.addActionListener(new patientButtonListener());
            physicianButton.addActionListener(new physicianButtonListener());
            medicineButton.addActionListener(new medicineButtonListener());
            insuranceButton.addActionListener(new insuranceButtonListener());
            exitButton.addActionListener(new exitButtonListener());
          
            //Opens form window
            frame.setVisible(true);
        }
        class patientButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        PharmacyApp.aController.updatePatientMenuStart(frame);
                }
        }
        class physicianButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        PharmacyApp.aController.updatePhysicianMenuStart(frame);
                }
        }
        class medicineButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        PharmacyApp.aController.updateMedicineMenuStart(frame);

                }
        }
        class insuranceButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        PharmacyApp.aController.updateInsuranceMenuStart(frame);
                }
        }
        class exitButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        PharmacyApp.aController.shutdown();

                }
        }
}
