package Froggy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" |, ");
        List<Integer> oddNumber = new ArrayList<>();
        List<Integer> evenNumber = new ArrayList<>();


        Lake lake = new Lake();

        for (String s : input) {
            int num = Integer.parseInt(s);

            if (num % 2 == 0) {
                evenNumber.add(num);
            } else {
                oddNumber.add(num);
            }
        }

        lake.addNumbers(oddNumber);
        lake.addNumbers(evenNumber);

        for (int i = 0; i < lake.size(); i++) {
            if (i == lake.size() - 1) {
                System.out.println(lake.getNum(i));
                break;
            }
            System.out.print(lake.getNum(i) + ", ");
        }
    }
}
