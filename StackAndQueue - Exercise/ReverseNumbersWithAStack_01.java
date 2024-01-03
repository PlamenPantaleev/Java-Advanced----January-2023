package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbersInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbersInput.length; i++) {
            int currentNum = numbersInput[i];
            reversedNumbers.push(currentNum);
        }

        int turns = reversedNumbers.size();
        for (int i = 0; i < turns; i++) {
            System.out.print(reversedNumbers.pop() + " ");
        }
    }
}
