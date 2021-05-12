package controllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import controller.GameController;
import model.*;

public class GameControllerTest {
	

	private Game model;
	private GameController controller;

	
	@Before
	public void setUp() {
<<<<<<< Updated upstream
		model = new Game();
		model.restartGame();
		controller = new GameController();
=======
<<<<<<< HEAD
		
		model = new Move();
		inv = "";
		p = new Player();
		p.updatePlayerCoor(1, 1);
		actions = "";
		mapInv = "";
		room = 1;
		controller = new Game();
=======
		model = new Game();
		model.restartGame();
		controller = new GameController();
>>>>>>> main
>>>>>>> Stashed changes
		controller.setModel(model);
		
	}
	
	@Test
<<<<<<< Updated upstream
	public void TestGetScore() {
		assertTrue(controller.getScore() == 25);
	}
	
	@Test
	public void TestGetHighScore() {
		assertTrue(controller.getHighScore() == 25);
	}
	
	@Test
	public void TestGetWinGameNotTrue() {
		assertTrue(controller.getWinGame() == 0);
	}
=======
<<<<<<< HEAD
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
		
		result = controller.getOutput("pickup hammer");
		
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
		
		controller = new Game(p.getPlayerx(), p.getPlayery(), inv, actions, mapInv, room);
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
=======
	public void TestGetScore() {
		assertTrue(controller.getScore() == 25);
	}
	
	@Test
	public void TestGetHighScore() {
		assertTrue(controller.getHighScore() == 25);
>>>>>>> main
	}
	
	@Test
	public void TestGetWinGameNotTrue() {
		assertTrue(controller.getWinGame() == 0);
	}
>>>>>>> Stashed changes
}