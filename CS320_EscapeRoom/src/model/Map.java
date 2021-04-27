package model;

import java.util.ArrayList;
import java.util.List;

public class Map {
	
	Spot[][] spots;

	public Map(int room, List<String> newMapInventory) {
		// Initialize Map Spots
		spots = new Spot[3][3]; 
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				spots[i][j] = new Spot();
			}
		}
		//Set descriptions
		if(room == 1)
		{
			//Description and item setters before actions #0
			spots[0][0].setdescription("Seems like a dark an empty corner.");
			spots[0][1].setdescription("There's a heavy *hammer on the floor. Wonder who left that there?"); 
			spots[0][2].setdescription("You see a crate lying on the ground. Looks poorly made.");
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
		{	//set first descriptions/items of the room
			spots[0][0].setdescription("There's nothing but a bunch of cobwebs here.");
			spots[0][1].setdescription("There's a small hole at the base of the wall. Too small for your hand to fit in, but maybe something smaller?"); 
			spots[0][2].setdescription("There is a safe with a keypad");
			spots[0][2].addItem("redkey"); 
			
			spots[1][0].setdescription("The door south of you goes back to room 1");
			spots[1][1].setdescription("You are in the center of a dark and dirty room.");
			spots[1][2].setdescription("There's a crowbar leaned against the wall");
			//spots[1][2].addItem("crowbar");
			
			spots[2][0].setdescription("How shocking!? More cobwebs.");
			spots[2][1].setdescription("There is a lit torch mounted on the wall"); 
			//spots[2][1].addItem("torch");
			
			spots[2][2].setdescription("This corner is too dark to see anything. Perhaps some light would help?");
			
			//set second descriptions of the room
			spots[1][2].setdescription("This is the spot where the crowbar used to be");
			
			spots[2][2].setdescription("You can now see a code on the wall. 6851");
			
			spots[0][2].setdescription("The safe is unlocked");
			
			spots[0][1].setdescription("There's the hole where the rat brought you gold from");
		}
		if (room == 3) {
			//starting descriptions
			spots[0][0].setdescription("The southwestern corner of the third room. There is a bookshelf here, but nothing stands out at the moment.");
			spots[0][1].setdescription("The western side of the third room. There is nothing here");
			spots[0][2].setdescription("The northwestern corner of the third room. There is nothing here");
			
			spots[1][0].setdescription("You entered room 3. You are on the southern side of the room. You can south to return to room 2.");
			spots[1][1].setdescription("The center of the third room. There is a grand piano here. On the sheet music stand there appears to be a multiple choice question. It reads: "
					+ 					"<br> What is Isaac Asimov's first Law of Robotics? "
					+ 					"<br> (A) 'A robot must obey orders given it by human beings except where such orders would conflict with the First Law."  
					+					"<br> (B) 'A robot may not harm humanity, or, by inaction, allow humanity to come to harm.' "
					+ 					"<br> (C) 'A robot may not injure a human being or, through inaction, allow a human being to come to harm.' "
					+ 					"<br> (D) 'A robot must protect its own existence as long as such protection does not conflict with the First or Second Law.' ");
			spots[1][2].setdescription("The northern side of the third room. There is a locked door here.");
			
			spots[2][0].setdescription("The southeastern corner of the third room. There is nothing here");
			spots[2][1].setdescription("The eastern side of the third room. There is nothing here");
			spots[2][2].setdescription("The northeastern side of the third room. There is nothing here");
			
			//descriptions after changes are made
			spots[0][0].setdescription("The southwestern corner of the third room. One book stands out to you; 'I, Robot' by Isaac Asimov");
			spots[0][0].setdescription("The southwestern corner of the third room. There is a bookshelf here. The rest of the books don't seem helpful, though.");
			
			spots[1][1].setdescription("The center of the third room. There is a grand piano here. You have already solved this puzzle. It appears the last door has unlocked, also.");
		}
		
		//SET THE ITEMS IN THE MAP BASED ON THE ARRAY OF MAP ITEMS
		for(int i = 0; i < newMapInventory.size(); i++) //goes through all items in the map and adds them based on the string
		{
			if(!newMapInventory.get(i).isEmpty())
			{
				int x = Character.getNumericValue(newMapInventory.get(i).charAt(0));
				int y = Character.getNumericValue(newMapInventory.get(i).charAt(1));
				int itemRoom = Character.getNumericValue(newMapInventory.get(i).charAt(2));
				String item = newMapInventory.get(i).substring(3);
				
				if(itemRoom == room)
				{
					spots[x][y].addItem(item);
				}
			}
		}
		
	}
	
	public Map() {
		this.spots[0][0].setdescription("This is the first room");
	}
	
	Map (Spot[][] s) {
		this.spots = s;
	}	
	
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
	
	public String getSpotDescription(int x, int y)
	{
		String description;
		description = spots[x][y].lookAround(0);
		
		return description;
	}
	
}
