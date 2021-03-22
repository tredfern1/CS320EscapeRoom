package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpotTest {
	
	private Spot s;
	
	@Before
	public void setup() {
		
		Coordinate c = new Coordinate();
		c.setX(0);
		c.setY(1);
		
		String[] items = { "book", "key" };
		String[] descriptions = { "a test spot", "description 2" };
		boolean start = false;
		boolean wall = false;
		boolean win = false;
		boolean door = false;
		
		s = new Spot(c, items, descriptions, start, wall, win, door);
		
	}
	
	@Test
	public void testCoordinate() {
		assertEquals(s.getSpotLocation().getX(), 0);
		assertEquals(s.getSpotLocation().getY(), 1);
	}
	
	@Test
	public void testItems() {
		assertTrue(s.getItem(0).contains("book"));
		assertTrue(s.getItem(1).contains("key"));
	}
	
	@Test
	public void testDescriptions() {
		assertTrue(s.lookAround(0).contains("a test spot"));
		assertTrue(s.lookAround(1).contains("description 2"));
	}
	
}
