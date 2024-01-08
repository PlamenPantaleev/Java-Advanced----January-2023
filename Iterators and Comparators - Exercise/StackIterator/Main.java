package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();

        String[] input = scanner.nextLine().split(" |, ");
        for (int i = 1; i < input.length; i++) {
            int numToPush = Integer.parseInt(input[i]);
            stackIterator.push(numToPush);
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            try {
                stackIterator.pop();
            } catch (ArrayStoreException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        stackIterator.forEach(System.out::println);
    }
}
