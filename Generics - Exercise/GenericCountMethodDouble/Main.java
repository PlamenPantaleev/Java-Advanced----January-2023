package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(num);
            boxes.add(box);
        }
        Box<Double> num = new Box<>(Double.parseDouble(scanner.nextLine()));
        int count = 0;
        for (Box box : boxes) {
            int current = box.compareTo(num);
            if (current > 0) {
                count++;
            }
        }
        System.out.println(count);
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
