package JavaAdvancedLab.Generics.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integer = new ArrayList<>();
        Collections.addAll(integer, 1, 2, 3, 4, 5);

        Integer maxInt = ListUtils.getMax(integer);
        System.out.println(maxInt);

        Integer minInt = ListUtils.getMin(integer);
        System.out.println(minInt);
    }
}
