package controller;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

import model.Coordinate;

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

		// return authors for this title
		return room;
	}
	
	public void setRoom(int room) {
		//set the room from the given room number
		db.setRoom(room);
	}
	

	public String getPlayerInv() {
		String inv = db.getPlayerInv();
		return inv;
	}
	  
	
	public void addItemToPlayerInv(String item) {
		db.addItemToPlayerInv(item);

	}
	
	public void removeItemFromPlayerInv(String item) {
		db.removeItemFromPlayerInv(item);

	}
	
	public void updatePlayerInv(String items) {
		db.updatePlayerInv(items);
	}
	
	public String getActions() {
		String actions = db.getActions();

		return actions;
	}
	
	public void addAction(String action) {
		db.addAction(action);

	}
	
	public void remvoveAction(String action) {
		db.removeAction(action);

	}

	public void addItemToMapInventory(String item, String coordinate) {
		db.addToMapInventory(item, coordinate);
	}
	
	public String getMapInventory() {
		return db.getMapInventory();
	}

	
	public List<String> getLog() {
		//set the room from the given room number
		List<String> result = new ArrayList<String>();
		result = db.getLog();
		return result;
	}

	public List<String> addLog(String line){
		List<String> result = new ArrayList<String>();
		result = db.addLog(line);
		return result;
	}
	
	public void removeFromMapInventory(String item) {
		db.removeFromMapInventory(item);
	}
	
	public int getCoordinateX() {
		return db.getCoordinateX();
	}

	public int getCoordinateY() {
		return db.getCoordinateY();
	}
	
	public void setCoordinate(Coordinate coord) {
		db.setCoordinate(coord);
	}
	
	public void setMapInventory(String mapInventory) {
		db.setMapInventory(mapInventory);
	}

	
	public void updateActions(String actions) {
		db.updateActions(actions);
	}
	
	public int getHiddenStatus(String item) {
		return db.getHiddenStatus(item);
	}
	
	public void setHiddenStatus(String item) {
		db.setHiddenStatus(item);
	}
	
	public void restartGame() {
		db.restartGame();
	}
	
	public void loadGameWithDescription()
	{
		db.loadInitialData3();
	}
	
	public void loadGame() {
		db.loadInitialData2();
	}
	
	public void setHighScore(int score) {
		db.updateHighScore(score);
	}
	
	public int getHighScore() {
		return db.getHighScore();
	}
	
}
