package edu.ycp.cs320.CS320_EscapeRoom;


public class Room {
	
	private int roomNumber;
	private Coordinate[] locations;
	private Items[] items;
	private String[][][] Descriptions;
	private boolean startInRoom;
	private Coordinate startLocation;
	
	Room (int roomNumber, Coordinate[] locations, Items[] items, String[][][] Descriptions, boolean startInRoom, Coordinate startLocation){
		this.roomNumber = roomNumber;
		this.locations = locations;
		this.items = items;
		this.Descriptions = Descriptions;
		this.startInRoom = startInRoom;
		this.startLocation = startLocation;
	}
	
	
	/*
	 * returns a description based on the location
	 * Strings are stored in a 3D array, based on the position and state in the format:
	 * Description[x][y][state]
	 */
	public String lookAround(Coordinate c, int state) {
		return Descriptions[c.getX()][c.getY()][state];
	}
	
	public Coordinate checkCoordinate() {
		return locations;
	}
	
	
	
}