package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> commands = new ArrayDeque<>();
        ArrayDeque<String> texts = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < numberOfOperations; i++) {
            String [] currentInput = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(currentInput[0]);
            if (command == 1 || command == 2) {
                commands.push(command);
            }
            switch (command) {
                case 1:
                    String textToAppend = currentInput[1];
                    texts.push(text.toString());
                    text.append(textToAppend);
                    break;
                case 2:
                    int elementsCount = Integer.parseInt(currentInput[1]);
                    texts.push(text.toString());
                    int counter = 0;
                    while (counter < elementsCount) {
                        counter++;
                        text.deleteCharAt(text.length() - 1);
                    }
                    break;
                case 3:
                    int index = Integer.parseInt(currentInput[1]);
                    if (text.length() <= index - 1) {
                        break;
                    }
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    if (commands.isEmpty()) {
                        break;
                    }
                    int lastCommand = commands.pop();
                    if (lastCommand == 1) {
                        text = new StringBuilder(texts.pop());
                    } else if (lastCommand == 2) {
                        text = new StringBuilder(texts.pop());
                    }
                    break;
            }
        }
    }
}
