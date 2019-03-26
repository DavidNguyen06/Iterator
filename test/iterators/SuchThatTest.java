package iterators;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;
import static org.junit.Assert.*;

public class SuchThatTest {
		
		public SuchThatTest() {
		}

		/* UNCOMMENT WHEN YOU GET TO THIS PART OF THE HOMEWORK
		@Test
		public void emptyTest() {
			Integer[] inputValues = {};
			List<Integer> input = Arrays.asList(inputValues);
			SuchThat<Integer> op = new SuchThat(new IsNotZero(), input.iterator());

			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}

		@Test
		public void oneRemovedTest() {
			Integer[] inputValues = {0};
			List<Integer> input = Arrays.asList(inputValues);
			SuchThat<Integer> op = new SuchThat(new IsNotZero(), input.iterator());

			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void oneKeptTest() {
			Integer[] inputValues = {200};
			List<Integer> input = Arrays.asList(inputValues);
			SuchThat<Integer> op = new SuchThat(new IsNotZero(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(200, (int)op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void moreTest() {
			Integer[] inputValues = {0,50,1,0,400,0,0};
			List<Integer> input = Arrays.asList(inputValues);
			SuchThat<Integer> op = new SuchThat(new IsNotZero(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(50, (int)op.next());
			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(1, (int)op.next());
			assertEquals(400, (int)op.next());
			assertEquals(false, op.hasNext());
		}

	@Test
	public void emptyTest2() {
		String[] inputValues = {};
		List<String> input = Arrays.asList(inputValues);
		SuchThat<String> op = new SuchThat(new OneCharacter(), input.iterator());

		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	@Test
	public void oneRemovedTest2() {
		String[] inputValues = {"AB"};
		List<String> input = Arrays.asList(inputValues);
		SuchThat<String> op = new SuchThat(new OneCharacter(), input.iterator());

		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	@Test
	public void oneKeptTest2() {
		String[] inputValues = {"A"};
		List<String> input = Arrays.asList(inputValues);
		SuchThat<String> op = new SuchThat(new OneCharacter(), input.iterator());

		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals("A", op.next());
		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	@Test
	public void moreTest2() {
		String[] inputValues = {"A","AB","ABC","C","D","E","CDE","DE"};
		List<String> input = Arrays.asList(inputValues);
		SuchThat<String> op = new SuchThat(new OneCharacter(), input.iterator());

		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals("A", op.next());
		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals("C", op.next());
		assertEquals(true, op.hasNext());
		assertEquals("D", op.next());
		assertEquals(true, op.hasNext());
		assertEquals("E", op.next());
		assertEquals(false, op.hasNext());
	}

	UNCOMMENT WHEN YOU GET TO THIS PART OF THE HOMEWORK*/

		public static class IsNotZero implements Function<Integer, Boolean> {
                /* Return true if the input isn't 0 */
				@Override
				public Boolean apply(Integer data) {
						return data!=0;
				}
				
		}

		public static class OneCharacter implements Function<String, Boolean> {
			/* Return true if the input is 1 character */
			@Override
			public Boolean apply(String data) {
				return data.length() == 1;
			}
		}
		
}
