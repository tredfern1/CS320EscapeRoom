package controller;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
import model.Author;

public class DatabaseLogic {

	private IDatabase db = null;

	public DatabaseLogic() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public int getRoom() {
		
		// get the list of (Author, Book) pairs from DB
		int room = db.getRoom();

		System.out.println("The call from the class is: " + room);
		// return authors for this title
		return room;
	}
	
	public void setRoom(int room) {
		//set the room from the given room number
		db.setRoom(room);
	}
	
	public List<String> getLog() {
		//set the room from the given room number
		List<String> result = new ArrayList<String>();
		result = db.getLog();
		return result;
	}
	
	public void addLog(String line) {
		//set the room from the given room number
		db.addLog(line);
	}
	
	
}
