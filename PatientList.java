import java.util.ArrayList;
import java.util.List;

//coded by jeff, 12/5
//if you couldn't tell i'm getting lazy on the comments, forgive me 
public class PatientList {

	private List<Patient> aList = new ArrayList<Patient>();

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
	
	public String toString(){
		String aString = "";
		for(Patient aPatient:aList){
			aString += aPatient.toString() + "\n" + "\n";
			
		}
		return aString;
	}
}