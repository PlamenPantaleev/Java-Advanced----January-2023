package StacksQueesAndMatrix;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> bombs = new LinkedHashMap<>();
        bombs.put("Cherry StacksQueesAndMatrix.Bombs", 0);
        bombs.put("Datura StacksQueesAndMatrix.Bombs", 0);
        bombs.put("Smoke Decoy StacksQueesAndMatrix.Bombs", 0);


        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombEffects::offer);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombCasings::push);

        int decoyBombsCount = 0;
        int cherryBombsCount = 0;
        int smokeDecoyBombs = 0;
        boolean isDone = false;
        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            int bombEffect = bombEffects.peek();
            int bombCasing = bombCasings.peek();
            int bombQuality = bombEffect + bombCasing;

            if (bombQuality == 40) {
                bombs.put("Datura StacksQueesAndMatrix.Bombs", bombs.get("Datura StacksQueesAndMatrix.Bombs") + 1);
                decoyBombsCount++;
            } else if (bombQuality == 60) {
                bombs.put("Cherry StacksQueesAndMatrix.Bombs", bombs.get("Cherry StacksQueesAndMatrix.Bombs") + 1);
                cherryBombsCount++;
            } else if (bombQuality == 120) {
                bombs.put("Smoke Decoy StacksQueesAndMatrix.Bombs", bombs.get("Smoke Decoy StacksQueesAndMatrix.Bombs") + 1);
                smokeDecoyBombs++;
            } else {
                bombCasings.pop();
                bombCasing = bombCasing - 5;
                bombCasings.push(bombCasing);
                continue;
            }
            bombEffects.poll();
            bombCasings.pop();
            if (decoyBombsCount >= 3 && cherryBombsCount >= 3 && smokeDecoyBombs >= 3) {
                isDone = true;
                break;
            }
        }

        if (isDone) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        printBombEffects(bombEffects);
        printBombCasings(bombCasings);
        printBombs(bombs);
    }

    private static void printBombs(Map<String, Integer> bombs) {
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void printBombCasings(ArrayDeque<Integer> bombCasings) {
        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + String.join(", ", bombCasings.toString()
                    .replace("[", "").replace("]", "")));
        }
    }

    private static void printBombEffects(ArrayDeque<Integer> bombEffects) {
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + String.join(", ", bombEffects.toString().
                    replace("[", "").replace("]", "")));
        }
    }
}
