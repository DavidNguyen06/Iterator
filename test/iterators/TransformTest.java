package iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;
import static org.junit.Assert.*;

public class TransformTest {
		
		public TransformTest() {
		}

		@Test
		public void emptyTest() {
			Integer[] inputValues = {};
			List<Integer> input = Arrays.asList(inputValues);
			Transform<Integer,Integer> op = new Transform(new TimesTwo(), input.iterator());

			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void oneTest() {
			Integer[] inputValues = {100};
			List<Integer> input = Arrays.asList(inputValues);
			Transform<Integer,Integer> op = new Transform(new TimesTwo(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(200, (int)op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void moreTest() {
			Integer[] inputValues = {10,50,1,400};
			List<Integer> input = Arrays.asList(inputValues);
			Transform<Integer,Integer> op = new Transform(new TimesTwo(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(20, (int)op.next());
			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(100, (int)op.next());
			assertEquals(2, (int)op.next());
			assertEquals(800, (int)op.next());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void stringIntegerTest() {
			String[] inputValues = {"", "abcd", "ef", "ghijkl"};
			List<String> input = Arrays.asList(inputValues);
			Transform<String,Integer> op = new Transform(new NumChars(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(0, (int)op.next());
			assertEquals(true, op.hasNext());
			assertEquals(4, (int)op.next());
			assertEquals(true, op.hasNext());
			assertEquals(2, (int)op.next());
			assertEquals(true, op.hasNext());
			assertEquals(6, (int)op.next());
			assertEquals(false, op.hasNext());
		}

		@Test
		public void integerStringTest() {
			Integer[] inputValues = {0, 0, 5, 1, 4};
			List<Integer> input = Arrays.asList(inputValues);
			Transform<Integer,String> op = new Transform(new RepeatChar(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals("", op.next());
			assertEquals(true, op.hasNext());
			assertEquals("", op.next());
			assertEquals(true, op.hasNext());
			assertEquals("AAAAA", op.next());
			assertEquals(true, op.hasNext());
			assertEquals("A", op.next());
			assertEquals(true, op.hasNext());
			assertEquals("AAAA", op.next());
			assertEquals(false, op.hasNext());
		}

		@Test
		public void chainTest() {
			Integer[] inputValues = {0, 0, 5, 1, 4};
			List<Integer> input = Arrays.asList(inputValues);
			Transform<Integer,Integer> op = new Transform(new TimesTwo(), input.iterator());
			Transform<Integer,String> op2 = new Transform(new RepeatChar(), op);

			assertEquals(true, op2.hasNext());
			assertEquals("", op2.next());
			assertEquals(true, op2.hasNext());
			assertEquals("", op2.next());
			assertEquals(true, op2.hasNext());
			assertEquals("AAAAAAAAAA", op2.next());
			assertEquals(true, op2.hasNext());
			assertEquals("AA", op2.next());
			assertEquals(true, op2.hasNext());
			assertEquals("AAAAAAAA", op2.next());
			assertEquals(false, op2.hasNext());
		}


		private class TimesTwo implements Function<Integer, Integer> {
                /* Multiply input by 2 */
				@Override
				public Integer apply(Integer x) {
					return x*2;
				}
		}

		private class NumChars implements Function<String, Integer> {
                /* Return the number of characters in the string */
				@Override
				public Integer apply(String x) {
					return x.length();
				}
		}
		
		private class RepeatChar implements Function<Integer, String> {
                /* Return a string that is the given number of As
                    for example apply(2) returns "AA"
                 */
				@Override
				public String apply(Integer x) {
					String s = "";
					for (int i=0; i<x; i++) {
						s += "A";
					}
					return s;
				}
		}
}
