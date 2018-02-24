package leethcode.easy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BullsAndCowsTest {

	BullsAndCows subject;
	@Before
	public void setUp(){
		subject = new BullsAndCows();
	}
	
	@Test
	public void testEmptyString() {
		assertEquals("0A0B",subject.getHint("", ""));
	}
	
	@Test
	public void givenTestCases1(){
		assertEquals("1A3B",subject.getHint("1807", "7810"));
	}
	@Test
	public void givenTestCases2(){
		assertEquals("1A1B",subject.getHint("1123", "0111"));
	}
	@Test
	public void givenTestCases3(){
		assertEquals("3A0B",subject.getHint("1122", "1222"));
	}
	@Test
	public void givenTestCases4(){
		assertEquals("2A2B",subject.getHint("1122", "1221"));
	}
	@Test
	public void noBulls(){
		assertEquals("0A2B",subject.getHint("1123", "0711"));
	}
	@Test
	public void noCows(){
		assertEquals("1A0B",subject.getHint("1123", "1799"));
	}
	@Test
	public void noBullsAndCows(){
		assertEquals("0A0B",subject.getHint("1123", "7896"));
	}
}
