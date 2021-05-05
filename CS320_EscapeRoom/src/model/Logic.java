package model;

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
	public String LogicActions(String move, String result, String Inventory, String Actions, Player player1)
	{
		//check if the player has seen the question in (1,1), room 3
		if (player1.getRoomNumber() == 3 && player1.getPlayerx() == 1 && player1.getPlayery() == 1 && Actions.contains("knowsQuestion") == false) {
			Actions = Actions + "knowsQuestion" + " ";
			//System.out.println("Player read the question");
		}
		if(result.contains("You used the")) //check for uses of items
		{
		
			String[] input = move.split(" ");

			if(input[1].contains("hammer"))
			{              
				Actions = Actions + "boxBreak" + " "; 
				//add respectable tags to actions(remember the space)
			}
			if(input[1].contains("bluekey"))
			{              
				Actions = Actions + "unlock2" + " "; 
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
			if(input[1].contains("lever"))
			{              
				Actions = Actions + "lever" + " "; 
				//add respectable tags to actions(remember the space)
			}
		}
		//check for the correct answer for the piano puzzle (the right answer is C)
		if(result.contains("You play")) {
			String[] in = move.split(" ");
			
			if(in[1].contentEquals("C") || in[1].contentEquals("c")) {
				Actions = Actions + "pianoSolved" + " ";
				System.out.println("solved the piano");
			}
		}
		if(result.contains("you've unlocked the")) {
			Actions = Actions + "opensafe" + " "; 
		}
		return Actions;//add to string of items
	}
}
