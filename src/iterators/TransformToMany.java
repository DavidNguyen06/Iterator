package iterators;


import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

// Iterator that may produce 0 or more output elements for every input element
public class TransformToMany<InT,OutT> implements Iterator<OutT> {
		public TransformToMany(Function<InT, List<OutT>> f, Iterator<InT> input) {
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public OutT next() {
			return null;
		}

        // feel free to create private methods if helpful
}
