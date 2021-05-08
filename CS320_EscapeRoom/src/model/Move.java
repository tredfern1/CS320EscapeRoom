package model;

import controller.Game;

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
				//validate being able to enter room 3 from room 2 
				else if (move[1].contains("north") && playerx == 1 && playery == 2 && player1.getRoomNumber() == 2 && player1.hasAction("unlock2")) {
					return true;
				}
				//validate being able to enter room 4 from room 3 
				else if (move[1].contains("north") && playerx == 1 && playery == 2 && player1.getRoomNumber() == 3 && player1.hasAction("pianoSolved")) {
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
					if(move[1].contains("redkey"))
					{
						if(player1.hasAction("boxBreak"))
						{
							return true;
						}
						else
						{
							return false;
						}
					}
					else if(move[1].contains("bluekey"))
					{
						if(player1.hasAction("opensafe"))
						{
							return true;
						}
						else
						{
							return false;
						}
					}
					else if(move[1].contains("goldnugget"))
					{
						if(player1.hasAction("lever"))
						{
							return true;
						}
						else
						{
							return false;
						}
					}
					else
					{
						return true;
					}
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
				
				if(move[1].contains("lever") && player1.getPlayerx()==2 && player1.getPlayery()==0 && player1.getRoomNumber()==1) {
					return true;
				}
				
				//for unlocking second door
				if(move[1].contains("bluekey") && player1.getPlayerx()==1 && player1.getPlayery()==2 && player1.getRoomNumber()==2 && !player1.hasAction("unlock2")) {
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
			else if(move[0].contains("play")) {
				return true;
			}
			else if(move[0].contains("check"))
			{
				return true;
			}
			
		}
		//validation for one word commands
		else if (move.length == 1) {
			if (move[0].contains("hint")) {
				return true;
			}
			else if(move[0].contains("restart")) {
				return true;
			}
			else if(move[0].contains("help")) {
				return true;
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

		System.out.println("testing to fix room 1 bug: " + player1.getPlayerx() + " : " + player1.getPlayery() + " : " + player1.getRoomNumber());
		if(move[0].contains("go") || move[0].contains("move") || move[0].contains("walk")) {         //move outputs
			if(move[1].contains("north")) {
				
				if( player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 1) //ROOM CHANGE VALIDATION
				{
					System.out.println("testing to see if room change condition is hit");
					output = "you changed rooms";
				}
				else if( player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 3)  {
					output = "you've escaped the rooms!";
				}
				
				//move from room 2 to room 3
				else if(player1.getPlayerx() == 1 && player1.getPlayery() == 2 && player1.getRoomNumber() == 2 && player1.hasAction("unlock2")) {
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
		//outputs related to the piano puzzle in room 3
		else if(move[0].contains("play")) {
			if (move[1].contentEquals("A") || move[1].contentEquals("B") || move[1].contentEquals("D")) {
				output = "You play a(n) " + move[1] +". Nothing happens.";
			}
			else if (move[1].contentEquals("C") ) {
				output = "You play a C. There is a loud click, it sounds like that was the correct answer.";
			}
			else {
				output = "Play a note! A, B, C, or D";
			}
		}
		else if(move[0].contains("restart"))
		{
			output = "You restarted the game";
		}
		else if(move[0].contains("check") && move[1].contains("inventory"))
		{
			output = "Inventory: " + player1.getInventory();
		}
		else if(move[0].contains("help"))
		{
			output = "Commands: ";
		}
		else {
			output = "your move does nothing";
		}

		System.out.println("testing output for room change bug : " + output);
		return output;
	}
	
	
}
