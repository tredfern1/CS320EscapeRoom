package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Coordinate;
import model.Spot;
import persist.DerbyDatabase;

public class CoordinateTest {
	
	DerbyDatabase database = new DerbyDatabase();
	Coordinate coord = new Coordinate();

	
	@Before
	public void setup() {
		DerbyDatabase database = new DerbyDatabase();
		Coordinate coord = new Coordinate();
		coord.setCoordinate(0, 5);
		database.setCoordinate(coord);
		
	}
	

	
	@Test
	public void testGetX() {
		assertTrue(database.getCoordinateX() == 0);
		
	}
	
	
	@Test
	public void testGetY() {
		assertTrue(database.getCoordinateY() == 5);
		
		
	}
	
}
