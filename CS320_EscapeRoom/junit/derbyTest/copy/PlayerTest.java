package derbyTest.copy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.GameController;
import model.*;

public class PlayerTest {
	private Player player;
	
	@Before
	public void setUp() {
		player = new Player();
		player.updatePlayerCoor(5, 6);
	}
	
	@Test
	public void testGetPlayerX() {
		assertTrue(player.getPlayerx() == 5);
	}
	
	@Test
	public void testGetPlayerY() {
		assertTrue(player.getPlayery() == 6);

	}
	
	@Test
	public void testUpdatePlayerCoord() {
		player.updatePlayerCoor(0, 1);
		assertTrue(player.getPlayerx() == 0);
		assertTrue(player.getPlayery() == 1);
	}
	
	@Test
	public void testInventory() {
		
		player.addItemToInventory("pen");
		player.addItemToInventory("pineapple");
		
		assertTrue(player.hasitem("pen"));
		assertTrue(player.hasitem("pineapple"));
		
		assertFalse(player.hasitem("apple"));
		
		//TODO: add tests for removing items
	}
	
	@Test
	public void testActions() {
		
		player.addActiontoActions("Smashed_The_Crate");
		player.addActiontoActions("openedDoor");
		
		assertTrue(player.Actions().contains("Smashed_The_Crate"));
		assertTrue(player.Actions().contains("openedDoor"));
		
		assertFalse(player.Actions().contains("Took-A-Nap"));
		
	}
	
	@Test
	public void roomNumberTest() {
		player.setRoomNumber(1);
		assertTrue(player.getRoomNumber() == 1);
		
		assertFalse(player.getRoomNumber() == 2);
		
	}
	
}
