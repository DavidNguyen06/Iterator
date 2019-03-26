package queries;


import java.util.Iterator;
import readers.TextFileReader;

// return all filenames that contain the word "Mars" or "alien"
public class TextQuery3 {
	public static void main(String[] args) {
		Iterator<Pair<String,String>> filenameAndContents = new TextFileReader("sci.space");
		
		/* finish the query using a combination of Transforms and SuchThats */
		Iterator<Object> lastIterator=null;
		
		while (lastIterator.hasNext()) {
			System.out.println(lastIterator.next());
		}
	}	


	// put your classes that implement Function here

}
