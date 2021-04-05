package edu.ycp.cs320.CS320_EscapeRoom.model;

public class Map {
	
	Spot[][] spots;

	public Map(int room) {
		// Initialize Map Spots
		spots = new Spot[3][3];
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				spots[i][j] = new Spot();
			}
		}
		if(room == 1)
		{
		//Description and item setters before actions #0
		spots[0][0].setdescription("Seems like a dark an empty corner.");
		spots[0][1].setdescription("There's a heavy *hammer on the floor. Wonder who left that there?"); 
		spots[0][1].addItem("hammer"); //adds item
		spots[0][2].setdescription("You see a crate lying on the ground. Looks poorly made.");
		spots[0][2].addItem("redkey"); 
		spots[1][0].setdescription("There's a window with bars on it. No way you could get through this.");
		spots[1][1].setdescription("You are in the center of a dark and dirty room.");
		spots[1][2].setdescription("There's a red door with a keyhole, it's locked.");
		spots[2][0].setdescription("In this corner of the room you see a rat, ew!");
		spots[2][1].setdescription("Yeah there's nothing here but a sense of dread."); 
		spots[2][2].setdescription("Yikes! a corner with some nasty rats!");
		
		//Description setters after actions #1
		spots[0][1].setdescription("There's a dusty spot where the hammer was."); 
		spots[0][2].setdescription("The crate is broken and lying on the ground. Looks like a little *redkey fell out.");
		spots[1][2].setdescription("There's a red door with a keyhole, it's been unlocked!");
		//Description setters after actions #2
		spots[0][2].setdescription("The crate is broken and lying on the ground. This is where you found the key.");
		}
		if(room == 2)
		{
			spots[0][0].setdescription("There's nothing but a bunch of cobwebs here.");
			spots[0][1].setdescription("There's a small hole at the bass of the wall. Too small for your hand to fit in, but maybe something smaller?"); 
			spots[0][2].setdescription("There is a safe with a keypad");
			spots[1][0].setdescription("This door goes back to room 1");
			spots[1][1].setdescription("You are in the center of a dark and dirty room.");
			spots[1][2].setdescription("There's a crowbar leaned against the wall");
			spots[1][2].addItem("crowbar");
			
			spots[2][0].setdescription("How shocking!? More cobwebs.");
			spots[2][1].setdescription("There is a lit torch mounted on the wall"); 
			spots[2][1].addItem("torch");
			
			spots[2][2].setdescription("This corner is too dark to see anything. Perhaps some light would help?");
		}
		
	}
	
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
	
	

}
