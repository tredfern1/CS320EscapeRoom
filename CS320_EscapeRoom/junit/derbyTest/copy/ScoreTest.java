package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.DatabaseLogic;
import model.Spot;

public class ScoreTest {
	
	DatabaseLogic db;
	
	@Before
	public void setUp() {
		db = new DatabaseLogic();
		db.setHighScore(0);
	}
	
	@Test
	public void testGetScore() {
		//System.out.println("score is: " + db.getHighScore());
		assertTrue(db.getHighScore() == 0);
	}
	
	@Test
	public void testSetScore() {
		db.setHighScore(0);
		assertTrue(db.getHighScore() == 0);
		
		db.setHighScore(5000);
		assertTrue(db.getHighScore() == 5000);
		
		db.setHighScore(0);
	}
	
}
