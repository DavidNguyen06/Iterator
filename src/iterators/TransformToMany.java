package iterators;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

// Iterator that may produce 0 or more output elements for every input element
public class TransformToMany<InT,OutT> implements Iterator<OutT> {
	private final Function<InT, List<OutT>> f;
	private final Iterator<InT> input;
	private Iterator<OutT> t2;





	public TransformToMany(Function<InT, List<OutT>> f, Iterator<InT> input) {
			this.f = f;
			this.input = input;
			this.t2 = listFunction();

		}

		@Override
		public boolean hasNext() {
			return t2.hasNext();
		}

		@Override
		public OutT next() {
//			return this.t.next();
			return t2.next();

		}


		public Iterator<OutT> listFunction(){
			List<OutT> finalList = new LinkedList<>();
			List<OutT> subList;
			while (this.input.hasNext()){
				subList = f.apply(this.input.next());
				for (OutT num: subList){
					finalList.add(num);
				}
			}
			return finalList.iterator();
		}
		/* method here
			finalList;
			//iterate through the final list
			sublist=f.apply(finalList(
			//iterate through sublist
			finalList(add all elements in sublist)
			//return finallist
			//return fianlist.iterator()
			//hasNext()---finalLIst.iterator().hasNext()
			//next().---> finalList.iterator().next();
		 */







        // feel free to create private methods if helpful



}
