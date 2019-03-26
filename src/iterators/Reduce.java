package iterators;


import java.util.Iterator;
import java.util.function.BiFunction;

// Iterator that returns a single element that is the result of
// combining all the input elements with the initialValue
public class Reduce<InT,OutT> implements Iterator<OutT> {
		public Reduce(OutT initialValue, BiFunction<OutT,InT,OutT> f, Iterator<InT> input) {
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public OutT next() {
			return null;
		}
}
