package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] kids = scanner.nextLine().split(" ");
        int numberOfThrows = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> queueOfKids = new ArrayDeque<>();

        for (int i = 0; i < kids.length; i++) {
            String currentKid = kids[i];
            queueOfKids.offer(currentKid);
        }

        while (queueOfKids.size() > 1) {

            for (int i = 1; i <= numberOfThrows; i++) {
                String kid = queueOfKids.poll();

                if (i == numberOfThrows) {
                    System.out.println("Removed " + kid);

                } else {
                    queueOfKids.offer(kid);
                }
            }
        }
        System.out.println("Last is " + queueOfKids.poll());
    }
}
