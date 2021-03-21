package edu.ycp.cs320.CS320_EscapeRoom.model;

public class Map {
	
	Spot[][] spots;
	
	Map (Spot[][] s) {
		this.spots = s;
	}
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
	
	/*
	//generates the particular map for our game
	public Map generateMap() {
		Map m;
		Spot[][] s;
		
		for (int x = 0; x <= 13; x++) {
			for (int y = 0; y <= 9; y++) {
				
				//creates the walls 
				if (x == 0 || x == 13) {
					
				}
				
				//creates the doors
				
				
				//creates spots in the center room (and start spot)
				
				//creates spots in the right room
				
				//creates spots in the left room
				
				//creates spots in the bottom room
				
				//creates win spot
			}
		}
		
		
		return m;
	}
	*/
}
