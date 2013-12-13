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
	public void addMenuStart(JFrame frame){
		frame.setVisible(false);
		addMenu view2 = new addMenu();
		view2.startGUI(frame);
	}
	public static void updateMenuStart(JFrame frame, String type){
		frame.setVisible(false);
		updateMenu view2 = new updateMenu();
		view2.startGUI(frame);
	}
	public void viewMenuStart(JFrame frame, String type){
		frame.setVisible(false);
		viewMenu view2 = new viewMenu();
		view2.startGUI(frame);
	}
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
	public void addInsuranceMenuStart(JFrame frame){
		frame.setVisible(false);
		addInsuranceMenu view2 = new addInsuranceMenu();
		view2.startGui(frame);
	}
	public void addMedicineMenuStart(JFrame frame){
		frame.setVisible(false);
		addMedicineMenu view2 = new addMedicineMenu();
		view2.startGui(frame);
	}
	public void viewMedicineMenuStart(JFrame frame){
		frame.setVisible(false);
		viewMedicationMenu view2 = new viewMedicationMenu();
		view2.startGui(frame);
	}
	public void viewPatientMenuStart(JFrame frame){
		frame.setVisible(false);
		viewPatientMenu view2 = new viewPatientMenu();
		view2.startGui(frame);
	}
	public void viewPerscriptionMenuStart(JFrame frame){
		frame.setVisible(false);
		ViewPerscriptionMenu view2 = new ViewPerscriptionMenu();
		view2.startGui(frame);
	}
	public void viewInsuranceMenuStart(JFrame frame){
		frame.setVisible(false);
		viewInsuranceMenu view2 = new viewInsuranceMenu();
		view2.startGui(frame);
	}
	public void viewPhysicianMenuStart(JFrame frame){
		frame.setVisible(false);
		viewPhysicianMenu view2 = new viewPhysicianMenu();
		view2.startGui(frame);
	}
	public void updatePhysicianMenuStart(JFrame frame){
		frame.setVisible(false);
		updatePhysicianMenu view2 = new updatePhysicianMenu();
		view2.startGui(frame);
	}
	public void updateInsuranceMenuStart(JFrame frame){
		frame.setVisible(false);
		updateInsuranceMenu view2 = new updateInsuranceMenu();
		view2.startGui(frame);
	}
	public void updateMedicationMenuStart(JFrame frame){
		frame.setVisible(false);
		updateMedicineMenu view2 = new updateMedicineMenu();
		view2.startGui(frame);
	}
	public void updatePatientMenuStart(JFrame frame){
		frame.setVisible(false);
		updatePatientMenu view2 = new updatePatientMenu();
		view2.startGui(frame);
	}
	public static void updatePerscriptionMenuStart(JFrame frame){
		frame.setVisible(false);
		updatePerscriptionMenu view2 = new updatePerscriptionMenu();
		view2.startGui(frame);
	}
	
	//called from addPatientMenu and updatePatientMenu
	public static void addPerscriptionMenuStart(JFrame frame, String aName){
		frame.setVisible(false);
		addPerscriptionMenu view2 = new addPerscriptionMenu();
		view2.startGui(frame, aName);
	}
	
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
	
	public static Patient getPatient(String id){
		return aDataAccess.getPatient(id);
	}
	public static Prescription getPerscription(String name, String medication){
		return aDataAccess.getPerscription(name,medication);
	}
	public static Insurance getInsurance(String id){
		return aDataAccess.getInsurance(id);
	}
	public static Medication getMedication(String id){
		return aDataAccess.getMedication(id);
	}
	public static Physician getPhysician(String id){
		return aDataAccess.getPhysician(id);
	}
	public static PerscriptionList getAllPerscriptions(String name){
		return aDataAccess.getPerscriptionHistory(name);
	}
	public static InsuranceList getAllInsurances(){
		return aDataAccess.getAllInsurances();
	}
	public static PatientList getAllPatients(){
		return aDataAccess.getAllPatients();
	}
	public static MedicationList getAllMedications(){
		return aDataAccess.getAllMedications();
	}
	public static PhysicianList getAllPhysicians(){
		return aDataAccess.getAllPhysicians();
	}
	
	public static void updatePatient(String name, String phone, String dob, String insurance){
		aDataAccess.updatePatient(name,phone,dob,insurance);
		
	}
	public static void updatePerscription(String medication, String refill, String dateI, String dateE, String physician){
		aDataAccess.updatePerscription(medication,refill,dateI,dateE,physician);
		
	}
	public static void updateInsurance(String company, String policy, String phone){
		aDataAccess.updateInsurance(company,policy,phone);
		
	}
	public static void updateMedication(String name, String cost, String effects){
		aDataAccess.updateMedication(name,cost,effects);
		
	}
	public static void updatePhysician(String firstName, String lastName, String address, String phone){
		aDataAccess.updatePhysician(firstName,lastName,address,phone);
		
	}

	public static void addMedication(String name, String cost, String effects) {
		int randomID = (int) Math.floor(Math.random() * 500000);
		aDataAccess.addMedication(randomID, name, cost, effects);
	}
}
