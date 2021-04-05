package edu.ycp.cs320.CS320_EscapeRoom.model;

public class Logic {
	
	public Logic()
	{
		//create logic
	}
	
	public String LogicPickup(String move, String result, String Inventory, String Actions) {
		if(result.contains("You picked up a")) //add item to inventory
		{
			String[] input = move.split(" ");
			Inventory = Inventory + input[1] + " ";      
		}
		return Inventory;//add to string of items
	}
		
		
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
		}
		return Actions;//add to string of items
}
}
