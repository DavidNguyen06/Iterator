package iterators;


import java.util.Iterator;
import java.util.function.Function;

public class IntTransform implements Iterator<Integer> {
        // The function that will be applied to each input element to make an output element
		private final Function<Integer, Integer> f; // WHEN STARTING TO CODE REMOVE =null

        // The Iterator that this Transform object will get its input from
		private final Iterator<Integer> input;	// WHEN STARTING TO CODE REMOVE =null

		public IntTransform(Function<Integer, Integer> f, Iterator<Integer> input) {
			this.f = f;
			this.input = input;

		}

		@Override
		public boolean hasNext() {
			return input.hasNext();
		}

		@Override
		public Integer next() {
			return f.apply(input.next());
		}
}
