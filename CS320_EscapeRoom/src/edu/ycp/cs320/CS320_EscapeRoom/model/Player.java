package edu.ycp.cs320.CS320_EscapeRoom.model;

import java.util.ArrayList;

import edu.ycp.cs320.CS320_EscapeRoom.model.Inventory;

public class Player {
	
	int roomNumber;
	Coordinate coord;
	Inventory playerInv;
	ArrayList<String> Actions = new ArrayList<String>();
	
	public Player()
	{
		coord = new Coordinate();
		playerInv = new Inventory();
	}
	
	public void updatePlayerCoor(int x, int y)
	{
		this.coord.setCoordinate(x, y);
	}
	
	public int getPlayerx()
	{
		return this.coord.getX();
	}
	
	public int getPlayery()
	{
		return this.coord.getY();
	}
	
	public void addItemToInventory(String item)
	{
		playerInv.additem(item);
	}
	
	public void addActiontoActions(String action)
	{
		Actions.add(action);
	}
	
	public boolean hasAction(String action)
	{
		if(Actions.contains(action))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<String> Actions()
	{
		return Actions;
	}
	
	public boolean hasitem(String item)
	{
		return playerInv.hasItem(item);
	}
	
	public void setRoomNumber(int room)
	{
		roomNumber = room;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	
	
}
