package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.*;

public class MoveTest {
	private Move m;
	private GameController controller;
	
	@Before
	public void setUp() {
		m = new Move();
		
		String inv = "";
		Player p = new Player();
		String Actions = "";
		String mapInv = "";
		int room = 1;
		controller = new GameController(p.getPlayerx(), p.getPlayery(), inv, Actions, mapInv, room);
		
		//m.validate(m.split("go east"));
		
		controller.setModel(m);
	}
	
	@Test
	public void testMovement() {
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//should be able to move any direction from (1,1) (the center of a room)
		controller.getPlayer().updatePlayerCoor(1, 1);
		assertTrue(m.validate(m.split("go east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		
		//should not be able to move south from (0,0), will hit a wall
		controller.getPlayer().updatePlayerCoor(0, 0);
		assertFalse(m.validate(m.split("go south"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		
		
	}
	
	@Test
	public void testAlternateMovementSynonyms() {
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//tests synonyms for the same command
		controller.getPlayer().updatePlayerCoor(1, 1);
		assertTrue(m.validate(m.split("go east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertTrue(m.validate(m.split("move east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertTrue(m.validate(m.split("walk east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testOneWordInvalid(){
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		assertFalse(m.validate(m.split("east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertFalse(m.validate(m.split("go"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testTakeAndSynonyms() {
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		
		
		//the player should be able to take an item from the spot they are on
		tempSpot.addItem("hammer");
		assertTrue(m.validate(m.split("take hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertTrue(m.validate(m.split("grab hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		
		//player should not be able to take an item they already have
		tempPlayer.addItemToInventory("hammer");
		assertFalse(m.validate(m.split("take hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}

}
