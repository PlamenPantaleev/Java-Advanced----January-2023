package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")) {
                int numberToPush = Integer.parseInt(command.split("\\s+")[1]);

                numbersStack.push(numberToPush);
            } else if (command.startsWith("2")) {
                numbersStack.pop();
            } else if (command.startsWith("3")) {
                System.out.println(Collections.max(numbersStack));
            }
        }
    }
}
