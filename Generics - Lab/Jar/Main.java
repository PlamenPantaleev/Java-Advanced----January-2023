package JavaAdvancedLab.Generics.Jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jar<String> jar = new Jar<>();

        jar.addItem("String");
        jar.addItem("Integer");
        jar.addItem("Double");

        jar.remove();
        jar.remove();
        jar.remove();
        jar.remove();
        System.out.println();
    }
}
