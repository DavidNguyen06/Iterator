package queries;


import iterators.Transform;
import readers.TextFileReader;

import java.util.Iterator;
import java.util.function.Function;

// return the words beginning with Z or z in every file
public class TextQuery1c {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		Iterator<String> contents = new Transform(new Pair.Right(), filenameAndContents);

		// REPLACE NULL WITH COMMENTED CODE
	    Iterator<String> words = null;//new Transform(new AllZWords(), contents);

		while (words.hasNext()) {
			System.out.println(words.next());
		}
	}	

	// The only change you should make to this file:
	//   define AllZWords class here
	//   Its apply function should take a String
	//   and return all words that start with the character Z or z (where words are defined as separated by a " ")
	// The words in the output should be separated by a space (" ") (see expected/TextQuery1c.txt)
	// If there are no Z or z words then return the empty String
	// See TransformTest.java for examples
	// UNCOMMENT THIS LINE!
	//private static class AllZWords implements Function<String,String> {}

}
