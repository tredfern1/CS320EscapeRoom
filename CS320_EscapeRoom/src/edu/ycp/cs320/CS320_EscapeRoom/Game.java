package edu.ycp.cs320.CS320_EscapeRoom;

import edu.ycp.cs320.CS320_EscapeRoom.model.Player;

public class Game {
	
	
	public int score;
	Player player1;
	
	
	
	public Game()
	{
		player1 = new Player();  //create instance of all game related
								 // need to figure out how to save game, maybe related to player
		//add more game related variables
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
