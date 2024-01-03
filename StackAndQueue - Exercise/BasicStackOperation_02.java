package JavaAdvancedExercise.StacksAndQueues;

import java.util.*;

public class BasicStackOperation_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                int minNum = Integer.MAX_VALUE;
                int stackSize = stack.size();

                for (int j = 0; j < stackSize; j++) {
                    int currentNum = stack.pop();
                    if (minNum > currentNum) {
                        minNum = currentNum;
                    }
                }
                System.out.println(minNum);
            }
        }
    }
}
