package edu.ycp.cs320.CS320_EscapeRoom.controller;

import edu.ycp.cs320.CS320_EscapeRoom.model.Move;
import edu.ycp.cs320.CS320_EscapeRoom.model.Player;
import edu.ycp.cs320.CS320_EscapeRoom.model.Map;


public class GameController {
	
	
	private Move model;
	public int score;
	Player player1;
	Map map1;
	
	public GameController(int playerx, int playery)
	{
		player1 = new Player();//create instance of all game related			 // need to figure out how to save game, maybe related to player//add more game related variables
		this.getPlayer().updatePlayerCoor(playerx, playery); //player coord

	}

	public void setModel(Move model) {
		this.model = model;
	}
	
	public Player getPlayer()
	{
		return player1;
	}
	
	public void setPlayer(Player p)
	{
		player1 = p;
	}
	
	
	public String getOuput(String move) {
		
		if(model.validate(model.split(move), player1.getPlayerx(), player1.getPlayery())) {
			return model.getOutput(model.split(move));
		}
		else {
			return "invalid move";
		}
	}
	

	public void updateScore() // Call to update the score when move is made 
	{
		score += 1;
	}
	
	public void newGame()
	{
		player1 = new Player(); //call to reset the game, resets by instancing all game related variables
		//add more 
	}
	
	public void returnMenu()
	{
		//TODO return to menu code 
	}
	
	
	
}
