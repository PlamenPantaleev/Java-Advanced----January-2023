package JavaAdvancedLab.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            int [] arrayInput = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < dimensions; j++) {
                matrix[i][j] = arrayInput[j];
            }
        }
        int counter = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][counter] + " ");
                counter ++;
            }
        }
        System.out.println();
        for (int i = 0; i < 1; i++) {
            counter = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][counter] + " ");
                counter++;
            }
        }
    }
}
