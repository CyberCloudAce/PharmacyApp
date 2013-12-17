import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
public class DataAccessClass {
	/* The purpose of this class is to connect to the MongoDB server running on a VM server
	 * 
	 * UPDATE 12/11 The server is now running at 136.224.250.156
	 * have fun
	 */
	public void addPatient(int aID, String aName, String aPhone, String aDOB, String aInsurance){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database"); 
			DBCollection coll = db.getCollection("patients"); //mongoDB collections are like tables in any RDBMS
			BasicDBObject record = new BasicDBObject("id",aID).
				append("name",aName).
		        append("phone",aPhone). //this creates the JSON to insert
		        append("dob",aDOB).		//append function adds a new element to the JSON
		        append("insurance", aInsurance);
			coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	public void addPerscription(String aName,String mName, String refills, String dateI, String dateE, String physician){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("perscriptions"); //mongoDB collections are like tables in any RDBMS
			BasicDBObject record = new BasicDBObject("name",aName).
				append("medication", mName).
		        append("refills",refills). //this creates the JSON to insert
		        append("dateissued",dateI).		//append function adds a new element to the JSON
		        append("dateexpired",dateE).
		        append("physician",physician);
			coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	public void addPerscriptionHistory(PerscriptionList aHistory, String aName){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database"); 
			DBCollection coll = db.getCollection("perscriptions"); //mongoDB collections are like tables in any RDBMS
			List<Prescription> aList = new ArrayList<Prescription>(aHistory.getList());
			System.out.println(aList.toString());
			for(Prescription aPerscription:aList){
				BasicDBObject record = new BasicDBObject("name",aName).
					append("medication", aPerscription.getMedication()).
			        append("refills", aPerscription.getRefill()). //this creates the JSON to insert
			        append("dateissued", aPerscription.getDateIssued()).		//append function adds a new element to the JSON
			        append("dateexpired", aPerscription.getDateExpired()).
					append("physician", aPerscription.getPhysicianID());
				coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			}
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	public void addPhysician(int aID, String aFirstName, String aLastName, String aAddress, String aPhone){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database"); 
			DBCollection coll = db.getCollection("physicians"); //mongoDB collections are like tables in any RDBMS
			BasicDBObject record = new BasicDBObject("id",aID).
				append("firstname",aFirstName).
				append("lastname",aLastName).
				append("address",aAddress).//append function adds a new element to the JSON
		        append("phone",aPhone); //this creates the JSON to insert
			coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	public void addInsurance(int aID, String aCompany, String aPolicy, String aPhone){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database"); 
			DBCollection coll = db.getCollection("insurances"); //mongoDB collections are like tables in any RDBMS
			BasicDBObject record = new BasicDBObject("id",aID).
				append("company",aCompany).
				append("policy",aPolicy).//append function adds a new element to the JSON
		        append("phone",aPhone); //this creates the JSON to insert
			coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	public void addMedication(int aID, String aName, String aCost, String aEffects){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database"); 
			DBCollection coll = db.getCollection("medications"); //mongoDB collections are like tables in any RDBMS
			BasicDBObject record = new BasicDBObject("id",aID).
				append("name",aName).
				append("cost",aCost).//append function adds a new element to the JSON
		        append("sideeffects",aEffects); //this creates the JSON to insert
			coll.insert(record); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
	
	/*Querying with mongoDB is somewhat like SQL. 
	 *Create a BasicDBObject with the desired field you're looking for. see below. 
	 */
	
	public Patient getPatient(String aID){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients");
			BasicDBObject query = new BasicDBObject("id", aID); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Patient aPatient = new Patient(); //create an empty patient to fill with the info from the json
			aPatient.setId(Integer.parseInt(aID));
			String aName = "This shouldn't be here call an expert";
			while(cursor.hasNext()) { //loop through all results
		       aPatient.setName(cursor.next().get("name").toString());
		       aName = cursor.next().get("name").toString();
		       aPatient.setPhoneNum(cursor.next().get("phone").toString());
		       aPatient.setDOB(cursor.next().get("dob").toString());
		       aPatient.setInsuranceProvider(cursor.next().get("insurance").toString());
			}
			cursor.close();
			aMongo.close();
			aPatient.setPerscriptionList(getPerscriptionHistory(aName));
			return aPatient;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}	
	public PerscriptionList getPerscriptionHistory(String aName){
		try {
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("perscriptions");
			BasicDBObject query = new BasicDBObject("name", aName); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			PerscriptionList aList = new PerscriptionList();
			while(cursor.hasNext()) { //loop through all results
				Prescription aPerscription = new Prescription();
				aPerscription.setPrescriptionID(Integer.parseInt(cursor.next().get("id").toString()));
				aPerscription.setMedication(cursor.next().get("medication").toString());
				aPerscription.setRefill(Integer.parseInt(cursor.next().get("refills").toString()));
				aPerscription.setDateIssued(cursor.next().get("dateissued").toString());
				aPerscription.setDateExpired(cursor.next().get("dateexpired").toString());
				aPerscription.setPhysicianID(Integer.parseInt(cursor.next().get("physician").toString()));
				aList.add(aPerscription);
			}
			cursor.close();
			aMongo.close();
			return aList;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public Medication getMedication(String aID){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("medications");
			BasicDBObject query = new BasicDBObject("id", aID); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Medication aMedication = new Medication(); //create an empty patient to fill with the info from the json
			aMedication.setID(Integer.parseInt(aID));
			while(cursor.hasNext()) { //loop through all results
		       aMedication.setName(cursor.next().get("name").toString());
		       aMedication.setCost(Double.parseDouble(cursor.next().get("cost").toString()));
		       aMedication.setSideEffects(cursor.next().get("sideeffects").toString());
			}
			cursor.close();
			aMongo.close();
			return aMedication;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public Insurance getInsurance(String aID){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("insurances");
			BasicDBObject query = new BasicDBObject("id", aID); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Insurance aInsurance = new Insurance(); //create an empty patient to fill with the info from the json
			aInsurance.setID(Integer.parseInt(aID));
			while(cursor.hasNext()) { //loop through all results
		       aInsurance.setCompanyName(cursor.next().get("company").toString());
		       aInsurance.setPolicyName(cursor.next().get("policy").toString());
		       aInsurance.setProviderPhoneNum(cursor.next().get("phone").toString());
			}
			cursor.close();
			aMongo.close();
			return aInsurance;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public Physician getPhysician(String aID){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("physicians");
			BasicDBObject query = new BasicDBObject("id", aID); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Physician aPhysician = new Physician(); //create an empty patient to fill with the info from the json
			aPhysician.setID(Integer.parseInt(aID));
			while(cursor.hasNext()) { //loop through all results
		       aPhysician.setFirstName(cursor.next().get("firstname").toString());
		       aPhysician.setAddress(cursor.next().get("address").toString());
		       aPhysician.setLastName(cursor.next().get("lastname").toString());
		       aPhysician.setPhone(cursor.next().get("phone").toString());
			}
			cursor.close();
			aMongo.close();
			return aPhysician;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public PatientList getAllPatients(){
		try {
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients");
			DBCursor cursor = coll.find(); //connects and find desired results
			PatientList aList = new PatientList();
			while(cursor.hasNext()){ //loop through all results
				Patient aPatient = new Patient();
				aPatient.setName((String) cursor.next().get("name"));
				aPatient.setPhoneNum((String) cursor.next().get("phone"));
				aPatient.setDOB((String) cursor.next().get("dob"));
				aPatient.setInsuranceProvider((String) cursor.next().get("insurance"));
				aList.add(aPatient);
			}
			cursor.close();
			aMongo.close();
			return aList;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public InsuranceList getAllInsurances(){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("insurances");
			DBCursor cursor = coll.find(); //connects and find desired results
			InsuranceList aList = new InsuranceList();
			while(cursor.hasNext()){ //loop through all results
				Insurance aInsurance = new Insurance();
				aInsurance.setCompanyName(cursor.next().get("company").toString());
				aInsurance.setPolicyName(cursor.next().get("policy").toString());
				aInsurance.setProviderPhoneNum(cursor.next().get("phone").toString());
				aList.add(aInsurance);
			}
			cursor.close();
			aMongo.close();
			return aList;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public MedicationList getAllMedications(){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("insurances");
			DBCursor cursor = coll.find(); //connects and find desired results
			MedicationList aList = new MedicationList();
			while(cursor.hasNext()){ //loop through all results
				Medication aMedication = new Medication();
				aMedication.setName(cursor.next().get("company").toString());
				aMedication.setCost(Double.parseDouble(cursor.next().get("policy").toString()));
				aMedication.setSideEffects(cursor.next().get("phone").toString());
				aList.add(aMedication);
			}
			cursor.close();
			aMongo.close();
			return aList;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public PhysicianList getAllPhysicians(){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("physicians");
			DBCursor cursor = coll.find(); //connects and find desired results
			PhysicianList aList = new PhysicianList();
			while(cursor.hasNext()){ //loop through all results
				Physician aPhysician = new Physician();
				aPhysician.setFirstName(cursor.next().get("firstname").toString());
				System.out.println(cursor.next().get("firstname").toString());
				System.out.println(cursor.next().get("firstname"));
				aPhysician.setLastName(cursor.next().get("lastname").toString());
				aPhysician.setAddress(cursor.next().get("address").toString());
				aPhysician.setPhone(cursor.next().get("phone").toString());
				aList.add(aPhysician);
			}
			cursor.close();
			aMongo.close();
			return aList;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	public Prescription getPerscription(String name, String medication){
		try {
			Mongo aMongo = new Mongo("136.224.250.156"); 
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("perscriptions");
			BasicDBObject query = new BasicDBObject("name", name); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Prescription aPerscription = new Prescription(); //create an empty patient to fill with the info from the json
			while(cursor.hasNext()) { //loop through all results
				aPerscription.setMedication(cursor.next().get("cost").toString());
				aPerscription.setRefill(Integer.parseInt(cursor.next().get("sideeffects").toString()));
				aPerscription.setDateIssued(cursor.next().get("sideeffects").toString());
				aPerscription.setDateExpired(cursor.next().get("sideeffects").toString());
				aPerscription.setPhysicianID(Integer.parseInt(cursor.next().get("sideeffects").toString()));
			}
			cursor.close();
			aMongo.close();
			return aPerscription;
		} catch (UnknownHostException e) {
			//check that Database IP and panic a little bit cause this code should never run
			return null;
		}
	}
	
	
	public void updatePatient(String aName, String aPhone, String aDOB, String aInsurance){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients"); //mongoDB collections are like tables in any RDBMS
			
			//delete old record, before adding in the updated one
			BasicDBObject recordToDelete = new BasicDBObject("name",aName);
			coll.remove(recordToDelete);
			
			//create and add new record
			BasicDBObject recordToAdd = new BasicDBObject("name",aName).
			        append("phone",aPhone). //this creates the JSON to insert
			        append("dob",aDOB).		//append function adds a new element to the JSON
			        append("insurance", aInsurance);
			coll.insert(recordToAdd); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
		
	public void updatePerscription(String medication, String refill, String dateI, String dateE, String physician){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("perscriptions"); //mongoDB collections are like tables in any RDBMS
			
			//delete old record, before adding in the updated one
			BasicDBObject recordToDelete = new BasicDBObject("name",aName);
			coll.remove(recordToDelete);
			
			//create and add new record
			BasicDBObject recordToAdd = new BasicDBObject("name",name).
			        append("phone",aPhone). //this creates the JSON to insert
			        append("dob",aDOB).		//append function adds a new element to the JSON
			        append("insurance", aInsurance);
			coll.insert(recordToAdd); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
		
	}
	public void updateMedication(String name, String cost, String effects){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients"); //mongoDB collections are like tables in any RDBMS
			
			//delete old record, before adding in the updated one
			BasicDBObject recordToDelete = new BasicDBObject("name",name);
			coll.remove(recordToDelete);
			
			//create and add new record
			BasicDBObject recordToAdd = new BasicDBObject("name",name).
			        append("cost",cost). //this creates the JSON to insert
			        append("sideeffects", effects);
			coll.insert(recordToAdd); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
		
	}
	public void updateInsurance(String company, String policy, String phone){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients"); //mongoDB collections are like tables in any RDBMS
			
			//delete old record, before adding in the updated one
			BasicDBObject recordToDelete = new BasicDBObject("company", company);
			coll.remove(recordToDelete);
			
			//create and add new record
			BasicDBObject recordToAdd = new BasicDBObject("company", company).
			        append("policy", policy).
			        append("phone",phone);
			coll.insert(recordToAdd); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
		
	}
	public void updatePhysician(String firstName, String lastName, String address, String phone){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.250.156");
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients"); //mongoDB collections are like tables in any RDBMS
			
			//delete old record, before adding in the updated one
			BasicDBObject recordToDelete = new BasicDBObject("firstname", firstName);
			coll.remove(recordToDelete);
			
			//create and add new record
			BasicDBObject recordToAdd = new BasicDBObject("firstname", firstName).
			        append("lastname",lastName). //this creates the JSON to insert
			        append("address",address).	//append function adds a new element to the JSON
			        append("phone",phone);
			coll.insert(recordToAdd); //inserts the record into the patients collection. this is the line of code that actually establishes the connection
			aMongo.close(); //closes the mongoDB connection
		} catch (UnknownHostException e) {
			//you should probably try to start the server if this code runs
			System.out.println("have you tried turning it on and off again?");
		}
	}
}