package JavaAdvancedLab.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int [] arrayInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = arrayInput[j];
            }
        }
        int neededNumber = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == neededNumber) {
                    isFound = true;
                    System.out.printf("%d %d%n", i, j);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
