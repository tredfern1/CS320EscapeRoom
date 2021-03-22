package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.Inventory;

public class InventoryTest 
{
	private Inventory inv;

	@Before
	public void setUp() 
	{
		inv = new Inventory();
		inv.additem("phone");
		inv.additem("money");
		inv.additem("crowbar");
	}
	
	@Test
	public void testadditem() {
		inv.additem("car");
		assertTrue(inv.invSize() == 4);
	}
	
	@Test
	public void testhasItem() {
		assertTrue(inv.hasItem("phone") == true);
		assertTrue(inv.hasItem("cat") != true);
	}

}