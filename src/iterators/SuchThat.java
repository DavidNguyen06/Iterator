package iterators;


import java.util.Iterator;
import java.util.function.Function;
import java.util.List;
import java.util.LinkedList;

// Iterator that uses a Function<T, Boolean> to filter out elements from the input

// UNCOMMENT THE implements Iterator<T> before starting!
public class SuchThat<T> implements Iterator<T> {
    private final Function<T, Boolean> p;
    private final Iterator<T> input;
    private Iterator<T> t3;

	public SuchThat(Function<T, Boolean> p, Iterator<T> input) {
        this.p = p;
        this.input = input;
        this.t3 = EqualToZero();


	}

    public boolean hasNext() {
	    return this.t3.hasNext();
    }

    public T next() {
        return this.t3.next();
    }

    public Iterator<T> EqualToZero(){
        List<T> finalList2 = new LinkedList<>();
        //T subList2;
	    while (this.input.hasNext()){
	        T num = this.input.next();
	        if (this.p.apply(num)){
	            finalList2.add(num);
            }
        }
	    System.out.println(finalList2);
	    return finalList2.iterator();
    }
}
