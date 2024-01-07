package StacksQueesAndMatrix;

import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredients::push);


        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.peek();
            int ingredient = ingredients.peek();
            int sum = liquid + ingredient;

            if (sum == 25) {
                foods.put("Biscuit", foods.get("Biscuit") + 1);
            } else if (sum == 50) {
                foods.put("Cake", foods.get("Cake") + 1);
            } else if (sum == 75) {
                foods.put("Pastry", foods.get("Pastry") + 1);
            } else if (sum == 100) {
                foods.put("Pie", foods.get("Pie") + 1);
            } else {
                liquids.poll();
                ingredient = ingredient + 3;
                ingredients.pop();
                ingredients.push(ingredient);
                continue;
            }
            liquids.poll();
            ingredients.pop();
        }

        checkFoods(foods);
        printLiquids(liquids);
        printIngredients(ingredients);
        printFoods(foods);
    }




    private static void checkFoods(Map<String, Integer> foods) {
        if (foods.get("Biscuit") > 0 && foods.get("Cake") > 0 && foods.get("Pastry") > 0
        && foods.get("Pie") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
    }

    private static void printFoods(Map<String, Integer> foods) {
        for (Map.Entry<String, Integer> entry : foods.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void printIngredients(ArrayDeque<Integer> ingredients) {
        if (!ingredients.isEmpty()) {
            System.out.println("Ingredients left: " + String.join(", ",
                    ingredients.toString().replace("[", "").replace("]", "")));
        } else {
            System.out.println("Ingredients left: none");
        }
    }

    private static void printLiquids(ArrayDeque<Integer> liquids) {
        if (!liquids.isEmpty()) {
            System.out.println("Liquids left: " + String.join(" ,",
                    liquids.toString()).replace("[", "").replace("]", ""));
        } else {
            System.out.println("Liquids left: none");
        }
    }
}
