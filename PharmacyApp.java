import java.net.UnknownHostException;
import com.mongodb.*;

public class PharmacyApp {
	
	public static Controller aController = new Controller();
	public static MainGUI view = new MainGUI();
	public InsuranceList aInsuranceList = new InsuranceList();
	public PatientList aPatientList = new PatientList();
	public MedicationList aMedicineList = new MedicationList();
	public PhysicianList aPhysicianList = new PhysicianList();

	//To do: Probably start commenting shit
	public static void main(String[] args) {
		view.startGUI();
	}
}
