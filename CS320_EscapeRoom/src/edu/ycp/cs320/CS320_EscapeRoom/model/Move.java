package edu.ycp.cs320.CS320_EscapeRoom.model;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;

public class Move {

	//splits the move into two separate strings in an array
	public String[] split(String move) {
	
		
		return move.split(" ");
		

	}
	
	//if the command consists of two words it is considered valid
	//if not then the move is not valid
	public boolean validate(String[] move) {
		if(move.length == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getOutput(String[] move) {
		String output = null;
		System.out.println(move[0]);
		System.out.println(move[1]);
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
				output = "f";
			}
		}
		else {
			output = "your move does nothing";
		}
		return output;
	}
	
	
}
