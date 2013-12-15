import java.util.ArrayList;
import java.util.List;

//coded by jeff andolora 12/5
public class PhysicianList {

	private List<Physician> aList = new ArrayList<Physician>();

	// Methods

	private void add(int aId, String aFirstName, String aLastName, String aPhone){
		aList.remove(aId);
		aList.add(new Physician(aId, aFirstName, aLastName, aPhone));
	}

	private void remove(int aID){
		for(Physician aPhysician:aList){
			if(aPhysician.getID() == aID){
				aList.remove(aPhysician);
				break;
			}
		}
	}
	public boolean contains(int aID){
		for(Physician aPhysician:aList){
			if(aPhysician.getID() == aID){
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
		for(Physician aPhysician:aList){
			aString += aPhysician.toString() + "\n";
		}
		return aString;
	}

	public void add(Physician aPhysician) {
		aList.add(aPhysician);
		
	}
}
