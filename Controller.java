import javax.swing.JFrame;


public class Controller {


	public void addMenuStart(JFrame frame){
		frame.setVisible(false);
		addMenu view2 = new addMenu();
		view2.startGUI();
	}
	public void addPatientMenuStart(JFrame frame){
		frame.setVisible(false);
		//addPatientMenu view2 = new addPatientMenu();
		//view2.startGUI();
	}
	public void addPhysicianMenuStart(JFrame frame){
		frame.setVisible(false);
		addPhysicianMenu view2 = new addPhysicianMenu();
		view2.startGui();
	}
	public void addInsuranceMenuStart(JFrame frame){
		frame.setVisible(false);
		addInsuranceMenu view2 = new addInsuranceMenu();
		view2.startGui();
	}
	public void addMedicineMenuStart(JFrame frame){
		frame.setVisible(false);
		//addMedicineMenu view2 = new addMedicineMenu();
		//view2.startGUI();
	}
	public void addPerscriptionMenuStart(JFrame frame){
		frame.setVisible(false);
		//addPerscriptionMenu view2 = new addPerscriptionMenu();
		//view2.startGUI();
	}
	
}
