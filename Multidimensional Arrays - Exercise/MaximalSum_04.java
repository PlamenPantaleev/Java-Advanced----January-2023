package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int [][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentNum = scanner.nextInt();

                matrix[i][j] = currentNum;
            }
        }
        List<Integer> allSquaresSums = new ArrayList<>();
        int squareStart = 0;
        int squareEnd = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                         + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (currentSum > sum) {
                    sum = currentSum;
                    squareStart = i;
                    squareEnd = j + 2;
                }
            }
        }
        System.out.printf("Sum = %d%n", sum);

        for (int i = squareStart; i < squareStart + 3; i++) {
            for (int j = squareEnd - 2; j <= squareEnd; j++) {
                if (j == squareEnd) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
