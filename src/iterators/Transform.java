package iterators;


import java.util.Iterator;
import java.util.function.Function;

public class Transform<InT,OutT> implements Iterator<OutT> {
        // The function that will be applied to each input element to make an output element
		private final Function<InT,OutT> f; // WHEN STARTING TO CODE, REMOVE =null

        // The Iterator that this Transform object will get its input from
		private final Iterator<InT> input; // WHEN STARTING TO CODE, REMOVE =null

		public Transform(Function<InT, OutT> f, Iterator<InT> input) {
			this.f = f;
			this.input = input;
		}

		@Override
		public boolean hasNext() {
			return this.input.hasNext();
		}

		@Override
		public OutT next() {
			return f.apply(input.next());
		}
}
