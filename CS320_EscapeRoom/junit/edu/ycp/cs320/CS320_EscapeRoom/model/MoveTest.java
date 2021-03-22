package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.GuessingGame;

public class MoveTest {
	private Move model;
	private GameController controller;
	
	@Before
	public void setUp() {
		model = new Move();
		controller = new GameController();
		
		model.validate(model.split("go east"));
		
		controller.setModel(model);
	}
	
	@Test
	public void testGoEastValidate() {
		assertTrue(model.validate(model.split("go east")));
		assertFalse(model.validate(model.split("east")));
		
	}
	
	@Test
	public void testOneWordInvalid(){
	assertFalse(model.validate(model.split("east")));
	}
	

}
