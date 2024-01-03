package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInput = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (numberInput == 0) {
            System.out.println(numberInput);
        } else {
            while (numberInput != 0) {
                int binary = numberInput % 2;
                binaryNumber.push(binary);
                numberInput = numberInput / 2;
            }

            for (int number : binaryNumber) {
                System.out.print(number);
            }
        }
    }
}
