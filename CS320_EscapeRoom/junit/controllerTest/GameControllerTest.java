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
		controller.setModel(model);
		
	}
	
	@Test
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
}