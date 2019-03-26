package iterators;


import java.util.Iterator;

public class AddX implements Iterator<Integer> {
      
        // The Iterator that this apply  object will get its input from
		private final Iterator<Integer> input;	
        private final int x;

		public AddX(int x, Iterator<Integer> input) {
				this.input = input;
                this.x = x;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Integer next() {
			return null;
		}
}
