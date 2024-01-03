package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main (String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {

                if (history.size() == 0 || history.size() == 1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                history.pop();
            } else {
                history.push(input);
            }
            System.out.println(history.peek());

            input = scanner.nextLine();
        }
    }
}
