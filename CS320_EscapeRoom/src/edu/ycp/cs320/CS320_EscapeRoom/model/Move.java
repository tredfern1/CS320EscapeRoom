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
			if(move[0].contains("go") || move[0].contains("walk") || move[0].contains("move")) {
				if(move[1].contains("north") && player1.hasAction("unlock1") && playerx == 1 && playery == 2 && player1.getRoomNumber() == 1)
				{
					return true;
				}
				else if(move[1].contains("south") && player1.hasAction("unlock1") && playerx == 1 && playery == 0 && player1.getRoomNumber() == 2)
				{
					return true;
				}
				//validate being able to enter room 3 from room 2 (currently there are no conditions to do this)
				else if (move[1].contains("north") && playerx == 1 && playery == 2 && player1.getRoomNumber() == 2) {
					return true;
				}
				//validate being able to enter room 2 from room 3
				else if (move[1].contains("south") && playerx == 1 && playery == 0 && player1.getRoomNumber() == 3) {
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
			else if(move[0].contains("pickup") || move[0].contains("take") || move[0].contains("grab")) //PICKUP VALIDATION //////////////////////
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
				if(move[1].contains("torch") && player1.hasitem("torch") && !player1.hasAction("litroom") && player1.getPlayerx() == 2 && player1.getPlayery() == 2) {
					return true;
				}

				if(move[1].contains("rat") && player1.hasitem("rat") && player1.getPlayerx()==0 && player1.getPlayery()==1 && player1.getRoomNumber()==2) {
					return true;
				}
				
				else
				{
					return false;
				}
			}
			else if(move[0].contains("enter")) {
				System.out.println("entercheck");
				if(move[1].contains("6851") && spot.hasItem("bluekey")) {
					return true;
				}
				else{
				return false;
				}
				
			}
			else if(move[0].contains("drop")) {
				System.out.println("dropcheck");
				if(player1.hasitem(move[1])) {
					return true;
				}
			}

		}

		else {
			return false;
		}
		return false;

	}
	
	
	//THIS ASSUMES THAT ALL THE VALIDATION HAS BEEN CHECKED FOR IN THE ABOVE CLASS DO NOT PUT ANY VALIDATION BELOW(EXCEPT FOR ROOM CHANGES)
	public String getOutput(String[] move, Player player1) {
		String output = null;

		if(move[0].contains("go") || move[0].contains("move") || move[0].contains("walk")) {         //move outputs
			if(move[1].contains("north")) {	
				
				if(player1.hasAction("unlock1") == true && player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 1) //ROOM CHANGE VALIDATION
				{
					output = "you changed rooms";
				}
				//move from room 2 to room 3
				else if(player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 2) {
					output = "you enter room 3";
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
				if(player1.hasAction("unlock1") == true && player1.getPlayerx() == 1 && player1.getPlayery() == 0 && player1.getRoomNumber() == 2) //ROOM CHANGE VALIDATION
				{
					output = "you went back to room 1";
				}
				
				//move from room 3 to room 2
				else if(player1.getPlayerx() == 1 && player1.getPlayery() == 0 && player1.getRoomNumber() == 3) {
					output = "you returned to room 2";
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
		else if(move[0].contains("pickup") || move[0].contains("take") || move[0].contains("grab"))   //pickup outputs
		{
			output = "You picked up a " + move[1];
		
		}
		else if(move[0].contains("use"))
		{
				output = "You used the " + move[1];
		}
		else if(move[0].contains("enter") && player1.getPlayerx() == 0 && player1.getPlayery() == 2){
			if(move[1].contains("6851"))
				output = "you've unlocked the safe!";
		}
		else if(move[0].contains("drop")) {
			output = "You dropped the " + move[1];
		}
		else {
			output = "your move does nothing";
		}

		
		return output;
	}
	
	
}
