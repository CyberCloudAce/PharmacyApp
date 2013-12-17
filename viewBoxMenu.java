import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class viewBoxMenu {

    JButton exitButton = new JButton("Exit Program");
    JButton submitButton = new JButton("View This Record");
    JList list = new JList();
	JFrame frame = new JFrame("Main Menu");
	JPanel MainPanel = new JPanel();
    JPanel topPanel = new JPanel();
	JLabel infoLabel1 = new JLabel("Click an item to view that record");
	JFrame bFrame = new JFrame();
	String aType;
	String aPatientName; //for Perscription Tracking
	DefaultListModel model = new DefaultListModel();
	
	public void startGUI(JFrame aFrame){
		startGUI(aFrame, null);
	}
	
	public void startGUI(JFrame aFrame, String type){
		bFrame = aFrame;
		aType = type;
		
		//Set up form and panels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.add(topPanel,BorderLayout.CENTER);
        frame.add(MainPanel,BorderLayout.SOUTH);
        topPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        MainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setLocationRelativeTo(null);
        
      //Add items to panel. Grid layout means rows, columns, horizontal padding, vertical padding
        topPanel.setLayout(new GridLayout(2,1,0,0));
        MainPanel.setLayout(new GridLayout(1,2,10,10));
        topPanel.add(infoLabel1);
        topPanel.add(list);
        MainPanel.add(submitButton);
        MainPanel.add(exitButton);
        
        switch(aType){
			case "patient":
				PatientList aPatiList = new PatientList();
				aPatiList = PharmacyApp.aController.getAllPatients();
				for(Patient aPatient:aPatiList.aList){
					model.addElement(aPatient.toString());
				}
				break;
			case "perscription":
				PerscriptionList aPersList = new PerscriptionList();
				aPersList = PharmacyApp.aController.getAllPerscriptions(type);
				for(Prescription aPerscription:aPersList.aList){
					model.addElement(aPerscription.toString());
				}
				break;
			case "medication":
				MedicationList aMediList = new MedicationList();
				aMediList = PharmacyApp.aController.getAllMedications();
				for(Medication aMed:aMediList.aList){
					model.addElement(aMed.toString());
				}
				break;
			case "insurance":
				InsuranceList aInsuList = new InsuranceList();
				aInsuList = PharmacyApp.aController.getAllInsurances();
				for(Insurance aInsurance:aInsuList.aList){
					model.addElement(aInsurance.toString());
				}
				break;
			case "physician":
				PhysicianList aPhysList = new PhysicianList();
				aPhysList = PharmacyApp.aController.getAllPhysicians();
				for(Physician aPhys:aPhysList.aList){
					model.addElement(aPhys.toString());
				}
				break;
			default: 
				//this should never run
				System.out.println("ViewBoxMenu type error");
        }
        
        list.setModel(model);
        exitButton.addActionListener(new exitButtonListener());
        submitButton.addActionListener(new submitButtonListener());
        frame.setVisible(true);	
	} 
        class exitButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                PharmacyApp.aController.shutdown();
                frame.setVisible(false);
                bFrame.setVisible(true);
            }
        }
        class submitButtonListener implements ActionListener {
        	public void actionPerformed(ActionEvent e) {
        		switch(aType){
	        		case "patient":
	        			String selectedToString = (String) list.getSelectedValue();
	        			PatientList aPatiList = new PatientList();
	    				aPatiList = PharmacyApp.aController.getAllPatients();
	    				Patient selectedPatient = new Patient();
	    				for(Patient aPatient:aPatiList.aList){
	    					if(selectedToString == aPatient.toString()){
	    						selectedPatient = aPatient;
	    					}
	    				}
	        			PharmacyApp.aController.viewPatientMenuStart(frame, selectedPatient);
	        			break;
	        		case "perscription":
	        			String selectedToString1 = (String) list.getSelectedValue();
	    				PerscriptionList aPersList = new PerscriptionList();
	    				aPersList = PharmacyApp.aController.getAllPerscriptions(aType);
	    				Prescription selectedPerscription = new Prescription();
	    				for(Prescription aPerscription:aPersList.aList){
	    					if(selectedToString1 == aPerscription.toString()){
	    						selectedPerscription = aPerscription;
	    					}
	    				}
	        			PharmacyApp.aController.viewPerscriptionMenuStart(frame, selectedPerscription);
	        			break;
	        		case "medication":
	        			String selectedToString2 = (String) list.getSelectedValue();
	    				MedicationList aMediList = new MedicationList();
	    				Medication selectedMedication = new Medication();
	    				aMediList = PharmacyApp.aController.getAllMedications();
	    				for(Medication aMed:aMediList.aList){
	    					if(selectedToString2 == aMed.toString()){
	    						selectedMedication = aMed;
	    					}
	    				}
	        			PharmacyApp.aController.viewMedicineMenuStart(frame, selectedMedication);
	        			break;
	        		case "insurance":
	        			String selectedToString3 = (String) list.getSelectedValue();
	    				InsuranceList aInsuList = new InsuranceList();
	    				aInsuList = PharmacyApp.aController.getAllInsurances();
	    				Insurance selectedInsurance = new Insurance();
	    				for(Insurance aInsurance:aInsuList.aList){
	    					if(selectedToString3 == aInsurance.toString()){
	    						selectedInsurance = aInsurance;
	    					}
	    				}
	        			PharmacyApp.aController.viewInsuranceMenuStart(frame, selectedInsurance);
	        			break;
	        		case "physician":
	        			String selectedToString4 = (String) list.getSelectedValue();
	    				PhysicianList aPhysList = new PhysicianList();
	    				aPhysList = PharmacyApp.aController.getAllPhysicians();
	    				Physician selectedPhysician = new Physician();
	    				for(Physician aPhys:aPhysList.aList){
	    					if(selectedToString4 == aPhys.toString()){
	    						selectedPhysician = aPhys;
	    					}
	    				}
	        			PharmacyApp.aController.viewPhysicianMenuStart(frame, selectedPhysician);
	        			break;
	        		default: 
	        			//this should never run
	        			String selectedToString5 = (String) list.getSelectedValue();
	        			System.out.println("ViewBoxMenu type error, selectedIndex=" + selectedToString5);
        		}
        		hideWindows();
        	}
        	public void hideWindows(){
        		frame.setVisible(false);
        		bFrame.setVisible(true);
        	}
        }
        
        public void startGUI(JFrame aFrame, String type, String name){
        	
        	
        }
	
}