package queries;


import java.util.Objects;
import java.util.function.Function;

// A simple class to store two values together
public class Pair<L,R> {
	public final L left;
    public final R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

    public String toString() {
        return "(left="+left+",right="+right+")";
    }

		@Override
		public boolean equals(Object obj) {
				if (this == obj) {
						return true;
				}
				if (obj == null) {
						return false;
				}
				if (getClass() != obj.getClass()) {
						return false;
				}
				final Pair<?, ?> other = (Pair<?, ?>) obj;
				if (!Objects.equals(this.left, other.left)) {
						return false;
				}
				if (!Objects.equals(this.right, other.right)) {
						return false;
				}
				return true;
		}


	public static class Right<L,R> implements Function<Pair<L,R>, R> {
		@Override
		public R apply(Pair<L, R> x) {
			return x.right;
		}
	}

	public static class Left<L,R> implements Function<Pair<L,R>, L> {
		@Override
		public L apply(Pair<L, R> x) {
			return x.left;
		}
	}

}
