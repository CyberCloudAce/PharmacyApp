import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
public class DataAccessClass {
	/* The purpose of this class is to connect to the MongoDB server running on a VM server
	 * 
	 * as of 12/6 the VM Server is on Jeff's Laptop
	 * because of this the IP will change depending on the location of the VM
	 * 
	 * Trying to move VM to a permanent place
	 * May be migrated to a server in SET 446 soon
	 * Or on an ESXI server
	 */
	public void addPatient(int aID, String aName, String aPhone, String aDOB, String aInsurance){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
	public void addMedication(int aID, String aName, Double aCost, String aEffects){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.251.233"); //.91.185 on wifi .251.233 in peet
			DB db = aMongo.getDB("database"); //not sure what this does but apparently it's necessary
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
			Mongo aMongo = new Mongo("136.224.251.233"); //91.185 on wifi 251.233 in peet
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("patients");
			BasicDBObject query = new BasicDBObject("id", aID); //desired result
			DBCursor cursor = coll.find(query); //connects and find desired results
			Patient aPatient = new Patient(); //create an empty patient to fill with the info from the json
			aPatient.setId(Integer.parseInt(aID));
			String aName = "This shouldn't be here call an expert";
			while(cursor.hasNext()) { //loop through all results
		       System.out.println(cursor.next()); 
		       System.out.println(cursor.next().get("name")); 
		       aPatient.setName(cursor.next().get("name").toString());
		       aName = cursor.next().get("name").toString();
		       aPatient.setName(cursor.next().get("phone").toString());
		       aPatient.setName(cursor.next().get("dob").toString());
		       aPatient.setName(cursor.next().get("insurance").toString());
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
			Mongo aMongo = new Mongo("136.224.251.233"); //91.185 on wifi 251.233 in peet
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
	public Medication getMedication(){
		
		return null;
	}
	public Insurance getInsurance(){
		
		return null;
	}
	public Physician getPhysician(){
		
		return null;
	}
	
	
	public void getAllPatients(){
		
		
	}
	public void getAllInsurance(){
		
		
	}
	public void getAllMedications(){
		
		
	}
	public void getAllPhysicians(){
		
		
	}
	
	
	
}