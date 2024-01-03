package JavaAdvancedLab.StacksAndQueues;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] kidsInput = scanner.nextLine().split(" ");
        int numberOfThrows = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kids = new PriorityQueue<>();

        for (int i = 0; i < kidsInput.length; i++) {
            kids.offer(kidsInput[i]);
        }
        int cycle = 1;
        while (kids.size() > 1) {

            for (int i = 1; i <= numberOfThrows; i++) {
                if (i == numberOfThrows) {
                    if (isPrime(cycle)) {
                        String kidToRemove = kids.poll();
                        System.out.println("Removed " + kidToRemove);
                        cycle ++;
                    } else {
                        System.out.println("Prime " + kids.peek());
                        cycle ++;
                    }
                }
            }
        }
        System.out.println("Last is " + kids.peek());
    }
    public static boolean isPrime (int cycle) {
        int count = 0;
        if (cycle == 1) {
            return true;
        }
        for (int i = 1; i <= cycle; i++) {
            if (cycle % i == 0) {
                count ++;
            }
        }
        if (count > 2) {
            return true;
        } else {
            return false;
        }
    }
}
