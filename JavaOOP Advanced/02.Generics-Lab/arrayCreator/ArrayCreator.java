package arrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        Object[] items = new Object[length];
        for (int index = 0; index < items.length; index++) {
            items[index] = item;
        }
        return (T[]) items;
    }

    public static <T> T[] create(Class<T> _class, int length, T item) {
        T[] items = (T[]) Array.newInstance(_class, length);
        for (int index = 0; index < items.length; index++) {
            items[index] = item;
        }
        return items;
    }
}
