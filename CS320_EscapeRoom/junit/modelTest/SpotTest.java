package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Spot;

public class SpotTest {
	
	private Spot s;
	//private ArrayList<String> descriptions;
	//private ArrayList<String> items;
	
	@Before
	public void setup() {
		
		s = new Spot();
		
	}
	
	@Test
	public void testLookAround() {
		
	}
	
	@Test
	public void testAddAndGetItem() {
		
		s.addItem("book");
		s.addItem("key");
		
		assertTrue(s.getItem(0).contains("book"));
		assertTrue(s.getItem(1).contains("key"));
		
		assertFalse(s.getItem(0).contains("dog"));
	}
	
	@Test
	public void testAddAndGetItem2() {
		
		s.addItem("ice");
		s.addItem("cream");
		
		assertTrue(s.getItem(0).contains("ice"));
		assertTrue(s.getItem(1).contains("cream"));
		
		assertFalse(s.getItem(0).contains("cat"));
	}
	@Test
	public void testAddAndGetItem3() {
		
		s.addItem("cat");
		s.addItem("keycard");
		
		assertTrue(s.getItem(0).contains("cat"));
		assertTrue(s.getItem(1).contains("keycard"));
	}
	
	
	@Test
	public void testHasItem() {
		
		s.addItem("cactus");
		assertTrue(s.hasItem("cactus"));
		
		assertFalse(s.hasItem("tree"));
		
	}
	
	
	@Test
	public void testGetAndSetDescription() {
		//assertTrue(s.lookAround(0).contains("a test spot"));
		//assertTrue(s.lookAround(1).contains("description 2"));
		
		s.setdescription("description1");
		
		assertTrue(s.getdescriptionAt(0).contains("description1"));
		
		assertFalse(s.getdescriptionAt(0).contains("description2"));
		
	}
	
}
