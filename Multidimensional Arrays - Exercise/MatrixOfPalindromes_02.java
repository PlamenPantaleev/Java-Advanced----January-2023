package JavaAdvancedExercise.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] matrixDimension = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimension[0];
        int cols = matrixDimension[1];

        String [][] palindromesMatrix = new String[rows][cols];

        StringBuilder palindrome = new StringBuilder();

        for (int i = 0; i < palindromesMatrix.length; i++) {
            for (int j = 0; j < palindromesMatrix[i].length; j++) {
                char firstLetter = (char) ('a' + i);
                char newLetter = (char) (firstLetter + j);
                palindrome.append(firstLetter);
                palindrome.append(newLetter);
                palindrome.append(firstLetter);
                palindromesMatrix[i][j] = palindrome.toString();
                palindrome = new StringBuilder();
            }
        }
        for (int i = 0; i < palindromesMatrix.length; i++) {
            for (int j = 0; j < palindromesMatrix[i].length; j++) {
                System.out.print(palindromesMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
