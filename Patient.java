// Patient Class
// Contains patient information such as: Name, Number, DOB, Insurance Provider, policy num, and perscription history
//updated 12/5 by jeff to add ID and remove policyNum
public class Patient {

	private int id = -1;
	private String name = "N/A";
	private String phoneNum = "-1";
	private String dob = "-1";
	private String insuranceProvider = "N/A";
	public PerscriptionList perscriptionHist;

	public void setId(int aID){
		this.id = aID;
	}
	public void setName(String aName){
		this.name = aName;
	}

	public void setPhoneNum(String aPhoneNum){
		this.phoneNum = aPhoneNum;
	}

	public void setDOB(String aDOB){
		this.dob = aDOB;
	}

	public void setInsuranceProvider(String aInsuranceProvider){
		this.insuranceProvider = aInsuranceProvider;
	}
	
	public void setPerscriptionList(PerscriptionList aList){
		this.perscriptionHist = aList;
	}
	
	
	
	public int getID(){
		return this.id;
	}
	
	public String getName() {
			return this.name;
	}

	public String getPhoneNum() {
			return this.phoneNum;
	}

	public String getDOB() {
			return this.dob;
	}

	public String getInsuranceProvider() {
			return this.insuranceProvider;
	}

	public Patient() {
			//empty constructor
	}

	public Patient(int aID, String aName, String aPhoneNum, String aDOB, String aInsuranceProvider, PerscriptionList aPerscriptionHist) {
			this();
			this.id = aID;
			this.name = aName;
			this.phoneNum = aPhoneNum;
			this.dob = aDOB;
			this.insuranceProvider = aInsuranceProvider;
			this.perscriptionHist = aPerscriptionHist;
	}
	
	@Override
	public String toString() {
		String aString = "";
		aString = "Name: " + this.name + "\n";
		aString += "Phone Number: " + this.phoneNum + "\n";
		aString += "Date of Birth: " + this.dob + "\n";
		aString += "Insurance Provider: " + this.insuranceProvider + "\n";
		aString += "Perscription History: " + this.perscriptionHist.toString() + "\n";
		return aString;
	}

}
