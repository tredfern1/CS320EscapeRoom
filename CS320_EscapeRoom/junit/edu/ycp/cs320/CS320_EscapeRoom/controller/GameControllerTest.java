package edu.ycp.cs320.CS320_EscapeRoom.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.CS320_EscapeRoom.controller.GuessingGameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.*;

public class GameControllerTest {
	private Move model;
	private GameController controller;
	
	@Before
	public void setUp() {
		
		model = new Move();
		String inv = "";
		Player p = new Player();
		String Actions = "";
		String mapInv = "";
		int room = 1;
		controller = new GameController(p.getPlayerx(), p.getPlayery(), inv, Actions, mapInv,  room);
		
		
		controller.setModel(model);
	}
	
	@Test
	public void testGoEast() {
		assertTrue(controller.getOutput("go east").contentEquals("you went east"));
		
	}
	
	@Test
	public void testGoNorth() {
		assertTrue(controller.getOutput("go north").contentEquals("you went north"));
		
	}
	
	@Test
	public void testOneWordInvalid() {
		System.out.println("" + controller.getOutput("go") );
		assertTrue(controller.getOutput("go").contains("cannot") );
		
	}

	@Test
	public void testValidButIneffective() {
		
		//controller.getPlayer()
		
		assertTrue(controller.getOutput("go down").contentEquals("your move does nothing"));
		
	}
	

	
}
