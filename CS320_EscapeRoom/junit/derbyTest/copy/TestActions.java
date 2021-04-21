package derbyTest.copy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import persist.DerbyDatabase;

public class TestActions {
	DerbyDatabase db;

	@Before
	public void setup() {
		db = new DerbyDatabase();
		db.updateActions("action1 action2");
		
	}
	
	@Test
	public void TestReturnInventory() {
		assertTrue(db.getActions().contains("action1 action2"));
		assertFalse(db.getActions().contains("couch"));
	}
	
	@Test
	public void TestUpdateInventory() {
		assertTrue(db.getActions().contains("action1 action2"));
		
		db.updateActions("action3");
		assertFalse(db.getActions().contains("action1 action2"));
		assertTrue(db.getActions().contains("action3"));
	}
}
