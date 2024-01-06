package JavaAdvancedLab.Generics.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayCreator {


    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) Array.newInstance(item.getClass(), length);

        Arrays.fill(array, item);

        return array;
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);

        Arrays.fill(array, item);

        return array;
    }
}
