// Author: Mitchell Skinner
// Date: 11/22/2013
// Physician

public class Physician{
	private int iD = -1;
	private String firstName = "NA";
	private String lastName = "NA";
	private String phone = "NA";

// Sets

	public void setID(int aID){
		this.iD = aID;
	}
	public void setFirstName(String aFirstName){
		this.firstName = aFirstName;
	}
	public void setLastName(String aLastName){
		this.lastName = aLastName;
	}
	public void setPhone(String aPhone){
		this.phone = aPhone;
	}

// Gets

	public int getID(){
		return this.iD;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getPhone(){
		return this.phone;
	}

// Constructors

	public Physician(){
		// Empty Constructor
	}

	public Physician(int aID, String aFirstName, String aLastName, String aPhone){
		this();
		this.iD = aID;
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.phone = aPhone;
	}

	public Physician(int aID, String aFirstName, String aLastName){
		this(aID, aFirstName, aLastName, "NA");
	}

	public Physician(int aID){
		this(aID, "NA", "NA", "NA");
	}

// Methods

	public String toString(){
		String aString = "";
		aString = "ID: " + this.iD + "\n";
		aString += "FirstName: " + this.firstName + "\n";
		aString += "LastName: " + this.lastName + "\n";
		aString += "Phone: " + this.phone + "\n";
		return aString;
	}
}
