package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[dimensions][dimensions];

        fillMatrix(dimensions, matrix, scanner);
        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumSecondaryDiagonal(int [][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == matrix.length - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int [][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int dimensions, int[][] matrix, Scanner scanner) {
        for (int i = 0; i < dimensions; i++) {
            int [] currentArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt((Integer::parseInt)).toArray();

            matrix[i] = currentArray;
        }
    }
}
