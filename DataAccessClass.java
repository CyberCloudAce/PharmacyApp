import java.net.UnknownHostException;

import com.mongodb.*;
public class DataAccessClass {
	/* The purpose of this class is to connect to the MongoDB server running on a VM server
	 * as of 12/6 the VM Server is on Jeff's Laptop
	 * 
	 * May be migrated to a server in SET 446 soon
	 * 
	 */
	
	public void getDB(){
		try { //Must use try catch with DB connection - Mongo class throws UnknownHostException
			Mongo aMongo = new Mongo("136.224.91.185"); //91.185 on wifi 251.233 in peet
			DB db = aMongo.getDB("database");
			String x = aMongo.getConnectPoint() + "   " + db.toString();
			System.out.println(x);
			DBCollection coll = db.getCollection("testCollection");
			BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                    append("type", "database").
                    append("count", 1).
                    append("info", new BasicDBObject("x", 203).append("y", 102));
			coll.insert(doc);
			aMongo.close();
		} catch (UnknownHostException e) {
			System.out.println("welp");
		}	
	}
	
	public void addPatient(){
		
		
	}
	public void addPerscriptionHistory(){
		
		
	}
	public void addPhysician(){
		
		
	}
	public void addInsurance(){
		
		
	}
	public void addMedication(){
		

	}
	
	
	public void getPatient(){
		
		try {
			Mongo aMongo = new Mongo("136.224.91.185"); //91.185 on wifi 251.233 in peet
			DB db = aMongo.getDB("database");
			DBCollection coll = db.getCollection("testCollection");
			DBCursor cursor = coll.find();
			while(cursor.hasNext()) {
		       System.out.println(cursor.next());
			}
			cursor.close();
			aMongo.close();
		} catch (UnknownHostException e) {
			//123456789
		}
	}
	public void getMedication(){
		
		
	}
	public void getPerscriptionHistory(){
		
		
	}
	public void getInsurance(){
		
		
	}
	public void getPhysician(){
		
		
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