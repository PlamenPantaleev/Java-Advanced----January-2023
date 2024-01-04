package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int [][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int counter = 0;

        for (int col = cols - 1; col >= 0; col--) {
            for (int row = rows - 1; row >= 0; row--) {
                if (col + counter >= cols) {
                    break;
                }
                System.out.print(matrix[row][col + counter] + " ");
                counter++;
            }
            counter = 0;
            System.out.println();
        }
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                if (row - counter == 0) {
                    System.out.print(matrix[row - counter][col]);
                    break;
                }
                System.out.print(matrix[row - counter][col] + " ");
                counter++;
            }
            counter = 0;
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int [] currentArray = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentArray;
        }
    }
}
