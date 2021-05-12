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

		model = new Game();
		model.restartGame();
		controller = new GameController();

		

		String inv = "";
		Player p = new Player();
		p.updatePlayerCoor(1, 1);
		String actions = "";
		 String mapInv = "";
		int room = 1;
		Game model;

		model = new Game();
		model.restartGame();
		GameController controller = new GameController();

		controller.setModel(model);
		
	}
	


	@Test
	public void TestGetHighScore() {
		assertTrue(controller.getHighScore() == 25);

	}
	
	@Test
	public void TestGetWinGameNotTrue() {
		assertTrue(controller.getWinGame() == 0);
	}

}