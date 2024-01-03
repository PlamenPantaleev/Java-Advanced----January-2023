package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InfixToPostfix_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String currentOperator = input[i];

            switch (currentOperator) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "(":
                    if (operators.isEmpty() || lowerPrecedence(operators.peek(), currentOperator)) {
                        operators.push(currentOperator);
                    } else {
                        while (!lowerPrecedence(operators.peek(), currentOperator)) {
                            System.out.print(operators.pop() + " ");
                            if (operators.isEmpty()) {
                                break;
                            }
                        }
                        operators.push(currentOperator);
                    }
                    break;
                case ")":
                    while (!operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }
                    operators.pop();
                    break;
                default:
                    System.out.print(currentOperator + " ");
            }

        }
        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");
        }
    }
    private static boolean lowerPrecedence (String currentOperator, String nextOperator) {
        int currentOperatorPrecedence = precedence(currentOperator);
        int nextOperatorPrecedence = precedence(nextOperator);

        if (currentOperatorPrecedence < nextOperatorPrecedence) {
            return true;
        } else if (currentOperatorPrecedence == nextOperatorPrecedence) {
            if (currentOperatorPrecedence == 3 || currentOperatorPrecedence == 4) {
                return true;
            } else {
                return false;
            }
        } else {
            if (currentOperatorPrecedence == 4) {
                return true;
            } else {
                return false;
            }
        }
    }



    private static int precedence (String operator) {
        int precedence = 0;

        if (operator.equals("+") || operator.equals("-")) {
            precedence = 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            precedence = 2;
        } else if (operator.equals("^")) {
            precedence = 3;
        } else if (operator.equals("(")) {
            precedence = 4;
        }
        return precedence;
    }
}
