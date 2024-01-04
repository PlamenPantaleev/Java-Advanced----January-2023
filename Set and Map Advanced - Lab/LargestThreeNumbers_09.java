package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listInput =Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        if (listInput.size() <= 3) {
            for (int i = 0; i < listInput.size(); i++) {
                System.out.print(listInput.get(i) + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(listInput.get(i) + " ");
            }
        }
    }
}
