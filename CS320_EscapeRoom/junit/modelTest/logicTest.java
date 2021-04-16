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
		l = new Logic();
		
		result = "You picked up a blueKey";
		playerInv = "hammer shoes rat redkey";
		mapInv = "001blueKey ";
		actions = "unlock1 taking_a_nap";
		move = "take blueKey";
	}
	
	@Test
	public void testLogicPickupMapInventory() {
		p = new Player();
		
		p.updatePlayerCoor(0, 0);
		p.setRoomNumber(1);
		System.out.println(p.getPlayerx());
		System.out.println(p.getRoomNumber());
		System.out.println(move); 
		
		//test an invalid move on an empty room
		assertTrue(l.LogicPickupMapInventory( " ", " ", " ", p).equals(" "));
		
		//test picking up the only item in the room
		assertTrue(l.LogicPickupMapInventory(move, result, mapInv, p).equals(" "));
		
		//test picking up an item thast isnt in the room
		assertTrue(l.LogicPickupMapInventory("pickup rat", "You picked up a ", mapInv, p).equals("001blueKey "));
	}
	
	@Test
	public void testLogicActions() {
		//test that a move that doesn't update actions doesn't update actions
		assertTrue(l.LogicActions(move, result, playerInv, actions) == actions);
		
		//test that action is added to actions
		assertTrue(l.LogicActions("use hammer", "You used the hammer", playerInv, actions).contentEquals(actions + "boxBreak "));
		
	}
	
	@Test
	public void testLogicPickup() {
		//test invalid addition to inventory
		assertTrue(l.LogicPickup(move, result, playerInv).contentEquals(playerInv + "blueKey "));
		
		//testLogicPickup
		assertTrue(l.LogicPickup("pickup shoe", "You cannot do that", playerInv).contentEquals(playerInv));
	}

}