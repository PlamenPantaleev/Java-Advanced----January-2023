package JavaAdvancedLab.MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = new String[row][col];
        String [][] secondMatrix = new String[row][col];

        fillMatrix (firstMatrix, scanner);
        fillMatrix(secondMatrix, scanner);

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {

        for (int i = 0; i < matrix.length; i++) {
            String [] elements = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = elements[j];
            }
        }
    }
}
