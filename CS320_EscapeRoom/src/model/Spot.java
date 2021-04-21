package model;

import java.util.ArrayList;

public class Spot {
	
	public ArrayList<String> descriptions = new ArrayList<String>();
	public ArrayList<String> items = new ArrayList<String>();
	
	
	public Spot (){
		descriptions = new ArrayList<String>(); //init all variables
		items = new ArrayList<String>();
	}
	
	/*
	 * Returns a description based on the state of the spot
	 * Default state should be 0
	 */
	public String lookAround(int state) {
		return descriptions.get(0);
	}
	
	
	//returns the item in the provided index in the array of items in the spot
	public String getItem(int index) {
		return items.get(index);
	}
	
	public Boolean hasItem(String item) {
		if(items.contains(item))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//TODO: will remove an item from the spot
	public void removeItem(String itemName) {
		
	}
	
	//adds item to spot(for map class)
	public void addItem(String item) {
		items.add(item);
	}

	public void setdescription(String line)
	{
		descriptions.add(line);
	}
	
	public String getdescriptionAt(int index)
	{
		return descriptions.get(index);
	}
	
	
	
}