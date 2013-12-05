import java.util.ArrayList;
import java.util.List;

//coded 12/5 by jeff andolora
public class PerscriptionList {

	private List<Prescription> aList = new ArrayList<Prescription>();

	// Methods

	private void add(int aID, String aMedication, int aRefill, String aIssueDate, String aExpiryDate, int aPhysicianId){
		aList.remove(aID);
		aList.add(new Prescription(aID,aMedication,aRefill,aIssueDate,aExpiryDate,aPhysicianId));
	}

	private void remove(int aID){
		for(Prescription aPerscription:aList){
			if(aPerscription.getPrescriptionID() == aID){
				aList.remove(aPerscription);
				break;
			}
		}
	}
	public boolean contains(int aID){
		for(Prescription aPerscription:aList){
			if(aPerscription.getPrescriptionID() == aID){
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
		for(Prescription aPerscription:aList){
			aString += aPerscription.toString() + "\n";
		}
		return aString;
	}
}
