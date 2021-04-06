package edu.ycp.cs320.CS320_EscapeRoom.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.*;
import edu.ycp.cs320.CS320_EscapeRoom.model.Logic;

public class logicTest {
	
	private Logic l;
	private Player p;
	private Spot s;
	
	String playerInv;
	String mapInv;
	String actions;
	String move;
	String result;

	@Before
	public void setUp() {
		playerInv = "hammer shoes rat redkey";
		mapInv = "blueKey";
		actions = "unlock1 taking_a_nap";
		move = "take blueKey";
	}
	
	@Test
	public void testLogicPickupMapInventory() {
		
		String temp = l.LogicPickupMapInventory(move, result, mapInv, p);
		System.out.println(temp);
		assertTrue(l.LogicPickupMapInventory(move, result, mapInv, p).equals(""));
	}
	
	@Test
	public void testLogicActions() {
		
	}

}