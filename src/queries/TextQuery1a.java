package queries;


import iterators.Transform;
import iterators.Limit;
import java.util.Iterator;
import readers.TextFileReader;

// return the contents of the first file
public class TextQuery1a {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		Iterator<String> contents = new Transform(new Pair.Right(), filenameAndContents);
		Iterator<String> firstFileContents = new Limit(1, contents);

		while (firstFileContents.hasNext()) {
			System.out.println(firstFileContents.next());
		}
	}	

}
