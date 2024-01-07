package StacksQueesAndMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int cols = Integer.parseInt(dimensions.split(" ")[1]);

        matrix = new char[rows][cols];
        fillMatrix(scanner);

        int positionRow = 0;
        int positionCol = 0;
        int treasureRow = 0;
        int treasureCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 'Y') {
                    positionRow = row;
                    positionCol = col;
                } else if (currentSymbol == 'X') {
                    treasureRow = row;
                    treasureCol = col;
                }
            }
        }

        List<String> commands = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            matrix[positionRow][positionCol] = '-';

            if (command.equals("up")) {
                positionRow--;
                if (!validateIndexRow(positionRow) || matrix[positionRow][positionCol] == 'T') {
                    positionRow++;
                    matrix[positionRow][positionCol] = 'Y';
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("down")) {
                positionRow++;
                if (!validateIndexRow(positionRow) || matrix[positionRow][positionCol] == 'T') {
                    positionRow--;
                    matrix[positionRow][positionCol] = 'Y';
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("left")) {
                positionCol--;
                if (!validateIndexCol(positionCol) || matrix[positionRow][positionCol] == 'T') {
                    positionCol++;
                    matrix[positionRow][positionCol] = 'Y';
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("right")) {
                positionCol++;
                if (!validateIndexCol(positionCol) || matrix[positionRow][positionCol] == 'T') {
                    positionCol--;
                    matrix[positionRow][positionCol] = 'Y';
                    command = scanner.nextLine();
                    continue;
                }

            }
            matrix[positionRow][positionCol] = 'Y';
            commands.add(command);
            command = scanner.nextLine();
        }
        if (positionRow == treasureRow && positionCol == treasureCol) {
            System.out.println("I've found the treasure!");
            if (!commands.isEmpty()) {
                System.out.println("The right path is " + String.join(", ", commands.toString()
                        .replace("[", "").replace("]", "")));
            }
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean validateIndexCol(int positionCol) {
        if (positionCol < 0 || positionCol >= matrix[0].length) {
            return false;
        }
        return true;
    }

    private static boolean validateIndexRow(int positionRow) {
        if (positionRow < 0 || positionRow >= matrix.length) {
            return false;
        }
        return true;
    }

    private static void fillMatrix(Scanner scanner) {
        for (int rows = 0; rows < matrix.length; rows++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = currentRow[cols].charAt(0);
            }
        }
    }
}
