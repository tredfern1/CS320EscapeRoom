package edu.ycp.cs320.CS320_EscapeRoom.controller;

import edu.ycp.cs320.CS320_EscapeRoom.model.Move;
import edu.ycp.cs320.CS320_EscapeRoom.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.ycp.cs320.CS320_EscapeRoom.model.Logic;
import edu.ycp.cs320.CS320_EscapeRoom.model.Map;


public class GameController {
	
	private Move model;
	public int score;
	Player player1;
	Map map1;
	Logic logic1;
	
	public GameController(int playerx, int playery, String Inventory, String Actions, String MapInventory, int room)
	{
		
		logic1 = new Logic();
		player1 = new Player();//create instance of all game related
		player1.setRoomNumber(room);
		this.getPlayer().updatePlayerCoor(playerx, playery); //player coord
		//update inventory by converting string to arraylist
		String[] temp = Inventory.split(" ");
		List<String> newInv = new ArrayList<String>();
		newInv = Arrays.asList(temp);
		//Now update player inventory with this new arraylist
		for(int i = 0; i < newInv.size(); i++)
		{
			player1.addItemToInventory(newInv.get(i));
		}
		//do the same for the actions array
		temp = Actions.split(" ");
		List<String> newActions = new ArrayList<String>();
		newActions = Arrays.asList(temp);
		//Now update player inventory with this new arraylist
		for(int i = 0; i < newActions.size(); i++)
		{
			player1.addActiontoActions(newActions.get(i));
		}
		//do the same for map inventory, take the string and convert to arraylist
		temp = MapInventory.split(" ");
		List<String> newMapInventory = new ArrayList<String>();
		newMapInventory = Arrays.asList(temp);
		//UPDATE THE MAP WITH ITEMS
		map1 = new Map(room, newMapInventory); //get map

	}

	public void setModel(Move model) {
		this.model = model;
	}
	
	public String getSpotDescription(int playerx, int playery, String mapInventory)
	{
		int descriptionIndex = 0;
		String description = "";
		
		if(playerx == 0 && playery == 1 && !map1.getSpot(0, 1).hasItem("hammer") && player1.getRoomNumber() == 1) //change hammer room description
		{
			descriptionIndex = 1;
		}
		else if(playerx == 0 && playery == 2 && player1.hasAction("boxBreak")&& player1.getRoomNumber() == 1) //change box room description
		{
			descriptionIndex = 1;
			if(player1.hasitem("redkey"))
			{
				descriptionIndex = 2;
			}
		}
		else if(playerx == 1 && playery == 2 && player1.hasAction("unlock1") && player1.getRoomNumber() == 1) //change box room description
		{
			descriptionIndex = 1;
		}
	
		
		
		description = map1.getSpot(playerx, playery).getdescriptionAt(descriptionIndex);
		
		String[] itemChecker = mapInventory.split(" ");
			
		for(int i = 1; i < itemChecker.length; i++) {
			System.out.println(itemChecker[i].charAt(0));
			if(itemChecker[i].charAt(0) == playerx && itemChecker[i].charAt(1) == playery && itemChecker[i].charAt(2) == player1.getRoomNumber()) {
				description = description + itemChecker[i].substring(3);
			}
		}

		return description;
	}
	
	public Player getPlayer()
	{
		return player1;
	}
	
	public void setPlayer(Player p)
	{
		player1 = p;
	}
	
	
	public String getOutput(String move) {
		
		if(model.validate(model.split(move), player1.getPlayerx(), player1.getPlayery(), map1.getSpot(player1.getPlayerx(), player1.getPlayery()), player1)) {
			
			//if there is nothing after "go" in the move
			if (move.replace("go", "").contentEquals("") || move.replace("go", "").contentEquals(" ")) {
				return "You cannot do that";
			}
			
			return model.getOutput(model.split(move), player1);
		}
		else {
			String[] command = model.split(move);
			if(command[0].contains("go"))
			{
				return "Ouch, you hit a wall";
			}
			else if(command[0].contains("pickup"))
			{
				return "You can't pickup anything";
			}
			else if(command[0].contains("use"))
			{
				return "You can't use that here";
			}
			else
			{
				return "You cannot do that";
			}
		}
	}
	

	public void updateScore() // Call to update the score when move is made 
	{
		score += 1;
	}
	
	public String getPickupLogic(String move, String result, String Inventory)
	{
		return logic1.LogicPickup(move, result, Inventory); 
	}
	
	public String getMapPickupLogic(String move, String result, String MapInventory, Player player1)
	{
		return logic1.LogicPickupMapInventory(move, result, MapInventory, player1); 
	}
	
	public String getActionsLogic(String move, String result, String Inventory, String Actions)
	{
		return logic1.LogicActions(move, result, Inventory, Actions); 
	}

	
	
}
