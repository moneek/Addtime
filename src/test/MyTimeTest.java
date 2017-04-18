package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tiime.MyTime;

public class MyTimeTest {
	

	@Test
	public void testAddToNextPM() {
		MyTime t = new MyTime();
		
		assertTrue(t.addMinutes("9:13 AM", 200).equals("12:33 PM"));
	}
	
	@Test
	public void testAddToSameAM() {
		MyTime t = new MyTime();
		
		assertTrue(t.addMinutes("9:13 AM", 120).equals("11:13 AM"));
		
	}
	
	@Test
	public void testAdd24Hours() {
		MyTime t = new MyTime();
		
		assertTrue(t.addMinutes("9:13 AM", 1440).equals("9:13 AM"));
		
	}
}
