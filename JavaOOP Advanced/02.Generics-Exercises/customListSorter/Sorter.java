package customListSorter;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        int size = customList.getSize();
        boolean isSwapped;

        do {
            isSwapped = false;
            for (int i = 1; i < size; i++) {
                if (customList.getElement(i - 1).compareTo(customList.getElement(i)) > 0) {
                    customList.swap(i - 1, i);
                    isSwapped = true;
                }
            }
        } while (isSwapped);
    }
}
