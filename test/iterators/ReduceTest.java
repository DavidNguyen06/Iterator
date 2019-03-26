package iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReduceTest {
		
		public ReduceTest() {
		}

		@Test
		public void emptyTest() {
			Integer[] inputValues = {};
			List<Integer> input = Arrays.asList(inputValues);
			String initialValue = "-1";
			Reduce<Integer,String> op = new Reduce("-1", new MaxAsString(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(initialValue, op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}

		@Test
		public void oneTest() {
			Integer[] inputValues = {100};
			List<Integer> input = Arrays.asList(inputValues);
			Reduce<Integer,String> op = new Reduce("-1", new MaxAsString(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals("100", op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void moreTest() {
			Integer[] inputValues = {100, 10, 200, 300, 200, 40, 30, Integer.MIN_VALUE};
			List<Integer> input = Arrays.asList(inputValues);
			Reduce<Integer,String> op = new Reduce("-2", new MaxAsString(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals("300", op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}

        // Used to find the max integer, but output is the integer as a String
		private static class MaxAsString implements BiFunction<String, Integer, String> {
				@Override
				public String apply(String soFar, Integer x) {
					int soFarI = Integer.parseInt(soFar);
					if (soFarI < x) {
						return x.toString();
					} else {
						return soFar;
					}
				}
		}

		@Test
	public void emptyTest2() {
		Integer[] inputValues = {};
		List<Integer> input = Arrays.asList(inputValues);
		Integer initialValue = 100;
		Reduce<Integer,Integer> op = new Reduce(initialValue, new MinInteger(), input.iterator());

		assertEquals(true, op.hasNext());
		assertEquals(initialValue, op.next());
		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	@Test
	public void oneTest2() {
		Integer[] inputValues = {100};
		List<Integer> input = Arrays.asList(inputValues);
		Reduce<Integer,Integer> op = new Reduce(2019, new MinInteger(), input.iterator());

		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals((Integer)100, op.next());
		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	@Test
	public void moreTest2() {
		Integer[] inputValues = {100, 10, 200, 300, 200, 40, 30, Integer.MAX_VALUE};
		List<Integer> input = Arrays.asList(inputValues);
		Reduce<Integer,Integer> op = new Reduce(2019, new MinInteger(), input.iterator());

		assertEquals(true, op.hasNext());
		assertEquals(true, op.hasNext());
		assertEquals((Integer)10, op.next());
		assertEquals(false, op.hasNext());
		assertEquals(false, op.hasNext());
	}

	// Used to find the min of integers
	private static class MinInteger implements BiFunction<Integer, Integer, Integer> {

		@Override
		public Integer apply(Integer soFar, Integer x) {
			if (soFar > x) {
				return x;
			} else {
				return soFar;
			}
		}
	}
}
