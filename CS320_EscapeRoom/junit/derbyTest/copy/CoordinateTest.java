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
	public void testGety() {
		assertTrue(database.getCoordinateY() == 5);
	}
	
	@Test
	public void testSetX() {
		coord.setX(1);
		database.setCoordinate(coord);
		assertTrue(database.getCoordinateX() == 1);
	}
	
	@Test
	public void testSetY() {
		coord.setY(1);
		database.setCoordinate(coord);
		assertTrue(database.getCoordinateY() == 1);
	}
	
	@Test
	public void testBothx() {
		coord.setCoordinate(7,7);
		database.setCoordinate(coord);
		assertTrue(database.getCoordinateY() == 7);
	}
	
	@Test
	public void testBothY() {
		coord.setCoordinate(7,7);
		database.setCoordinate(coord);
		assertTrue(database.getCoordinateY() == 7);
	}
	
}
