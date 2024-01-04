package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int cols = Integer.parseInt(dimensions.split(" ")[1]);

        String [][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] input = scanner.nextLine().split(" ");
            for (int j = 0; j < cols ; j++) {
                matrix[i][j] = input[j];
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String [] commandArr = command.split("\\s+");
            if (commandArr[0].equals("swap")) {
                if (commandArr.length > 5 ){
                    System.out.println("Invalid input!");
                    command = scanner.nextLine();
                    continue;
                } else {
                    int rowOne = Integer.parseInt(command.split(" ")[1]);
                    int colOne = Integer.parseInt(command.split(" ")[2]);
                    int rowTwo = Integer.parseInt(command.split(" ")[3]);
                    int colTwo = Integer.parseInt(command.split(" ")[4]);

                    if (rowOne - 1 > rows || rowTwo - 1 > rows || colOne - 1 > cols || colTwo - 1 > cols) {
                        System.out.println("Invalid input!");
                    } else {
                        matrix = changeMatrix(matrix, rowOne, rowTwo, colOne, colTwo);
                        printMatrix(matrix);
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }


            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] changeMatrix(String[][] matrix, int rowOne, int rowTwo, int colOne, int colTwo) {

        String firstElement = matrix[rowOne][colOne];
        String secondElement = matrix[rowTwo][colTwo];

        matrix[rowOne][colOne] = secondElement;
        matrix[rowTwo][colTwo] = firstElement;
        return matrix;
    }
}
