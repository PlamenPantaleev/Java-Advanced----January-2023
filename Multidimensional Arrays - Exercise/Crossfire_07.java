package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_07 {
    private static int [][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        matrix = new int[rows][cols];
        fillMatrix(matrix);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int [] currentCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = currentCoordinates[0];
            int col = currentCoordinates[1];
            int radius = currentCoordinates[2];

            int start = Math.max(0, row - radius);
            int end = Math.min(matrix.length - 1, row + radius);

            for (int i = start; i <= end; i++) {
                if (isValidIndex(i, col) && i != row) {
                    removeElement(i, col);
                }
            }

            end = Math.max(0, col - radius);
            for (int i = col + radius; i >= end; i--) {
                if (isValidIndex(row, i)) {
                    removeElement(row, i);
                }
            }
            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void removeElement(int i, int col) {
        int rowSize = matrix[i].length - 1;

        if (rowSize > 0) {
            int elementToRemove = matrix[i][col];
            int index = 0;
            int[] newArray = new int[rowSize];

            for (int j = 0; j < matrix[i].length; j++) {
                int currentNum = matrix[i][j];

                if (currentNum != elementToRemove) {
                    newArray[index++] = currentNum;
                }
            }
            matrix[i] = newArray;
        } else {
            int [][] newMatrix = new int[matrix.length - 1][];

            boolean finished = false;

            int rowMatrix = 0;
            int newMatrixRow = 0;

            int elementToRemove = matrix[i][col];

            while (!finished) {
                int matrixRowSize = matrix[rowMatrix].length;
                if (matrixRowSize > 1 || matrix[rowMatrix][col] != elementToRemove) {
                    newMatrix[newMatrixRow] = matrix[rowMatrix];
                    newMatrixRow++;
                }
                rowMatrix++;

                if (rowMatrix >= matrix.length) {
                    finished = true;
                }
            }
            matrix = newMatrix;
        }
    }

    private static boolean isValidIndex(int i, int col) {
        return i >= 0 && i < matrix.length && col >= 0 && col < matrix[i].length;
    }

    private static void fillMatrix(int[][] matrix) {
        int startNumber = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
