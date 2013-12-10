import javax.swing.JFrame;
	//coded by Jeff Andolora, 11/20ish
public class Controller {
	
	public static DataAccessClass aDataAccess = new DataAccessClass();

	/*
	A bit of an update on how i'm doing this:
	
	this is the model of the 'mvc' framework we're using. 
	the forms send their data here, and this will interact with the controller (data access class, fileIO)
	this class is gonna end up with a metric crap ton of methods, all of which will be passing data back and forth.
	
	add new methods as needed, but don't touch the ones that are already here. 
	
	-Jeff, 11/24
	
	ps we may want to split this up into a GUIController, DataController, etc.
	*/
	
	public void shutdown(){
		System.exit(0);
	}
	
	//Menu start methods
	
	public void mainMenuStart(JFrame frame){ 
		MainGUI view = new MainGUI();
		view.startGUI();
	}
	//called from MainGUI
	public void addMenuStart(JFrame frame){
		frame.setVisible(false);
		addMenu view2 = new addMenu();
		view2.startGUI();
	}
	public void updateMenuStart(JFrame frame){
		frame.setVisible(false);
		//updateMenu view2 = new updateMenu();
		//view2.startGUI();
	}
	public void viewMenuStart(JFrame frame){
		frame.setVisible(false);
		//viewMenu view2 = new viewMenu();
		//view2.startGUI();
	}
	
	//called from add forms
	public void addPatientMenuStart(JFrame frame){
		frame.setVisible(false);
		addPatientMenu view2 = new addPatientMenu();
		view2.startGui(frame);
	}
	public void addPhysicianMenuStart(JFrame frame){
		frame.setVisible(false);
		addPhysicianMenu view2 = new addPhysicianMenu();
		view2.startGui(frame);
		
	}
	public void closeAddPhysicianMenu(JFrame frame){
		frame.setVisible(true);
	}
	public void addInsuranceMenuStart(JFrame frame){
		frame.setVisible(false);
		addInsuranceMenu view2 = new addInsuranceMenu();
		view2.startGui(frame);
	}
	public void addMedicineMenuStart(JFrame frame){
		frame.setVisible(false);
		addMedicineMenu view2 = new addMedicineMenu();
		view2.startGui();
	}
	
	//called from addPatientMenu and updatePatientMenu
	public static void addPerscriptionMenuStart(JFrame frame, String aName){
		frame.setVisible(false);
		addPerscriptionMenu view2 = new addPerscriptionMenu();
		view2.startGui(frame, aName);
	}
	
	//Add methods - called from add Forms
	public static void addPatient(String firstName, String lastName, String phone, String dob, String insurance){
		int randomID = (int) Math.floor(Math.random() * 500000);
		String name = firstName + " " + lastName;
		aDataAccess.addPatient(randomID, name, phone, dob, insurance);
		//Do stuff
	}
	
	public static void addPerscription(PerscriptionList aList, String aName){
		aDataAccess.addPerscriptionHistory(aList,aName);
	}
	public static void addPerscription(String aName, String mName, String refills, String dateI, String dateE, String Physician){
		aDataAccess.addPerscription(aName,mName,refills,dateI,dateE,Physician);
	}
	
	public static void addPhysician(String firstName, String lastName, String address, String phone){
		int randomID = (int) Math.floor(Math.random() * 500000);
		aDataAccess.addPhysician(randomID, firstName, lastName, address, phone);
	}
	
	public static void addInsurance(String company, String policy, String phone){
		int randomID = (int) Math.floor(Math.random() * 500000);
		aDataAccess.addInsurance(randomID, company, policy, phone);
	}
}
