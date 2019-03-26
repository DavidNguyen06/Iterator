package queries;


import iterators.Transform;
import java.util.Iterator;
import readers.TextFileReader;

// return the 2nd and 21st word in every file
public class TextQuery1b {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		Iterator<String> contents = new Transform(new Pair.Right(), filenameAndContents);

		// REPLACE NULL WITH COMMENTED CODE
	    Iterator<String> words = null; //new Transform(new The2ndAnd21stWords(), contents);

		while (words.hasNext()) {
			System.out.println(words.next());
		}
	}	

	// The only change you should make to this file:
	//   define The2ndAnd6thWords class here
	//   Its apply function should take a String
	//   and return the 2nd and 21st Words  as a String (where words are defined as separated by a " ")
	// The two words in the output should be separated by ||| (see expected/TextQuery1b.txt)
	// See TransformTest.java for examples
	// UNCOMMENT THIS LINE!
	//private static class The2ndAnd21stWords implements Function<String,String> {}

}
