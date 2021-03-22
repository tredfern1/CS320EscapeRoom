package edu.ycp.cs320.CS320_EscapeRoom.model;
public class Spot {
	
	private Coordinate location;
	private String[] items;
	private String[] descriptions;
	
	private boolean isStartingSpot;
	boolean isWall;
	boolean isWin;
	boolean isDoor;
	
	Spot (Coordinate location, String[] items, String[] descriptions, boolean isStartingSpot, boolean isWall, boolean isWin, boolean isDoor){
		//this.roomNumber = roomNumber;
		this.location = location;
		this.items = items;
		this.descriptions = descriptions;
		this.isStartingSpot = isStartingSpot;
		this.isWall = isWall;
		this.isWin = isWin;
		this.isDoor = isDoor;
	}
	
	
	/*
	 * Returns a description based on the state of the spot
	 * Default state should be 0
	 */
	public String lookAround(int state) {
		return descriptions[state];
	}
	
	//returns the Coordinate where a spot is located
	public Coordinate getSpotLocation() {
		return location;
	}
	
	//returns the item in the provided index in the array of items in the spot
	public String getItem(int index) {
		return items[index];
	}
	
	//TODO: will remove an item from the spot
	public void removeItem(String itemName) {
		
	}
	
}