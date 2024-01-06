package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Box<String> box = new Box<>(text);
            boxes.add(box);
        }
        int [] swapping = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        swap(boxes, swapping);

        for (Box<String> box : boxes) {
            System.out.println(box);
        }

    }

    private static<T> void swap(List<T> boxes, int[] swapping) {
        int swap = swapping[0];
        int with = swapping[1];
        T firstBox = boxes.get(swap);
        T secondBox = boxes.get(with);
        boxes.set(swap, secondBox);
        boxes.set(with, firstBox);
    }
}
