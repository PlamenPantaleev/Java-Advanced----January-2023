package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbersInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        LinkedHashMap<Double, Integer> realNumbers = new LinkedHashMap<>();

        for (int i = 0; i < numbersInput.length; i++) {
            double currentNum = numbersInput[i];
            if (!realNumbers.containsKey(currentNum)) {
                realNumbers.putIfAbsent(currentNum, 1);
            } else {
                realNumbers.put(currentNum, realNumbers.get(currentNum) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : realNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
