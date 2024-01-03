package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bracketsInput = scanner.nextLine();

        ArrayDeque<Character> leftBrackets = new ArrayDeque<>();


        boolean areDiff = false;
        for (char bracket : bracketsInput.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                leftBrackets.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (leftBrackets.isEmpty()) {
                    areDiff = true;
                    break;
                } else {
                    char currentBracket = leftBrackets.pop();

                    if (currentBracket == '(' && bracket == ')') {
                        areDiff = false;
                    } else if (currentBracket == '[' && bracket == ']') {
                        areDiff = false;
                    } else if (currentBracket == '{' && bracket == '}') {
                        areDiff = false;
                    } else {
                        areDiff = true;
                        break;
                    }
                }
            }
        }
        if (areDiff) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
