import java.util.ArrayList;
import java.util.List;

//coded 12/5 by jeff andolora
public class MedicationList {

	private List<Medication> aList = new ArrayList<Medication>();

	// Methods

	private void add(int aId, String aName, Double aCost, String sideEffects){
		aList.remove(aId);
		aList.add(new Medication(aId, aName, aCost, sideEffects));
	}

	private void remove(int aID){
		for(Medication aMedication:aList){
			if(aMedication.getID() == aID){
				aList.remove(aMedication);
				break;
			}
		}
	}
	public boolean contains(int aID){
		for(Medication aMedication:aList){
			if(aMedication.getID() == aID){
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
		for(Medication aMedication:aList){
			aString += aMedication.toString() + "\n";
		}
		return aString;
	}
}
