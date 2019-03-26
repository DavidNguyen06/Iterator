package queries;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

// Split String by instances of a given string
//   Example: delimiter is "A"
//        apply("An apple A day") returns ["","n apple ", " day"]
public class SplitBy implements Function<String, List<String>> {
    private String ch;
    public SplitBy(String c) {
        this.ch = c;
    }
    @Override
    public List<String> apply(String x) {
        List<String> l = new LinkedList<>();
        l.addAll(Arrays.asList(x.split(ch)));
        return l;
    }
}
