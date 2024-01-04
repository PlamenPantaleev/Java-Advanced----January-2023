package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.*;

public class Voina_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();

        int [] firsDeckCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int [] secondDeckCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < firsDeckCards.length; i++) {
            deckOne.add(firsDeckCards[i]);
        }
        for (int i = 0; i < secondDeckCards.length; i++) {
            deckTwo.add(secondDeckCards[i]);
        }
        int turns = 0;
        boolean firstPlayerWins = false;
        boolean secondPlayerWins = false;
        while (turns < 50) {
            if (deckOne.isEmpty()) {
                break;
            } else if (deckTwo.isEmpty()) {
                break;
            }
            int firstCard = deckOne.iterator().next();
            deckOne.remove(firstCard);
            int secondCard = deckTwo.iterator().next();
            deckTwo.remove(secondCard);

            if (firstCard > secondCard) {
                deckOne.add(firstCard);
                deckOne.add(secondCard);
            } else if (secondCard > firstCard) {
                deckTwo.add(firstCard);
                deckTwo.add(secondCard);
            }
            turns++;
        }
        if (deckOne.size() > deckTwo.size()) {
            System.out.println("First player win!");
        } else if (deckTwo.size() > deckOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
