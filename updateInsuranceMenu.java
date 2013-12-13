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
        
public class updateInsuranceMenu {
        
        //initialize form elements
        JFrame frame = new JFrame("Main Menu");
        JPanel MainPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        //initialize form contents        
        JLabel infoLabel1 = new JLabel("Add a new Insurance Policy");
        JLabel providerLabel = new JLabel("Provider Name");
        JLabel policyLabel = new JLabel("Policy Name");
        JLabel phoneLabel = new JLabel("Phone Num");
        JTextField providerText = new JTextField();
        JTextField policyText = new JTextField();
        JTextField phoneText = new JTextField();
        JButton submitButton = new JButton("Save Changes");
        JButton exitButton = new JButton("Exit Program");
        JFrame bFrame = new JFrame();
        
        public void startGui(JFrame aFrame, String provider, String policy, String phone){
            bFrame = aFrame;
            
            //Set up form and panels
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,220);
            frame.add(topPanel,BorderLayout.NORTH);
            frame.add(MainPanel,BorderLayout.CENTER);
            frame.add(bottomPanel,BorderLayout.SOUTH);
            topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
            MainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            bottomPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

            frame.setLocationRelativeTo(null);
            
            //Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
            topPanel.setLayout(new GridLayout(1,1,0,0));
            MainPanel.setLayout(new GridLayout(3,2,10,10));
            bottomPanel.setLayout(new GridLayout(1,2,10,10));
            topPanel.add(infoLabel1);
            MainPanel.add(providerLabel);
            MainPanel.add(providerText);
            providerText.setText(provider);
            MainPanel.add(policyLabel);
            MainPanel.add(policyText);
            policyText.setText(policy);
            MainPanel.add(phoneLabel);
            MainPanel.add(phoneText);
            phoneText.setText(phone);
            bottomPanel.add(submitButton);
            bottomPanel.add(exitButton);
            
            submitButton.addActionListener(new submitButtonListener());
            exitButton.addActionListener(new exitButtonListener());
        
            frame.setVisible(true);
        }
        class submitButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Controller.updateInsurance(providerText.getText(), policyText.getText(), phoneText.getText());
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
