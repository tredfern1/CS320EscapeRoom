package edu.ycp.cs320.CS320_EscapeRoom.model;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;

public class Move {

	//splits the move into two separate strings in an array
	public String[] split(String move) {
		return move.split(" ");
	}
	
	//if the command consists of two words it is considered valid
	//if not then the move is not valid
	public boolean validate(String[] move, int playerx, int playery, Spot spot, Player player1) {
		if(move.length == 2) { //MOVE VALIDATION /////////////////////
			if(move[0].contains("go")) {
				if(move[1].contains("north") && player1.hasAction("unlock1") && playerx == 1 && playery == 2 && player1.getRoomNumber() == 1)
				{
					return true;
				}
				else if(move[1].contains("south") && player1.hasAction("unlock1") && playerx == 1 && playery == 0 && player1.getRoomNumber() == 2)
				{
					return true;
				}
				else
				{
					if(move[1].contains("north") && playery + 1 <= 2) {
						return true;
					}
					else if(move[1].contains("east") && playerx + 1 <= 2) {
						return true;
					}
					else if(move[1].contains("south") && playery - 1 >= 0) {
						return true;
					}
					else if(move[1].contains("west")&& playerx - 1 >= 0) {
						return true;
					}
					else {
						return false;
					}
				}
			}
			else if(move[0].contains("pickup")) //PICKUP VALIDATION //////////////////////
			{
				if(spot.hasItem(move[1]) && !player1.hasitem(move[1]))
				{
					return true;
				} //add more items here
		
				else
				{
					return false;
				}
			}
			else if(move[0].contains("use")) //USE VALIDATION
			{
				if(move[1].contains("hammer") && player1.hasitem("hammer") &&  !player1.hasAction("boxBreak") && spot.hasItem("redkey"))
				{
					return true;
				} //add more items here
				if(move[1].contains("redkey") && player1.hasitem("redkey") &&  !player1.hasAction("unlock1") && playerx == 1 && playery == 2)
				{
					return true;
				} //add more items here
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
	//THIS ASSUMES THAT ALL THE VALIDATION HAS BEEN CHECKED FOR IN THE ABOVE CLASS DO NOT PUT ANY VALIDATION BELOW(EXCEPT FOR ROOM CHANGES)
	public String getOutput(String[] move, Player player1) {
		String output = null;

		if(move[0].contains("go")) {         //move outputs
			if(move[1].contains("north")) {
				if(player1.hasAction("unlock1") && player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 1) //ROOM CHANGE VALIDATION
				{
					output = "you changed rooms";
				}
				else
				{
					output = "you went north";
				}
			}
			else if(move[1].contains("east")) {
				output = "you went east";
			}
			else if(move[1].contains("south")) {
				if(player1.hasAction("unlock1") && player1.getPlayerx() == 1 && player1.getPlayery() == 0 && player1.getRoomNumber() == 2) //ROOM CHANGE VALIDATION
				{
					output = "you went back to room 1";
				}
				else
				{
					output = "you went south";
				}
			}
			else if(move[1].contains("west")) {
				output = "you went west";
			}
			else {
				output = "your move does nothing";
			}
		}
		else if(move[0].contains("pickup"))   //pickup outputs
		{
			output = "You picked up a " + move[1];
		
		}
		else if(move[0].contains("use"))
		{
				output = "You used the " + move[1];
		}
		else {
			output = "your move does nothing";
		}
		
		
		return output;
	}
	
	
}
