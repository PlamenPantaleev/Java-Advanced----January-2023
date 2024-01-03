package JavaAdvancedExercise.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plants = new ArrayDeque<>();

        for (int i = 1; i <= numberOfPlants; i++) {
            plants.offer(scanner.nextInt());

        }
        System.out.println();

       while (true) {
           ArrayDeque<Integer> updatedPlants = new ArrayDeque<>();


       }
    }
}
