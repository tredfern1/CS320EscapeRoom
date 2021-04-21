package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Coordinate;
import model.Spot;
import persist.DerbyDatabase;

public class MapInventoryTest {
	
	DerbyDatabase database = new DerbyDatabase();
	String mapInventory = "011hammer 111cactus";

	
	@Before
	public void setup() {
		DerbyDatabase database = new DerbyDatabase();
		database.setMapInventory(mapInventory);
		
	}
	

	
	@Test
	public void testGetInventory() {
		assertTrue(database.getMapInventory().contentEquals("011hammer 111cactus "));
		
	}
	
	
	@Test
	public void testSetInventory() {
		
		database.setMapInventory(mapInventory.substring(0,10));
		assertTrue(database.getMapInventory().contentEquals("011hammer "));
		
	}
	
}
