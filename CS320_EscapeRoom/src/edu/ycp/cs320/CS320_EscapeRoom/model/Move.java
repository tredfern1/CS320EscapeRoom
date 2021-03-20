package edu.ycp.cs320.CS320_EscapeRoom.model;

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
		if(move[0] == "go") {
			if(move[1] == "north") {
				output = "you went north";
			}
			else if(move[1] == "east") {
				output = "you went east";
			}
			else if(move[1] == "south") {
				output = "you went south";
			}
			else if(move[1] == "west") {
				output = "you went west";
			}
		}
		else {
			output = "your move does nothing";
		}
		return output;
	}
	
	
}
