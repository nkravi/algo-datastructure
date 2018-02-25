package leethcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Flatten2DVectorTest {
	
	private Flatten2DVector iterator;
	private List<List<Integer>> vec2d;
	
	@Before
	public void init() {
		vec2d = new ArrayList<>();
		List<Integer> row1 = new ArrayList<Integer>();
		row1.addAll(Arrays.asList(1,2,3,4));
		
		List<Integer> row2 = new ArrayList<Integer>();
		row2.addAll(Arrays.asList(5,6));
		
		List<Integer> row3 = new ArrayList<Integer>();
		row3.addAll(Arrays.asList(7,8,9));
		
		
		vec2d.add(row1);
		vec2d.add(row2);
		vec2d.add(row3);
		
		iterator = new Flatten2DVector(vec2d);
	}
	
	@Test
	public void testIterator() {
		
		Integer val = 1;
		while(val <= 9) {
			assertEquals(true,iterator.hasNext());
			assertEquals(val,iterator.next());
			val++;
		}
		assertEquals(false,iterator.hasNext());
	}

}
