package StacksQueesAndMatrix;

import java.util.Scanner;

public class Snake {
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        matrix = new char[dimensions][dimensions];
        fillMatrix(matrix, scanner);

        int[] snakeCoordinates = findSnake(matrix);
        int snakeRow = snakeCoordinates[0];
        int snakeCol = snakeCoordinates[1];


        boolean isOutOfBounds = false;
        int foodCount = 0;


        String command = scanner.nextLine();
        while (foodCount < 10) {
            matrix[snakeRow][snakeCol] = '.';
            if (command.equals("up")) {
                snakeRow--;
                if (!validateIndexRow(matrix, snakeRow)) {
                    isOutOfBounds = true;
                    break;
                }
                char currentChar = matrix[snakeRow][snakeCol];
                if (currentChar == '*') {
                    foodCount++;
                } else if (currentChar == 'B') {
                    matrix[snakeRow][snakeCol] = '.';
                    int[] liarCoordinates = findTheLiar(matrix);
                    matrix[liarCoordinates[0]][liarCoordinates[1]] = 'S';
                    snakeRow = liarCoordinates[0];
                    snakeCol = liarCoordinates[1];
                    command = scanner.nextLine();
                    continue;
                }
                matrix[snakeRow][snakeCol] = 'S';
            } else if (command.equals("down")) {
                snakeRow++;
                if (!validateIndexRow(matrix, snakeRow)) {
                    isOutOfBounds = true;
                    break;
                }
                char currentChar = matrix[snakeRow][snakeCol];
                if (currentChar == '*') {
                    foodCount++;
                } else if (currentChar == 'B') {
                    matrix[snakeRow][snakeCol] = '.';
                    int[] liarCoordinates = findTheLiar(matrix);
                    matrix[liarCoordinates[0]][liarCoordinates[1]] = 'S';
                    snakeRow = liarCoordinates[0];
                    snakeCol = liarCoordinates[1];
                    command = scanner.nextLine();
                    continue;
                }
                matrix[snakeRow][snakeCol] = 'S';
            } else if (command.equals("left")) {
                snakeCol--;
                if (!validateIndexCol(matrix, snakeCol)) {
                    isOutOfBounds = true;
                    break;
                }
                char currentChar = matrix[snakeRow][snakeCol];
                if (currentChar == '*') {
                    foodCount++;
                } else if (currentChar == 'B') {
                    matrix[snakeRow][snakeCol] = '.';
                    int[] liarCoordinates = findTheLiar(matrix);
                    matrix[liarCoordinates[0]][liarCoordinates[1]] = 'S';
                    snakeRow = liarCoordinates[0];
                    snakeCol = liarCoordinates[1];
                    command = scanner.nextLine();
                    continue;
                }
                matrix[snakeRow][snakeCol] = 'S';
            } else if (command.equals("right")) {
                snakeCol++;
                if (!validateIndexCol(matrix, snakeCol)) {
                    isOutOfBounds = true;
                    break;
                }
                char currentChar = matrix[snakeRow][snakeCol];
                if (currentChar == '*') {
                    foodCount++;
                } else if (currentChar == 'B') {
                    matrix[snakeRow][snakeCol] = '.';
                    int[] liarCoordinates = findTheLiar(matrix);
                    matrix[liarCoordinates[0]][liarCoordinates[1]] = 'S';
                    snakeRow = liarCoordinates[0];
                    snakeCol = liarCoordinates[1];
                    command = scanner.nextLine();
                    continue;
                }
                matrix[snakeRow][snakeCol] = 'S';
            }
            if (foodCount == 10) {
                break;
            }
            command = scanner.nextLine();
        }
        if (isOutOfBounds) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodCount);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean validateIndexCol(char[][] matrix, int snakeCol) {
        if (snakeCol < 0 || snakeCol >= matrix.length) {
            return false;
        }
        return true;
    }

    private static int[] findTheLiar(char[][] matrix) {
        int[] array = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];

                if (symbol == 'B') {
                    array[0] = row;
                    array[1] = col;
                }
            }
        }
        return array;
    }

    private static boolean validateIndexRow(char[][] matrix, int snakeRow) {
        if (snakeRow < 0 || snakeRow >= matrix.length) {
            return false;
        }
        return true;
    }

    private static int[] findSnake(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 'S') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }


    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
    }
}
