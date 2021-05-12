package controllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

public class GameTest {
	
	private Move model;
	private Game controller;
	//private Map m;
	private String inv;
	private Player p;
	private String actions;
	private String mapInv;
	private String move;
	private String result;
	private String inventory;
	private int room;
	
	@Before
	public void setUp() {
		
		model = new Move();
		inv = "";
		p = new Player();
		p.updatePlayerCoor(1, 1);
		actions = "";
		mapInv = "";
		room = 1;
		controller = new Game();
		controller.setModel(model);
		move = "";
		result = "";
		inventory = "";
		controller.setModel(model);
		controller.restartGame();
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

	/*
	@Test
	public void testValidButIneffective() {
		
		//controller.getPlayer()
		//System.out.println("" + controller.getOutput("go down") );
		assertTrue(controller.getOutput("go down").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("move left").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("walk right").contains("Make sure your command follows the format: move <direction>"));
		assertTrue(controller.getOutput("go up").contains("Make sure your command follows the format: move <direction>"));
	}
	*/
	
	@Test
	public void testGetPickupLogic() {
		
		//test picking up the hammer
		p.updatePlayerCoor(1, 1);
		p.setRoomNumber(1);
		
		move = "pickup hammer";
		inv = "";
		//update the controller's inventory for this test
		mapInv = "111hammer";
		
		controller = new Game();
		controller.setModel(model);
		
		result = "You picked up a hammer";
		
		assertTrue(controller.getPickupLogic(move, result, inv).contains("hammer"));
		
		//test synonyms
		move = "take hammer";
		assertTrue(controller.getPickupLogic(move, result, inv).contains("hammer"));
		
		move = "grab hammer";
		assertTrue(controller.getPickupLogic(move, result, inv).contains("hammer"));
		
		//test picking up an item on another spot should return null
		mapInv = "221hammer";
		controller = new Game();
		controller.setModel(model);
		
		result = controller.getOutput("pickup hammer");
		
		assertTrue(controller.getPickupLogic(move, result, inv).equals(""));
		
		//an invalid 'move' should return null
		move = "";
		mapInv = "111hammer";
		
		controller = new Game();
		controller.setModel(model);
		
		assertEquals(controller.getPickupLogic(move, result, inv), "");
		
	}
	
	@Test
	public void testGetMapPickupLogic() {
		//test picking up the hammer
		p.updatePlayerCoor(1, 1);
		p.setRoomNumber(1);
				
		move = "pickup hammer";
		inv = "";
		//update the controller's inventory for this test
		mapInv = "111hammer";
		
		controller = new Game();
		controller.setModel(model);
		
		result = controller.getOutput("pickup hammer");
		//System.out.println(result);
		
		//returns the map inventory after the item was taken. For an inventory with 1 item, should be null after removing the item
		assertEquals(controller.getMapPickupLogic(move, result, inv, controller.getPlayer()), "");
		
		move = "pickup cheese";
		result = controller.getOutput(move);
		System.out.println(result);
		
		assertEquals(controller.getMapPickupLogic(move, result, inv, controller.getPlayer()), "");
	}
	
	@Test
	public void testGetSpotDescription() {
		controller.restartGame();
		String desc = controller.getSpotDescription(1, 1, "");
		System.out.println("TESTING the get spot description test : " + desc);
		assertTrue(desc.contains("You are in the center of a dark and dirty room. The floor is covered with dust and dirt, it looks like this place hasn't been cleaned in months. You can see a strange red door to your north."));
	}
	
	@Test
	public void testGetScore() {
		int score = controller.getScore();
		assertTrue(score == 25);
	}
	
	@Test
	public void testGetActionsLogic() {
		Player player1 = new Player();
		player1.updatePlayerCoor(1, 2);
		player1.setRoomNumber(1);
		String result = controller.getActionsLogic("use redkey", "You used the redkey", "redkey ", "", player1);
		assertTrue(result.contains("unlock1"));
	}
	
}
