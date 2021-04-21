package derbyTest.copy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.DatabaseLogic;
import model.Spot;

public class LogTest {
	
	private List<String> log;
	DatabaseLogic database = null;
	
	//private ArrayList<String> descriptions;
	//private ArrayList<String> items;
	
	@Before
	public void setup() {
		database = new DatabaseLogic();
	}
	

	@Test
	public void testStartLog() {
		log = database.getLog();
		assertTrue(log.get(0).contains("You are in a dark and dirty room"));
	}
	
	
	@Test
	public void testAddLog() {
		database.addLog("This is the added line of log");
		log = database.getLog();
		for(int i = 0; i < log.size(); i++)
		{
			System.out.println(log.get(i));
		}
		assertTrue(log.get(2).contains("This is the added line of log"));
	}
	
}
