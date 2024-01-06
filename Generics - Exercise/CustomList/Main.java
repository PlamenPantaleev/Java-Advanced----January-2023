package CustomList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> customList = new CustomList<String>();

        while (!input.equals("END")) {
            String[] commandArray = input.split("\\s+");
            String command = commandArray[0];
            switch (command) {
                case "Add":
                    customList.add(commandArray[1]);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandArray[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandArray[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(commandArray[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String element : customList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }
            input = scanner.nextLine();

        }

    }
}
