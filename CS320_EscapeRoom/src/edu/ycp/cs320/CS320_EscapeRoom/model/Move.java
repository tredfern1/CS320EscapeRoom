package edu.ycp.cs320.CS320_EscapeRoom.model;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;

public class Move {

	//splits the move into two separate strings in an array
	public String[] split(String move) {
	
		
		return move.split(" ");
		

	}
	
	//if the command consists of two words it is considered valid
	//if not then the move is not valid
	public boolean validate(String[] move, int playerx, int playery) {
		if(move.length == 2) {
			if(move[0].contains("go")) {
				if(move[1].contains("north") && playery + 1 <= 1) {
					return true;
				}
				else if(move[1].contains("east")&& playerx + 1 <= 1) {
					return true;
				}
				else if(move[1].contains("south") && playery - 1 >= -1) {
					return true;
				}
				else if(move[1].contains("west")&& playerx - 1 >= -1) {
					return true;
				}
				else {
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
	
	public String getOutput(String[] move) {
		String output = null;

		if(move[0].contains("go")) {
			if(move[1].contains("north")) {
				output = "you went north";
			}
			else if(move[1].contains("east")) {
				output = "you went east";
			}
			else if(move[1].contains("south")) {
				output = "you went south";
			}
			else if(move[1].contains("west")) {
				output = "you went west";
			}
			else {
				output = "your move does nothing";
			}
		}
		else {
			output = "your move does nothing";
		}
		return output;
	}
	
	
}
