package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
	
	int roomNum;
	List<String> items;
	Map m;
	
	@Before
	public void setUp() {
		int roomNum = 1;
		items = new ArrayList();
		m = new Map(roomNum, items);
	}
	
	@Test
	public void testGetSpotDescriptionRoomOne() {
		roomNum = 1;
		m = new Map(roomNum, items);
		
		assertTrue(m.getSpotDescription(0, 0).contains("Seems like a dark an empty corner."));
		assertFalse(m.getSpotDescription(0, 0).contentEquals(""));
		
	}
	
	@Test
	public void testGetSpotDescriptionRoomTwo() {
		roomNum = 2;
		m = new Map(roomNum, items);
		
		assertTrue(m.getSpotDescription(0, 0).contains("There's nothing but a bunch of cobwebs here."));
		assertFalse(m.getSpotDescription(0, 0).contentEquals(""));
		
	}
	
	@Test
	public void testGetSpotDescriptionRoomThree() {
		roomNum = 3;
		m = new Map(roomNum, items);
		
		assertTrue(m.getSpotDescription(0, 0).contains("You are in the southwestern corner of the third room. There is a bookshelf here, but nothing stands out at the moment."));
		assertFalse(m.getSpotDescription(0, 0).contentEquals(""));
		
	}
	
	@Test
	public void testGetHint() {
		roomNum = 1;
		m = new Map(roomNum, items);
		
		assertTrue(m.getHint(0, 0).contains("There is nothing here"));
		assertFalse(m.getSpotDescription(0, 0).contentEquals(""));
	}
	
	@Test
	public void testGetSpot() {
		assertFalse(m.getSpot(0, 0).hasItem("anything"));
	}
	
}
