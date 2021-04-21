package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Spot;

public class RoomTest {
	
	private Spot s;
	//private ArrayList<String> descriptions;
	//private ArrayList<String> items;
	
	@Before
	public void setup() {
		
		
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