package JavaAdvancedLab.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixSize = scanner.nextLine();

        int firstRows = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int firstCols = Integer.parseInt(matrixSize.split("\\s+")[1]);

        int firstMatrix [][] = new int[firstRows][firstCols];

        for (int i = 0; i < firstRows; i++) {
            int [] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < firstCols; j++) {
                firstMatrix [i][j] = arrayOfNumbers[j];
            }
        }

        matrixSize = scanner.nextLine();

        int secondRows = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int secondCols = Integer.parseInt(matrixSize.split("\\s+")[1]);

        int [][] secondMatrix = new int[secondRows][secondCols];

        for (int i = 0; i < secondRows; i++) {
            int [] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < secondCols; j++) {
                secondMatrix[i][j] = arrayOfNumbers[j];
            }
        }
        if (equalMatrix(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static boolean equalMatrix (int [][] firstMatrix, int [][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                return  false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
