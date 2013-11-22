// Patient Class
// Containes patient information such as: Name, Number, DOB, Insurance Provider, policy num, and perscription history

public class Patient {

	private String name = "N/A";
	private String phoneNum = -1;
	private String dob = -1;
	private String insuranceProvider = "N/A";
	private Integer policyNum = -1;
	private String perscriptionHist = "N/A";

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

	public void setPolicyNum(Integer aPolicyNum){
		this.policyNum = aPolicyNum;
	}

	public void setPerscriptionHist(String aPerscriptionHist){
		this.perscriptionHist = aPerscriptionHist;
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

	public Integer getPolicyNum() {
			return this.policyNum;
	}

	public String getPerscriptionHist() {
			return this.perscriptionHist;
	}

	public Patient() {
			//empty constructor
	}

	public Patient(String name, String phoneNum, String dob, String insuranceProvider, Integer policyNum, String perscriptionHist) {
			this();
			this.name = aName;
			this.phoneNum = aPhoneNum;
			this.dob = aDOB;
			this.insuranceProvider = aInsuranceProvider;
			this.policyNum = aPolicyNum;
			this.perscriptionHist = aPerscriptionHist;
	}
	
	public String toString() {
		String aString = "";
		aString = "Name: " + this.name + "\n";
		aString = aString + "Phone Number: " + this.phoneNum + "\n";
		aString = aString + "Date of Birth: " + this.dob + "\n";
		aString = aString + "Insurance Provider: " + this.insuranceProvider + "\n";
		aString = aString + "Policy Number: " + this.policyNum + "\n";
		aString = aString + "Perscription History: " + this.perscriptionHist + "\n";
	}

}
