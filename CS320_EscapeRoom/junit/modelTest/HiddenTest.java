package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

public class HiddenTest 
{
	private Hidden hidden;

	@Before
	public void setUp() 
	{
		hidden = new Hidden("gold", 0);
	}
	
	@Test
	public void testGetHiddenStatus() {
		assertTrue(hidden.getStatus() == 0);
		hidden.setStatus(1);
		assertTrue(hidden.getStatus() == 1);
	}
	
	@Test
	public void testGetHiddenItem() {
		assertTrue(hidden.getItem() == "gold");
		hidden.setItem("monkey");
		assertTrue(hidden.getItem() == "monkey");
	}

}