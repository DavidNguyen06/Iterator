package iterators;


import java.util.Iterator;
import java.util.function.Function;

public class IntTransform implements Iterator<Integer> {
        // The function that will be applied to each input element to make an output element
		private final Function<Integer, Integer> f=null; // WHEN STARTING TO CODE REMOVE =null

        // The Iterator that this Transform object will get its input from
		private final Iterator<Integer> input=null;		// WHEN STARTING TO CODE REMOVE =null

		public IntTransform(Function<Integer, Integer> f, Iterator<Integer> input) {
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Integer next() {
			return null;
		}
}
