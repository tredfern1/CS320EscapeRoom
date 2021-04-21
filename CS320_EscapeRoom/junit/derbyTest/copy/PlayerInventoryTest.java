package derbyTest.copy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Coordinate;
import persist.DerbyDatabase;



public class PlayerInventoryTest {
	
	DerbyDatabase db;

	@Before
	public void setup() {
		db = new DerbyDatabase();
		db.updatePlayerInv("item1 item2");
		
	}
	
	@Test
	public void TestReturnInventory() {
		assertTrue(db.getPlayerInv().contains("item1 item2"));
		assertFalse(db.getPlayerInv().contains("couch"));
	}
	
	@Test
	public void TestUpdateInventory() {
		assertTrue(db.getPlayerInv().contains("item1 item2"));
		
		db.updatePlayerInv("item3");
		assertFalse(db.getPlayerInv().contains("item1 item2"));
		assertTrue(db.getPlayerInv().contains("item3"));
	}
}
