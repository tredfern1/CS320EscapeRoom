package edu.ycp.cs320.CS320_EscapeRoom.model;

import java.util.Arrays;

public class Inventory {
	
	String[] playerInventory = {}; //stores items and keys the player has
	
	public Inventory()
	{
		Arrays.fill(playerInventory, null); //creates empty array anytime inventory is called
		
	}
	
	
}
