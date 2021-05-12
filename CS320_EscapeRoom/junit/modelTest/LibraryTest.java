package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Game;
import model.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LibraryTest {
	
	Library l;
	
	@Before
	public void setUp() {
		l = new Library();
	}
	
	@Test
	public void testValidateUsername() {
		assertTrue(l.validateUserName("student"));
		assertTrue(l.validateUserName("faculty"));
		assertFalse(l.validateUserName("TheLegend27"));
	}
	
	@Test
	public void testValidatePassword() {
		assertTrue(l.validatePW("student", "ycp"));
		assertTrue(l.validatePW("faculty", "E&CS"));
		assertFalse(l.validatePW("student", "password"));
		assertFalse(l.validatePW("TheLegend27", "ycp"));
	}
	
	@Test
	public void testMismatchedCredentials() {
		assertFalse(l.validatePW("student", "E&CS"));
		assertFalse(l.validatePW("faculty", "ycp"));
	}
	
}
