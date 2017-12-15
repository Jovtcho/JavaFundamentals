package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    public T max() {
        Iterator<T> iterator = super.iterator();
        T max = null;

        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (max == null || max.compareTo(nextElement) < 0) {
                max = nextElement;
            }
        }

        return max;
    }

    public T min() {
        Iterator<T> iterator = super.iterator();
        T min = null;

        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (min == null || min.compareTo(nextElement) > 0) {
                min = nextElement;
            }
        }

        return min;
    }
}
