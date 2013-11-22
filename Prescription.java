// Prescription Class
// Contains prescription information such as: Prescription ID, Medication, Refill, Date Issued, Date Expired, and Physician ID
// Author: Matt Chevalier
// Date: 11/22/2013

public class Prescription {
 	
 	//Private Varibles with default values
   	private int    prescriptionID = -1;
   	private String medication = "N/A";
   	private int    refill = -1;
   	private String dateIssued = "N/A";
   	private String dateExpired = "N/A";
   	private int    physicianID = "-1"
 

 	//SETS
   	public void setPrescriptionID(int aPrescriptionID){
     	this.prescriptionID = aPrescriptionID;
   	}
 
   	public void setMedication(String aMedication){
     	this.medication = aMedication;
   	}
 
   	public void setRefill(int aRefill){
     	this.refill = aRefill;
   	}
 
   	public void setDateIssued(String aDateIssued){
     	this.dateIssued = aDateIssued;
   	}
 
   	public void setDateExpired(String aDateExpired){
     	this.dateExpired = aDateExpired;
   	}
 
   	public void setPhysicianID(int aPhysicianID){
     	this.physicianID = aPhysicianID;
   	}
 

 	//GETS
   	public int getPrescriptionID() {
       	return this.prescriptionID;
   	}
 
   	public String getMedication() {
       	return this.medication;
   	}
 
   	public int getRefill() {
       	return this.refill;
   	}
 
   	public String getDateIssued() {
       	return this.dateIssued;
   	}
 
   	public String getDateExpired()) {
      	return this.dateExpired;
   	}
 
   	public int getPhysicianID() {
       	return this.physicianID;
   	}
 
   	public Prescription() {
       //empty constructor
   	}
 
 	//Contstructor
   	public Prescription(int prescriptionID, String medication, int refill, String dateIssued, String dateExpired, int physicianID) {
       	this();
       	this.prescriptionID = aPrescriptionID;
       	this.medication = aMedication;
       	this.refill = aRefill;
       	this.dateIssued = aDateIssued;
       	this.dateExpired = aDateExpired;
       	this.physicianID = aPhysicianID;
   	}

   	//toString Method
   	public  String toString() {
   		String aString = "";
   		aString = "Prescription ID: " + this.prescriptionID + "\n";
   		aString =  aString + "Medication: " + this.medication + "\n";
   		aString =  aString + "Refill: " + this.refill + "\n";
   		aString =  aString + "Date Issued: " + this.dateIssued + "\n";
   		aString =  aString + "Date Expired: " + this.dateExpired + "\n";
   		aString =  aString + "physician ID: " + this.physicianID + "\n";
   		return aString;
	}
 
 }
