package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] arrayInput = scanner.nextLine().split(" ");

        ArrayDeque<String> digitsAndSymbols = new ArrayDeque<>();

        for (int i = arrayInput.length - 1; i >= 0; i--) {
            String currentElement = arrayInput[i];
            digitsAndSymbols.push(currentElement);
        }

        while (digitsAndSymbols.size() != 1) {
            int firstNum;
            String operator;
            int secondNum;
            int result = 0;

                firstNum = Integer.parseInt(digitsAndSymbols.pop());
                operator = digitsAndSymbols.pop();
                secondNum = Integer.parseInt(digitsAndSymbols.pop());

                if (operator.equals("+")) {
                    result = firstNum + secondNum;

                } else if (operator.equals("-")) {
                    result = firstNum - secondNum;
                }
                digitsAndSymbols.push(String.valueOf(result));

        }
        int numberToPrint = Integer.parseInt(digitsAndSymbols.peek());
        System.out.println(numberToPrint);
    }
}
