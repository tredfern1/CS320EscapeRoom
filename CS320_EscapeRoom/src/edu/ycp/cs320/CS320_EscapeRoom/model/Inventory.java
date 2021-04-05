package edu.ycp.cs320.CS320_EscapeRoom.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
	
	ArrayList<String> playerInventory; //stores items and keys the player has
	
	public Inventory()
	{
		playerInventory = new ArrayList<String>(); //creates empty array anytime inventory is called
	}
	
	public void additem(String item)
	{
		playerInventory.add(item);
	}
	
	public boolean hasItem(String item)
	{
		if(playerInventory.contains(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int invSize()
	{
		return playerInventory.size();
	}

}
