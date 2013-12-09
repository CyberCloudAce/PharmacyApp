// Insurance Class
// Created in part by Cooper Mehlenbacher
// 11/22/2013
// Containes insurance information such as: ID, Company Name, Policy Name, Provider Phone Number.

public class Insurance {

	private Integer id = -1;
	private String companyName = "";
	private String policyName = "";
	private String providerPhoneNum = "";

	public void setID(Integer aID){
		this.id = aID;
	}

	public void setCompanyName(String aCompanyName){
		this.companyName = aCompanyName;
	}

	public void setPolicyName(String aPolicyName){
		this.policyName = aPolicyName;
	}

	public void setProviderPhoneNum(String aProviderPhoneNum){
		this.providerPhoneNum = aProviderPhoneNum;
	}

	public Integer getID() {
		return this.id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public String getProviderPhoneNum() {
		return this.providerPhoneNum;
	}

	public Insurance() {
		//empty constructor
	}

	public Insurance(Integer aID, String aCompanyName, String aPolicyName, String aProviderPhoneNum) {
		this();
		this.id = aID;
		this.companyName = aCompanyName;
		this.policyName = aPolicyName;
		this.providerPhoneNum = aProviderPhoneNum;
	}

	public Insurance(Integer aID, String aCompanyName, String aPolicyName){
		this(aID, aCompanyName, aPolicyName, "N/A");
	}

	@Override
	public String toString() {
		String aString = "";
		aString = "ID: " + this.id + "\n";
		aString += "Company Name: " + this.companyName + "\n";
		aString += "Policy Name: " + this.policyName + "\n";
		aString += "Provider Phone Number: " + this.providerPhoneNum + "\n";
		return aString;
	}
}
