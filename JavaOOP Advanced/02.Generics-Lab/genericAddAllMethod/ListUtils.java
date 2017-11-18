package genericAddAllMethod;

import java.util.ArrayList;
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

    public static List<Integer> getNullIndices(List<?> list) {
        throwExeptionIfListEmpty(list);
        List<Integer> indices = new ArrayList<>();
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) == null) {
                indices.add(index);
            }
        }
        return indices;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> source) {
        for (List<? extends T> list : source) {
            dest.addAll(list);
        }
    }

    public static <T> void addAll(List<? super T> dest, List<? extends T> source) {
        dest.addAll(source);
    }

    private static <T> void throwExeptionIfListEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
