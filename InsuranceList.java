// Author: Mitchell Skinner
// Date: 11/22/2013
// InsuranceList

import java.util.*;

public class InsuranceList{

	private ArrayList<Insurance> list = new ArrayList<InsuranceList>();

	// Methods

	private void add(int aID, String aName, String aPolicy, String aPhone){
		
		this.remove(aID);
		insurance.add(new Insurance(aID, aName, aPolicy, aPhone));
	}

	private void remove(String aID){

		int i = insurance.size() -1;
		while(i >= 0){
			if(insurance.get(i).getID() == aID){
				insurance.remove(i);
			}

			i--;
		}
	}

	public boolean contains(String aID){

		boolean isContained = false;

		for(brokenRule aRule: insurance){
			if(aRule.getID() == aID){
				isContained = true;
			}
		}

		return isContained;

	}

	public int size(){

		return insurance.size();

	}

	public boolean isValid(){

		if(this.size() == 0){

			return true;
		}else{
			return false;
		}
	}

	public void checkRule(int aID, String aName, String aPolicy, String aPhone boolean isBroken){
		if(isBroken == true){
			this.add(aID, aName, aPolicy, aPhone);
		}else{
			this.remove(aID);
		}
	}

	public String toString(){

		String aString = "";

		for(insurance aRule b: insurance){
			aString = aString + b.toString();
		}

		return aString;
	}
}
