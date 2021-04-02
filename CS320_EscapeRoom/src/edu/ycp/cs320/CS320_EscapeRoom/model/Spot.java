package edu.ycp.cs320.CS320_EscapeRoom.model;

import java.util.ArrayList;

public class Spot {
	
	private Coordinate location;
	private String[] items;
	private ArrayList<String> descriptions = new ArrayList<String>();
	
	private boolean isStartingSpot;
	boolean isWall;
	boolean isWin;
	boolean isDoor;
	
	Spot (Coordinate location, String[] items, ArrayList<String> descriptions, boolean isStartingSpot, boolean isWall, boolean isWin, boolean isDoor){
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
		return descriptions.get(0);
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
	
	public void setdescription(String line)
	{
		this.descriptions.add(line);
	}
	
}