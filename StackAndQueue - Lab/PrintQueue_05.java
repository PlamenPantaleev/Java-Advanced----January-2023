package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();


        while (!input.equals("print")) {
            String text = input;
            if (text.equals("cancel")) {
                if (queue.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    String textToBeRemoved = queue.poll();
                    System.out.println("Canceled " + textToBeRemoved);
                }
                input = scanner.nextLine();
                continue;
            } else {
                queue.offer(text);
            }

            input = scanner.nextLine();
        }
        for (String element: queue) {
            System.out.println(element);
        }
    }
}
