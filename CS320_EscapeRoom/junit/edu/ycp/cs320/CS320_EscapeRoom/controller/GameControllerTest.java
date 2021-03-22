package edu.ycp.cs320.CS320_EscapeRoom.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GuessingGameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.GuessingGame;
import edu.ycp.cs320.CS320_EscapeRoom.model.Move;

public class GameControllerTest {
	private Move model;
	private GameController controller;
	
	@Before
	public void setUp() {
		model = new Move();
		controller = new GameController();
		
		
		controller.setModel(model);
	}
	
	@Test
	public void testGoEast() {
		assertTrue(controller.getOuput("go east").contentEquals("you went east"));
		
	}
	
	@Test
	public void testGoNorth() {
		assertTrue(controller.getOuput("go north").contentEquals("you went north"));
		
	}
	
	@Test
	public void testOneWordInvalid() {
		assertTrue(controller.getOuput("go").contentEquals("invalid move"));
		
	}

	@Test
	public void testValidButIneffective() {
		assertTrue(controller.getOuput("go down").contentEquals("your move does nothing"));
		
	}
	

	
}
