// Author: Mitchell Skinner
// Date: 11/22/2013
// InsuranceList
//
// Updated 11/23 by Jeff Andolora because goddamn so many compiler errors everywhere. also replaced while loop with for-each for readability
import java.util.*;

public class InsuranceList{

	private List<Insurance> aList = new ArrayList<Insurance>();

	// Methods

	private void add(int aID, String aName, String aPolicy, String aPhone){
		aList.remove(aID);
		aList.add(new Insurance(aID, aName, aPolicy, aPhone));
	}

	private void remove(int aID){
		for(Insurance aPolicy:aList){
			if(aPolicy.getID() == aID){
				aList.remove(aPolicy);
				break;
			}
		}
	}
	public boolean contains(int aID){
		for(Insurance aPolicy:aList){
			if(aPolicy.getID() == aID){
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
		for(Insurance aPolicy:aList){
			aString += aPolicy.toString() + "\n";
		}
		return aString;
	}

	public void add(Insurance aInsurance) {
		aList.add(aInsurance);
	}
}
