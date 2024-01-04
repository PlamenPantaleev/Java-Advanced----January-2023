package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> cards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String [] inputArray = input.split(": ");
            String name = inputArray[0];
            String [] currentCards = inputArray[1].split(", ");
            for (int i = 0; i < currentCards.length; i++) {
                String currentCard = currentCards[i];

                if (!cards.containsKey(name)) {
                    cards.put(name, new ArrayList<>());
                    cards.get(name).add(currentCard);
                } else {
                    if (!cards.get(name).contains(currentCard)) {
                        cards.get(name).add(currentCard);
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, ArrayList<String>> entry : cards.entrySet()) {
            String currentPlayer = entry.getKey();
            System.out.printf("%s: ", currentPlayer);
            int totalPower = 0;

            for (int i = 0; i < 1; i++) {
                totalPower += getThePower(entry.getValue());
            }
            System.out.printf("%d%n", totalPower);
        }
    }

    private static int getThePower(ArrayList<String> cards) {
        int totalPower = 0;

        for (int i = 0; i < cards.size(); i++) {
            String currentCard = cards.get(i);

            totalPower += powerOfCurrentCard(currentCard);
        }
        return totalPower;
    }

    private static int powerOfCurrentCard(String currentCard) {
        char firstSymbol;
        char secondSymbol;
        if (currentCard.contains("10")) {
            firstSymbol = ' ';
            secondSymbol = currentCard.charAt(2);
        } else {
            firstSymbol = currentCard.charAt(0);
            secondSymbol = currentCard.charAt(1);
        }
        int firsSymbolPower = 0;
        int secondSymbolPower = 0;

        switch (firstSymbol) {
            case '1':
                firsSymbolPower = 1;
                break;
            case '2':
                firsSymbolPower = 2;
                break;
            case '3':
                firsSymbolPower = 3;
                break;
            case '4':
                firsSymbolPower = 4;
                break;
            case '5':
                firsSymbolPower = 5;
                break;
            case '6':
                firsSymbolPower = 6;
                break;
            case '7' :
                firsSymbolPower = 7;
                break;
            case '8':
                firsSymbolPower = 8;
                break;
            case '9' :
                firsSymbolPower = 9;
                break;
            case ' ' :
                firsSymbolPower = 10;
                break;
            case 'J' :
                firsSymbolPower = 11;
                break;
            case 'Q' :
                firsSymbolPower = 12;
                break;
            case 'K' :
                firsSymbolPower = 13;
                break;
            case 'A' :
                firsSymbolPower = 14;
                break;
        }
        switch (secondSymbol) {
            case 'C' :
                secondSymbolPower = 1;
                break;
            case 'D' :
                secondSymbolPower = 2;
                break;
            case 'H' :
                secondSymbolPower = 3;
                break;
            case 'S' :
                secondSymbolPower = 4;
                break;
        }
        return firsSymbolPower * secondSymbolPower;
    }
}
