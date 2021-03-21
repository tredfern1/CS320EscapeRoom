package edu.ycp.cs320.CS320_EscapeRoom.model;
public class Spot {
	
	//private int roomNumber;
	private Coordinate location;
	private String[] items;
	private String[] descriptions;
	
	private boolean isStartingSpot;
	boolean isWall;
	boolean isWin;
	boolean isDoor;
	
	Spot (int roomNumber, Coordinate location, String[] items, String[] descriptions, boolean isStartingSpot, boolean isWall, boolean isWin, boolean isDoor){
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
	
	public Coordinate getSpotLocation() {
		return location;
	}
	
	
	
}