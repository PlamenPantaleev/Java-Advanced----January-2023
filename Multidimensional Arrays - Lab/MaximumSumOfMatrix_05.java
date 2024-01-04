package JavaAdvancedLab.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfMatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] matrixDimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimension[0];
        int cols = matrixDimension[1];

        int [][] matrix = new int[rows][cols];
        int [] subMatrix = new int[4];

        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int sumElement = matrix[i][j] + matrix[i][j + 1] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (sumElement > maxSum) {
                    subMatrix[0] = matrix[i][j];
                    subMatrix[1] = matrix[i][j + 1];
                    subMatrix[2] = matrix[i + 1][j];
                    subMatrix[3] = matrix[i + 1][j + 1];
                    maxSum = sumElement;
                }
            }
        }
        for (int i = 0; i <= subMatrix.length / 2; i++) {
            System.out.println(subMatrix[i] + " " + subMatrix[i + 1]);
            i++;
        }
        System.out.println(maxSum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int i = 0; i < matrix.length; i++) {
            int [] numbersArray = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[i].length; j++) {
                int currentNum = numbersArray[j];
                matrix[i][j] = currentNum;
            }
        }
    }
}
