package edu.ycp.cs320.CS320_EscapeRoom.controller;

import edu.ycp.cs320.CS320_EscapeRoom.model.Move;

public class GameController {
	
	private Move model;
	
	public void setModel(Move model) {
		this.model = model;
	}
	
	
	public String getOuput(String move) {
		
		if(model.validate(model.split(move))) {
			return model.getOutput(model.split(move));
		}
		else {
			return "invalid move";
		}
	}
	

}
