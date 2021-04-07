package edu.ycp.cs320.CS320_EscapeRoom.model;

public class Logic {
	
	public Logic()
	{
		//create logic
	}
	
	//called when adding an item to the player's inventory
	public String LogicPickup(String move, String result, String Inventory) {
		if(result.contains("You picked up a")) //add item to inventory
		{
			String[] input = move.split(" ");
			Inventory = Inventory + input[1] + " ";      
		}
		
		if(result.contains("You dropped the")) //add item to inventory
		{
			String[] input = move.split(" ");
			Inventory = Inventory.replace(input[1], "");      
		}
		return Inventory;//add to string of items
	}
	
	//called when you pick up something, removes that item from the map inventory
	public String LogicPickupMapInventory(String move, String result, String MapInventory, Player player1) {
		if(result.contains("You picked up a")) //add item to inventory
		{
			String[] input = move.split(" ");
			if(MapInventory.contains(input[1]))
			{
				String replaceString = String.valueOf(player1.getPlayerx()) + String.valueOf(player1.getPlayery()) + String.valueOf(player1.getRoomNumber() + input[1]);
				MapInventory = MapInventory.replace(replaceString, "");
			}

		}
		if(result.contains("You dropped the")) {
			
			String[] input = move.split(" ");
			
			MapInventory = MapInventory + String.valueOf(player1.getPlayerx()) + String.valueOf(player1.getPlayery()) + String.valueOf(player1.getRoomNumber()) + input[1]  ;
			
			
		}
		return MapInventory;//add to string of items
	}
		
	//called when adding an action to the string of actions
	public String LogicActions(String move, String result, String Inventory, String Actions)
	{
		if(result.contains("You used the")) //check for uses of items
		{
		
			String[] input = move.split(" ");

			if(input[1].contains("hammer"))
			{              
				Actions = Actions + "boxBreak" + " "; 
				//add respectable tags to actions(remember the space)
			}
			if(input[1].contains("redkey"))
			{              
				Actions = Actions + "unlock1" + " "; 
				//add respectable tags to actions(remember the space)
			}
			if(input[1].contains("torch"))
			{              
				Actions = Actions + "litroom" + " "; 
				//add respectable tags to actions(remember the space)
			}
			if(input[1].contains("rat"))
			{              
				Actions = Actions + "ratused" + " "; 
				//add respectable tags to actions(remember the space)
			}
		}
		if(result.contains("you've unlocked the")) {
			Actions = Actions + "opensafe" + " "; 
		}
		return Actions;//add to string of items
	}
}
