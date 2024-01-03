package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> expressions = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                expressions.push(i);

            } else if (currentSymbol == ')') {
                int index = expressions.pop();
                String expressionToPrint = input.substring(index, i + 1);
                System.out.println(expressionToPrint);
            }
        }
    }
}
