
//<<<<<<< HEAD:CS320_EscapeRoom/src/edu/ycp/cs320/CS320_EscapeRoom/Door.java
//package edu.ycp.cs320.CS320_EscapeRoom;

package edu.ycp.cs320.CS320_EscapeRoom.model;
//>>>>>>> main:CS320_EscapeRoom/src/edu/ycp/cs320/CS320_EscapeRoom/model/Door.java

public class Door {
	
	private Spot isPartOf;
	private boolean isOpen;
	
	Door (Spot s, boolean isOpen) {
		this.isPartOf = s;
		this.isOpen = isOpen;
	}
	
	//unlocks a door
	public void unlock() {
		isOpen = true;
	}
	
	//returns the coordinate where a door is located
	/*
	public Coordinate getLocation() {
		return isPartOf.getSpotLocation();
	}
	*/
	
	//returns wether a door is locked or open
	//false = locked, true = open
	public boolean isOpen() {
		return isOpen;
	}
}
