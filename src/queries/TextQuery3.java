package queries;


import java.util.Iterator;

import iterators.SuchThat;
import iterators.Transform;
import readers.TextFileReader;
import java.util.List;
import java.util.LinkedList;
import java.util.function.Function;

// return all filenames that contain the word "Mars" or "alien"
public class TextQuery3 {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");

		/* finish the query using a combination of Transforms and SuchThats */
		Iterator<Object> found= new SuchThat(new containsMarsOrAlien(filenameAndContents.next()),filenameAndContents);

		Iterator<Object> contents = new Transform(new Pair.Left(), found);
        Iterator<Object> lastIterator = contents;
		while (lastIterator.hasNext()) {
			System.out.println(lastIterator.next());
		}
	}


	// put your classes that implement Function here
	public static class containsMarsOrAlien implements Function<Pair<String,String>,Boolean>{


        public containsMarsOrAlien(Pair<String, String> next) {
        }

        @Override
        public Boolean apply(Pair<String, String> c) {
            return (c.right.contains("Mars")) || (c.right.contains("alien"));
        }
    }

}
