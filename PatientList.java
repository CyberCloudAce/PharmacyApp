import java.util.ArrayList;
import java.util.List;

//coded by jeff, 12/5
public class PatientList {

	public List<Patient> aList = new ArrayList<Patient>();

	// Methods

	private void add(int aId, String aName, String aPhone, String aDOB, String aInsurance, PerscriptionList aPerscriptionList){
		aList.remove(aId);
		aList.add(new Patient(aId, aName, aPhone, aDOB, aInsurance, aPerscriptionList));
	}

	private void remove(int aID){
		for(Patient aPatient:aList){
			if(aPatient.getID() == aID){
				aList.remove(aPatient);
				break;
			}
		}
	}
	public boolean contains(int aID){
		for(Patient aPatient:aList){
			if(aPatient.getID() == aID){
				return true;
			}
		}
		return false;
	}

	public int size(){
		return aList.size();
	}
	
	@Override
	public String toString(){
		String aString = "";
		for(Patient aPatient:aList){
			aString += aPatient.toString() + "\n" + "\n";
			
		}
		return aString;
	}

	public void add(Patient aPatient) {
		//aList.remove(aPatient.getID());
		aList.add(aPatient);
		
	}
}