package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

public class MoveTest {
	private Move m;
	private Game controller;
	
	@Before
	public void setUp() {
		m = new Move();
		
		String inv = "";
		Player p = new Player();
		String Actions = "";
		String mapInv = "";
		int room = 1;
		controller = new Game();
		
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
	public void testMovementSynonyms1() {
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//tests synonyms for the same command
		controller.getPlayer().updatePlayerCoor(1, 1);
		assertTrue(m.validate(m.split("go east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertTrue(m.validate(m.split("move east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertTrue(m.validate(m.split("walk east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testMovementSynonyms2() {
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//tests synonyms for the same command
		controller.getPlayer().updatePlayerCoor(1, 1);
		assertTrue(m.validate(m.split("move east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testMovementSynonyms3() {
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//tests synonyms for the same command
		controller.getPlayer().updatePlayerCoor(1, 1);
		assertTrue(m.validate(m.split("go east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testOneWordInvalid(){
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		assertFalse(m.validate(m.split("east"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		assertFalse(m.validate(m.split("go"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testTake() {
		
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
	
	@Test
	public void testTakeSynonyms1() {
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//the player should be able to take an item from the spot they are on
		tempSpot.addItem("hammer");
		assertTrue(m.validate(m.split("grab hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		
		//player should not be able to take an item they already have
		tempPlayer.addItemToInventory("hammer");
		assertFalse(m.validate(m.split("grab hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}
	
	@Test
	public void testTakeSynonyms2() {
		
		Spot tempSpot = new Spot();
		Player tempPlayer = new Player();
		
		//the player should be able to take an item from the spot they are on
		tempSpot.addItem("hammer");
		assertTrue(m.validate(m.split("pickup hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
		
		//player should not be able to take an item they already have
		tempPlayer.addItemToInventory("hammer");
		assertFalse(m.validate(m.split("pickup hammer"), controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery(), tempSpot, tempPlayer));
	}

}
