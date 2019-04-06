package queries;


import iterators.Reduce;
import iterators.Transform;
import iterators.TransformToMany;
import readers.TextFileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// Return the number total occurrences of the word "Mars" or "alien"
public class TextQuery4 {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		Iterator<String> contents = new Transform(new Pair.Right(), filenameAndContents);
		Iterator<String> words = new TransformToMany(new SplitBy(" "), contents);

        /* finish the query */
		Iterator<Object> lastIterator= new Reduce(0,new foundMarsOrALiens("Mars alien"), words);


		while (lastIterator.hasNext()) {
			System.out.println(lastIterator.next());
		}
	}

    /* Define the additional classes you need here */
	public static class foundMarsOrALiens implements BiFunction<Integer,String,Integer> {
        private String input;

        public foundMarsOrALiens(String s){
            this.input = s;
        }
        public Integer apply(Integer c, String s){
            int t = c;
            if (s.contains("Mars") || s.contains("alien")){
                t++;
            }
            return t;
        }

    }

}


