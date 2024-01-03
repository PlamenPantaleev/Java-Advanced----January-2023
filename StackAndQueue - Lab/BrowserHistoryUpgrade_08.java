package JavaAdvancedLab.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> pagesToReturn = new ArrayDeque<>();

        String lastCommand = "";
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (history.size() == 0 || history.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    String backPage = history.poll();
                    pagesToReturn.addFirst(backPage);
                    System.out.println(history.peek());
                }
            } else if (command.equals("forward")) {
                if (pagesToReturn.size() <= 1 && !lastCommand.equals("back")) {
                    lastCommand = command;
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    String pageToReturn = pagesToReturn.peek();
                    System.out.println(pageToReturn);
                    history.push(pageToReturn);
                    pagesToReturn.remove(pageToReturn);
                }
            } else {
                String page = command;
                history.push(page);
                System.out.println(page);
            }
            lastCommand = command;
            command = scanner.nextLine();
        }
    }
}
