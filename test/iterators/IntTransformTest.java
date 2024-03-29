/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talsulaiman
 */
public class IntTransformTest {
    
    public IntTransformTest() {
    }
    
		@Test
		public void emptyTest() {
			Integer[] inputValues = {};
			List<Integer> input = Arrays.asList(inputValues);
                        IntTransform op = new IntTransform(new TimesTwo(), input.iterator());

			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void oneTest() {
			Integer[] inputValues = {100};
			List<Integer> input = Arrays.asList(inputValues);
                         IntTransform op = new IntTransform(new TimesTwo(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(200, (int)op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}

		@Test
		public void PlusTest() {
			Integer[] inputValues = {100};
			List<Integer> input = Arrays.asList(inputValues);
                         IntTransform op = new IntTransform(new PlusOne(), input.iterator());

			assertEquals(true, op.hasNext());
			assertEquals(true, op.hasNext());
			assertEquals(101, (int)op.next());
			assertEquals(false, op.hasNext());
			assertEquals(false, op.hasNext());
		}
		
		@Test
		public void moreTest() {
			Integer[] inputValues = {10,50,1,400};
			List<Integer> input = Arrays.asList(inputValues);
                         IntTransform op = new IntTransform(new TimesTwo(), input.iterator());

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
		

	private class TimesTwo implements Function<Integer, Integer> {
                /* Multiply input by 2 */
				@Override
				public Integer apply(Integer x) {
					return x*2;
				}
		}
	private class PlusOne implements Function<Integer, Integer> {
                /* add 1 to the input  */
				@Override
				public Integer apply(Integer x) {
					return x+1;
				}
		}
}
