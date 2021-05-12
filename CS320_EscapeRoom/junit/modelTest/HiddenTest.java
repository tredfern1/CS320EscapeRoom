package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

public class HiddenTest 
{
	private Hidden hidden;
	private Hidden hidden2;
	private Hidden hidden3;
	private Hidden hidden4;
	private Hidden hidden5;


	@Before
	public void setUp() 
	{
		hidden = new Hidden("gold", 0);
		hidden2 = new Hidden("dino", 0);
		hidden3 = new Hidden("mexico", 1);
		hidden4 = new Hidden("nuggets", 1);
		hidden5 = new Hidden("wendy", 1);
	}
	
	@Test
	public void testGetHiddenStatus() {
		assertTrue(hidden.getStatus() == 0);
		hidden.setStatus(1);
		assertTrue(hidden.getStatus() == 1);
	}
	@Test
	public void testGetHiddenStatus2() {
		assertTrue(hidden2.getStatus() == 0);
		hidden2.setStatus(1);
		assertTrue(hidden2.getStatus() == 1);
	}
	@Test
	public void testGetHiddenStatus3() {
		assertTrue(hidden3.getStatus() == 1);
		hidden3.setStatus(0);
		assertTrue(hidden3.getStatus() == 0);
	}
	@Test
	public void testGetHiddenStatus4() {
		assertTrue(hidden4.getStatus() == 1);
		hidden4.setStatus(0);
		assertTrue(hidden4.getStatus() == 0);
	}
	@Test
	public void testGetHiddenStatus5() {
		assertTrue(hidden5.getStatus() == 1);
		hidden5.setStatus(0);
		assertTrue(hidden5.getStatus() == 0);
	}
	
	@Test
	public void testGetHiddenItem() {
		assertTrue(hidden.getItem() == "gold");
		hidden.setItem("monkey");
		assertTrue(hidden.getItem() == "monkey");
	}
	
	@Test
	public void testGetHiddenItem2() {
		assertTrue(hidden2.getItem() == "dino");
		hidden2.setItem("test");
		assertTrue(hidden2.getItem() == "test");
	}
	
	@Test
	public void testGetHiddenItem3() {
		assertTrue(hidden3.getItem() == "mexico");
		hidden3.setItem("test");
		assertTrue(hidden3.getItem() == "test");
	}
	
	@Test
	public void testGetHiddenItem4() {
		assertTrue(hidden4.getItem() == "nuggets");
		hidden4.setItem("test");
		assertTrue(hidden4.getItem() == "test");
	}
	
	@Test
	public void testGetHiddenItem5() {
		assertTrue(hidden5.getItem() == "wendy");
		hidden5.setItem("test");
		assertTrue(hidden5.getItem() == "test");
	}

}