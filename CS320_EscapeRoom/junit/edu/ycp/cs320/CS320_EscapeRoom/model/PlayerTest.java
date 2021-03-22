package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.GuessingGame;

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
	

}
