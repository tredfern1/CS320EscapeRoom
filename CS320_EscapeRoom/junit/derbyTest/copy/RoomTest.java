package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.DatabaseLogic;
import model.Spot;

public class RoomTest {
	
	private int room;
	DatabaseLogic database = null;
	
	//private ArrayList<String> descriptions;
	//private ArrayList<String> items;
	
	@Before
	public void setup() {
		database = new DatabaseLogic();
	}
	

	
	@Test
	public void testPlayerRoomNumber() {
		room = database.getRoom();
		assertTrue(room == 1);
	}
	
	
	@Test
	public void testChangePlayerRoomNumber() {
		database.setRoom(2);
		room = database.getRoom();
		assertTrue(room == 2);
	}
	
}
