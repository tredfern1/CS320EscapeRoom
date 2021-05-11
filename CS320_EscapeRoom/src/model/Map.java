package model;

import java.util.ArrayList;
import java.util.List;

public class Map {
	
	Spot[][] spots;
	String[][] hints;

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
		//initializes the hints (with no hint for empty spots)
		hints = new String[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				hints[i][j] = "There is nothing here";
			}
		}
		
		//Set descriptions
		if(room == 1)
		{
			//Description and item setters before actions #0
			spots[0][0].setdescription("Seems like a dark an empty corner.");
			spots[0][1].setdescription("There's a heavy hammer on the floor. It is extremely worn, but could still be effective."); 
			spots[0][2].setdescription("You see a crate lying on the ground. Looks poorly made. Strangly, there is no opening to the box. When shaken, you can hear something inside calling to you.");
			spots[1][0].setdescription("There's a window with bars on it. No way you could get through this.");
			spots[1][1].setdescription("You are in the center of a dark and dirty room. The floor is covered with dust and dirt, it looks like this place hasn't been cleaned in months. You can see a strange red door to your north.");
			spots[1][2].setdescription("To the north there's a red door with a keyhole, it seems to be locked. The paint on it is a faded blood red, it kinda creeps you out.");
			spots[2][0].setdescription("In this corner of the room you see a small lever on the wall, is it dangerous to use it?");
			spots[2][1].setdescription("Yeah there's nothing here but a sense of dread."); 
			spots[2][2].setdescription("Yikes! a corner with some nasty rats! Although very gross, they are very nutritious.");
			//Description setters after actions #1
			spots[0][1].setdescription("There's a dusty spot where the hammer was. It must have been there for ages."); 
			spots[0][2].setdescription("The crate is broken and lying on the ground in pieces. Between the rubble you can spot a little shiny redkey. No doubt that could be useful.");
			spots[1][2].setdescription("To the north there's a red door with a keyhole, it's been unlocked! Maybe you will get out of here afterall.");
			spots[2][0].setdescription("The lever has been pulled and a tiny hole opens up in the wall. A goldnugget! If you get out of here, maybe you'll be rich!");
			spots[1][0].setdescription("The bars on the window broke away, a bird has flown to the window with a goldkey in his mouth.");
			
			//Description setters after actions #2
			spots[2][0].setdescription("The lever has been pulled and a tiny hole opened up in the wall. There's no more gold here sadly.");
			spots[0][2].setdescription("The crate is broken and lying on the ground. This is where you found the redkey.");
			
			//hints for room 1
			hints[1][1] = "Move around with the command: move north/south/east/west";
			hints[0][1] = "Pick up items with the command: take 'item";
			hints[0][2] = "Maybe there is something in this room that could help you break the crate?";
			hints[2][2] = "They look friendly! Maybe you should take one with you?";
		}
		if(room == 2)
		{	//set first descriptions/items of the room
			spots[0][0].setdescription("There's nothing but a bunch of cobwebs here.");
			spots[0][1].setdescription("There's a small hole at the base of the wall. Too small for your hand to fit in, but maybe something smaller?"); 
			spots[0][2].setdescription("There is a safe with a keypad");
			spots[0][2].addItem("redkey"); 
			
			spots[1][0].setdescription("The door south of you goes back to room 1");
			spots[1][1].setdescription("You are in the center of a dark and dirty room.");
			spots[1][2].setdescription("There's a blue door here, it seems to be locked.");
			//spots[1][2].addItem("crowbar");
			
			spots[2][0].setdescription("How shocking!? More cobwebs.");
			spots[2][1].setdescription("There is a lit torch mounted on the wall"); 
			//spots[2][1].addItem("torch");
			
			spots[2][2].setdescription("This corner is too dark to see anything. Perhaps some light would help?");
			
			//set second descriptions of the room

			
			spots[2][2].setdescription("You can now see a code on the wall. 6851");
			
			spots[0][2].setdescription("The safe is unlocked and you can see a bluekey inside of it.");
			spots[0][2].setdescription("The safe is unlocked");
			
			spots[0][1].setdescription("There's the hole where the rat brought you gold from");
			spots[1][2].setdescription("There's a blue door here, it is now unlocked");
			
			//hints for room 2
			hints[0][2] = "The code is probably hidden somewhere in this room. Or you could get a lucky guess?";
		}
		if (room == 3) {
			//starting descriptions
			spots[0][0].setdescription("You are in the southwestern corner of the third room. There is a bookshelf here, but nothing stands out at the moment.");
			spots[0][1].setdescription("You are on the western side of the third room. There is a bone here. It looks like something has been chewing on it.");
			spots[0][2].setdescription("You are in the northwestern corner of the third room. There is nothing here");
			
			spots[1][0].setdescription("You entered room 3. You are on the southern side of the room. You can south to return to room 2.");
			spots[1][1].setdescription("You are in the center of the third room. There is a grand piano here. On the sheet music stand there appears to be a multiple choice question. It reads: "
					+ 					"<br> What is Isaac Asimov's first Law of Robotics? "
					+ 					"<br> (A) 'A robot must obey orders given it by human beings except where such orders would conflict with the First Law."  
					+					"<br> (B) 'A robot may not harm humanity, or, by inaction, allow humanity to come to harm.' "
					+ 					"<br> (C) 'A robot may not injure a human being or, through inaction, allow a human being to come to harm.' "
					+ 					"<br> (D) 'A robot must protect its own existence as long as such protection does not conflict with the First or Second Law.' ");
			spots[1][2].setdescription("You are on the northern side of the third room. There is a locked door here.");
			
			spots[2][0].setdescription("You are in the southeastern corner of the third room. There is nothing here.");
			spots[2][1].setdescription("There is a mean looking dog here. He is holding a goldbar in is his mouth. It looks like he does not want to drop it.");
			spots[2][2].setdescription("You are in the northeastern side of the third room. There is a broken safe here. It does not look very useful.");
			spots[1][2].setdescription("You are on the northern side of the third room. The final door has unlocked and it appears you are free to leave.");
			
			//descriptions after changes are made
			spots[0][0].setdescription("You are in the southwestern corner of the third room. One book stands out to you; 'I, Robot' by Isaac Asimov");
			spots[0][0].setdescription("You are in the southwestern corner of the third room. There is a bookshelf here. The rest of the books don't seem helpful, though.");
			
			spots[1][1].setdescription("You are in the center of the third room. There is a grand piano here. You have already solved this puzzle. It appears the last door has unlocked, also.");
			
			spots[2][1].setdescription("The dog looks happier, but still does not want to drop the goldbar.");
			spots[2][1].setdescription("The dog has lost interest in the goldbar. You can now pick it up.");
			spots[2][1].setdescription("The dog looks happy. There is no more gold here.");
			
			//hints for room 3
			hints[1][1] = "The answer is likely hidden somewhere in this room. Enter an answer by playing the piano: play [A/B/C/D]. And don't Google it, that's cheating!";
			hints[0][0] = "Come back when you figure out what book you need";
			hints[2][1] = "There is probably a way to get the dog to drop the gold.";
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
	
	public String getHint(int x, int y) {
		return hints[x][y];
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
