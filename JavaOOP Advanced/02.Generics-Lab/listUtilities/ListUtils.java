package listUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        throwExeptionIfListEmpty(list);
        T min = list.get(0);
        for (int index = 1; index < list.size(); index++) {
            if (min.compareTo(list.get(index)) > 0) {
                min = list.get(index);
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        throwExeptionIfListEmpty(list);
        T max = list.get(0);
        for (int index = 1; index < list.size(); index++) {
            if (max.compareTo(list.get(index)) < 0) {
                max = list.get(index);
            }
        }
        return max;
    }

    private static <T> void throwExeptionIfListEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
