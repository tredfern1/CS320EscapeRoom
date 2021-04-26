package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Coordinate;
import model.Logic;
import model.Map;
import model.Move;
import model.Player;


public class Game {
	
	private Move model;
	public int score;
	public Integer x;
	public Integer y;
	public Integer room;
	String Inventory;
	String MapInventory;
	String Actions;
	String result;
	String description;
	String move;
	List<String> log;
	
	Player player1;
	Map map1;
	Logic logic1;
	
	
	public Game()
	{
		GetData(); //GET DATA FROM DATABASE
		updateGameLogic();
	}
	
	
	public void updateGameLogic()
	{
		model = new Move();
		logic1 = new Logic();
		player1 = new Player();//create instance of all game related
		player1.setRoomNumber(room);
		this.getPlayer().updatePlayerCoor(x, y); //player coord
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
	
	public void getInput(String move1)
	{
		move = move1;
		result = getOutput(move);
		handleInput();
	}
	
	public void handleInput()
	{
		if (result == "you went north") {
			y = y + 1;
		} else if (result == "you went south") {
			y = y - 1;
		} else if (result == "you went west") {
			x = x - 1;
		} else if (result == "you went east") {
			x = x + 1;
		} else if (result == "you changed rooms") {  //if the player changes rooms
			x = 1;
			y = 0;
			room = 2;
		} else if (result == "you went back to room 1") {  //if the player changes rooms
			x = 1;
			y = 2;
			room = 1;
		} else if (result == "you enter room 3") { //moving from room 2 to room 3
			x = 1;
			y = 0;
			room = 3;
		} else if (result == "you returned to room 2"){ //moving from room 3 to room 2
			x = 1;
			y = 2;
			room = 2;
		}
		//
		Coordinate coord = new Coordinate();
		coord.setCoordinate(x, y);
		
		
		Inventory = getPickupLogic(move, result, Inventory);
		MapInventory = getMapPickupLogic(move, result, MapInventory, getPlayer());
		Actions = getActionsLogic(move, result, Inventory, Actions);
		
		updateGameLogic(); //Need to call this so it updates the logic of pickups and drops
		
		description = getSpotDescription(x, y, MapInventory);
		System.out.println("Map Inv: " + MapInventory);
		System.out.println("This is description: " + description);

		
		//Set the newly calculated data
		SetData(result, description, coord);
	}
	
	
	public void GetData()
	{
		//THIS LOADS THE DATABASE CONTROLLER TO USE FOR LOADING & SAVING THE GAMESTATE
				DatabaseLogic database = null;	
				database = new DatabaseLogic();
				//SET THE VALUES THE GAME USES BASED ON THE DATABASE VALUES
				room = database.getRoom();
				x = database.getCoordinateX();
				y = database.getCoordinateY();
				Inventory = database.getPlayerInv();
				MapInventory = database.getMapInventory();
				Actions = database.getActions();
				log = database.getLog();
	}
	
	public void SetData(String result, String description, Coordinate coord)
	{
		
		DatabaseLogic database = null;
		database = new DatabaseLogic();
		// STORE THE NEW VALUES IN THE DATABASE///////////////////
		database.setCoordinate(coord);
		database.setRoom(room);
		database.getPlayerInv();
		database.setMapInventory(MapInventory);
		database.updateActions(Actions);
		database.updatePlayerInv(Inventory);

		// LOGIC FOR THE LOGS
		if (result.contains("can't")) {
			database.addLog(result);
			database.addLog("");
		} else if (result != "") {
			database.addLog(result);
			database.addLog(description);
			database.addLog("");
		}
		log = database.getLog();
		//
	}
	
	public List<String> getLog()
	{
		return log;
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
		else if(playerx == 2 && playery == 2 && player1.hasAction("litroom") && player1.getRoomNumber() == 2) //change light room description
		{
			descriptionIndex = 1;
		}
		else if(playerx == 0 && playery == 2 && player1.hasAction("opensafe") && player1.getRoomNumber() == 2) //change box room description
		{
			descriptionIndex = 1;
		}
		if(playerx == 1 && playery == 2 && player1.getRoomNumber() == 2 && player1.hasitem("crowbar")) //change hammer room description
		{
			descriptionIndex = 1;
		}
		if(playerx == 0 && playery == 1 && player1.getRoomNumber() == 2 && player1.hasAction("ratused")) //change hammer room description
		{
			descriptionIndex = 1;
		}
	
		
		description = map1.getSpot(playerx, playery).getdescriptionAt(descriptionIndex);
		
		String[] itemChecker = mapInventory.split(" ");


		for (int i = 0; i < itemChecker.length; i++) {
			if (itemChecker[i].length() > 0) {
				if (Character.getNumericValue(itemChecker[i].charAt(0)) == playerx && Character.getNumericValue(itemChecker[i].charAt(1)) == playery
						&& Character.getNumericValue(itemChecker[i].charAt(2)) == player1.getRoomNumber()) {
					description = description + " There is a " + itemChecker[i].substring(3) + " here";
					
				}
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
		String[] command = model.split(move.toLowerCase());
		if(move.length() <= 0)
		{
			return "Type Something First";
		}
		
		if(model.validate(model.split(move), player1.getPlayerx(), player1.getPlayery(), map1.getSpot(player1.getPlayerx(), player1.getPlayery()), player1)) {
			//if there is nothing after "go" (or synonym) in the move
			if (move.replace("go", "").contentEquals("") || move.replace("move", "").contentEquals(" ") || move.replace("walk", "").contentEquals(" ")) {
				return "You can't do that";
			}

			return model.getOutput(model.split(move), player1);
		}
		else {
			if( (command[0].contains("go") || command[0].contains("move") || command[0].contains("walk")) && command.length > 1)
			{
				if(command[1].contains("north") && player1.getPlayerx() == 1 && player1.getPlayery() == 2)
				{
					return "The door is locked, you cannot enter.";
				}
				else if (!command[1].contentEquals("north") && !command[1].contentEquals("south") && !command[1].contentEquals("east") && !command[1].contentEquals("west")) {
					return "Use the format: move north/south/east/west";
				}
				else
				{
					return "Ouch, you hit a wall!";
				}
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
