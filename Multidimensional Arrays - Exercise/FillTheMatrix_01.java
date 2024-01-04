package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int matrixDimension = Integer.parseInt(input[0]);
        String fillingType = input[1];

        int [][] matrix = new int[matrixDimension][matrixDimension];
        int numberToInput = 1;

        if (fillingType.equals("A")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = numberToInput;
                    numberToInput++;
                }
            }
        } else if (fillingType.equals("B")) {

            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = numberToInput;
                        numberToInput ++;
                    }
                } else {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        matrix[j][i] = numberToInput;
                        numberToInput ++;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
