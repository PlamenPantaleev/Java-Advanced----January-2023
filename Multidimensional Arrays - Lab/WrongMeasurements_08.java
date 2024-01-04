package JavaAdvancedLab.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixDimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixDimensions][];
        fillMatrix(scanner, matrixDimensions, matrix);
        int [] numberCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int wrongNumber = matrix[numberCoordinates[0]][numberCoordinates[1]];

        int[][] newMatrix = new int[matrixDimensions][matrix[0].length];

        List<Integer> numbersFromMatrix = new ArrayList<>();

        boolean changedNumber = false;
        int sum = 0;
        int upNumber = 0;
        int downNumber = 0;
        int leftNumber = 0;
        int rightNumber = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int currentNumber = matrix[i][j];

                if (currentNumber == wrongNumber) {
                    if (i == 0) {
                        if (j == 0) {
                            downNumber = matrix[i + 1][j];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        } else if (j == matrix[i].length - 1) {
                            downNumber = matrix[i + 1][j];
                            leftNumber = matrix[i][j - 1];
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(leftNumber);
                            changedNumber = true;
                        } else {
                            downNumber = matrix[i + 1][j];
                            leftNumber = matrix[i][j - 1];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(leftNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        }
                    } else if (i == matrix.length - 1) {
                        if (j == 0) {
                            upNumber = matrix[i - 1][j];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        } else if (j == matrix[i].length - 1) {
                            upNumber = matrix[i - 1][j];
                            leftNumber = matrix[i][j - 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(leftNumber);
                            changedNumber = true;
                        } else {
                            upNumber = matrix[i - 1][j];
                            leftNumber = matrix[i][j - 1];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(leftNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        }
                    } else {
                        if (j == 0) {
                            upNumber = matrix[i - 1][j];
                            downNumber = matrix[i + 1][j];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        } else if (j == matrix[i].length - 1) {
                            upNumber = matrix[i - 1][j];
                            downNumber = matrix[i + 1][j];
                            leftNumber = matrix[i][j - 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(leftNumber);
                            changedNumber = true;
                        } else {
                            upNumber = matrix[i - 1][j];
                            downNumber = matrix[i + 1][j];
                            leftNumber = matrix[i][j - 1];
                            rightNumber = matrix[i][j + 1];
                            numbersFromMatrix.add(upNumber);
                            numbersFromMatrix.add(downNumber);
                            numbersFromMatrix.add(leftNumber);
                            numbersFromMatrix.add(rightNumber);
                            changedNumber = true;
                        }
                    }
                } else {
                    newMatrix[i][j] = currentNumber;
                }
                if (changedNumber) {
                    sum = getSum(numbersFromMatrix, wrongNumber);
                    newMatrix[i][j] = sum;
                    numbersFromMatrix = new ArrayList<>();
                    changedNumber = false;
                }
            }
        }

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int getSum(List<Integer> numbersFromMatrix, int wrongNumber) {
        int sum = 0;
        for (int number : numbersFromMatrix) {
            if (number != wrongNumber) {
                sum += number;
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int matrixDimensions, int[][] matrix) {
        for (int i = 0; i < matrixDimensions; i++) {
            int [] numberToInput = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = numberToInput;
        }
    }
}
