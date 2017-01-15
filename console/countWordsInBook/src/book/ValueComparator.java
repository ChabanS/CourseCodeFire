package book;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Sergey
 */
public class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

    private Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Map.Entry<String, Integer> o1,
            Map.Entry<String, Integer> o2) {
        return (o2.getValue()).compareTo(o1.getValue());
    }

}
