package iterators;




import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.List;
import java.util.LinkedList;

// Iterator that returns a single element that is the result of
// combining all the input elements with the initialValue
public class Reduce<InT,OutT> implements Iterator<OutT> {
		private OutT initialValue;
		private final BiFunction<OutT,InT,OutT> f;
		private final Iterator<InT> input;
		private Boolean found;

		public Reduce(OutT initialValue, BiFunction<OutT,InT,OutT> f, Iterator<InT> input) {
			this.initialValue = initialValue;
			this.f = f;
			this.input = input;
			this.found = false;

		}


	@Override
		public boolean hasNext() {
			//return this.t4.hasNext();
			return !found;
		}

		@Override
		public OutT next() {
			//return this.t4.next();
			return findAnswer();
		}

		public OutT findAnswer(){
			while (this.input.hasNext()){
				this.initialValue = f.apply(this.initialValue, this.input.next());
			}
			this.found = true;
			return this.initialValue;
		}



}
