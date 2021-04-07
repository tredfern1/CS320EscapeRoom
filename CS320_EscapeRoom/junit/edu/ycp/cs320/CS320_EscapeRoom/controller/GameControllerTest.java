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
	//private Map m;
	private String inv;
	private Player p;
	private String Actions;
	private String mapInv;
	private int room;
	
	@Before
	public void setUp() {
		
		model = new Move();
		inv = "";
		p = new Player();
		p.updatePlayerCoor(1, 1);
		Actions = "";
		mapInv = "";
		room = 1;
		controller = new GameController(p.getPlayerx(), p.getPlayery(), inv, Actions, mapInv, room);
		//m = new Map();
		
		controller.setModel(model);
	}
	
	@Test
	public void testMovement() {
		
		//starting from (1,1), should be able to move any direction (w/ all words)
		assertTrue(controller.getOutput("go east").contentEquals("you went east"));
		assertTrue(controller.getOutput("go north").contentEquals("you went north"));
		assertTrue(controller.getOutput("go west").contentEquals("you went west"));
		assertTrue(controller.getOutput("go south").contentEquals("you went south"));
		
		assertTrue(controller.getOutput("move east").contentEquals("you went east"));
		assertTrue(controller.getOutput("move north").contentEquals("you went north"));
		assertTrue(controller.getOutput("move west").contentEquals("you went west"));
		assertTrue(controller.getOutput("move south").contentEquals("you went south"));
		
		assertTrue(controller.getOutput("walk east").contentEquals("you went east"));
		assertTrue(controller.getOutput("walk north").contentEquals("you went north"));
		assertTrue(controller.getOutput("walk west").contentEquals("you went west"));
		assertTrue(controller.getOutput("walk south").contentEquals("you went south"));
		
		//starting from (0,0), should be able to move N and E but not S or W (w/ all words)
		controller.getPlayer().updatePlayerCoor(0, 0);
		
		assertTrue(controller.getOutput("go east").contentEquals("you went east"));
		assertTrue(controller.getOutput("go north").contentEquals("you went north"));
		assertFalse(controller.getOutput("go west").contentEquals("you went west"));
		assertFalse(controller.getOutput("go south").contentEquals("you went south"));
		
		assertTrue(controller.getOutput("move east").contentEquals("you went east"));
		assertTrue(controller.getOutput("move north").contentEquals("you went north"));
		assertFalse(controller.getOutput("move west").contentEquals("you went west"));
		assertFalse(controller.getOutput("move south").contentEquals("you went south"));
		
		assertTrue(controller.getOutput("walk east").contentEquals("you went east"));
		assertTrue(controller.getOutput("walk north").contentEquals("you went north"));
		assertFalse(controller.getOutput("walk west").contentEquals("you went west"));
		assertFalse(controller.getOutput("walk south").contentEquals("you went south"));
	}
	
	
	@Test
	public void testOneWordInvalid() {
		//System.out.println("" + controller.getOutput("go") );
		assertTrue(controller.getOutput("go").contains("cannot") );
		assertTrue(controller.getOutput("move").contains("cannot") );
		assertTrue(controller.getOutput("Walk").contains("cannot") );
	}

	@Test
	public void testValidButIneffective() {
		
		//controller.getPlayer()
		//System.out.println("" + controller.getOutput("go down") );
		assertTrue(controller.getOutput("go down").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("move left").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("walk right").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("go up").contains("Make sure your command follows the format: move <direction>"));
	}
	

	
}
