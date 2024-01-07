import java.util.Scanner;

public class BlindManBluff {
    private static String [][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        
        matrix = new String[rows][cols];
        fillMatrix(scanner);

        int [] coordinates = findPlayer();
        int playerRow = coordinates[0];
        int playerCol = coordinates[1];

        int touchedOpponents = 0;
        int moves = 0;
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            matrix[playerRow][playerCol] = "-";
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow++;
                    } else {
                        String currentPosition = matrix[playerRow][playerCol];
                        if (currentPosition.equals("P")) {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                            touchedOpponents++;
                        } else if (currentPosition.equals("O")) {
                            playerRow++;
                        } else {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                        }
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= matrix.length) {
                        playerRow--;
                    } else {
                        String currentPosition = matrix[playerRow][playerCol];
                        if (currentPosition.equals("P")) {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                            touchedOpponents++;
                        } else if (currentPosition.equals("O")) {
                            playerRow--;
                        } else {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                        }
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol++;
                    } else {
                        String currentPosition = matrix[playerRow][playerCol];
                        if (currentPosition.equals("P")) {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                            touchedOpponents++;
                        } else if (currentPosition.equals("O")) {
                            playerCol++;
                        } else {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                        }
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= matrix[0].length) {
                        playerCol--;
                    } else {
                        String currentPosition = matrix[playerRow][playerCol];
                        if (currentPosition.equals("P")) {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                            touchedOpponents++;
                        } else if (currentPosition.equals("O")) {
                            playerCol--;
                        } else {
                            matrix[playerRow][playerCol] = "B";
                            moves++;
                        }
                    }
                    break;
            }
            if (touchedOpponents == 3) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);
    }

    private static int[] findPlayer() {
        int[] c = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    c[0] = row;
                    c[1] = col;
                    break;
                }
            }
        }
        return c;
    }

    private static void fillMatrix(Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String [] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
    }
}
