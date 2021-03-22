package edu.ycp.cs320.CS320_EscapeRoom.model;

import edu.ycp.cs320.CS320_EscapeRoom.model.Inventory;

public class Player {

	Coordinate coord;
	Inventory playerInv;
	
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
	
}
