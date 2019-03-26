package queries;


import iterators.Transform;
import iterators.TransformToMany;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import readers.TextFileReader;

// Returns all the words longer than 24 characters
public class TextQuery2 {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		Iterator<String> contents = new Transform(new Pair.Right(), filenameAndContents);
		Iterator<String> words = new TransformToMany(new SplitBy("[ .!,:<>@=*_()/\\t~#\"|-]"), contents);

		// REPLACE NULL WITH COMMENTED CODE
		Iterator<String> longWords=null;// new TransformToMany(new LongerThan(24), words);
		while (longWords.hasNext()) {
			System.out.println(longWords.next());
		}
	}	

	// The only change you should make to this file:
	//   define LongerThan class here (see TransformToManyTest.java for examples
	//
	//   Its constructor should take an int, called len, the size a String needs to be to get to the output
	//   Its apply function should take String and return a List<String> containing
	//   the String if its length is greater than len and empty otherwise.
	//
	//   Example: len is 5
	//        apply("The") returns []
	//        apply("CS2230") returns "CS2230"
	//        apply("I love CS2230") returns "I love CS2230"

	// UNCOMMENT THIS LINE BEFORE STARTING
	//public static class LongerThan implements Function<String,List<String>> {}

}
