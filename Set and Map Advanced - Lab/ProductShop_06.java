package JavaAdvancedLab.SetsAndMapAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        TreeMap<String, List<String>> revisionForStores = new TreeMap<>();

        while (!command.equals("Revision")) {
            String [] storeInformation = command.split(", ");
            String storeName = storeInformation[0];
            String product = storeInformation[1];
            String productPrice = storeInformation[2];

            if (revisionForStores.containsKey(storeName)) {
                revisionForStores.get(storeName).add(product);
                revisionForStores.get(storeName).add(productPrice);
            } else {
                revisionForStores.put(storeName, new ArrayList<>());
                revisionForStores.get(storeName).add(product);
                revisionForStores.get(storeName).add(productPrice);
            }
            command = scanner.nextLine();

        }
        for (Map.Entry<String, List<String>> entry : revisionForStores.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i+=2) {
                double price = Double.parseDouble(entry.getValue().get(i + 1));
                System.out.printf("Product: %s, Price: %.1f%n", entry.getValue().get(i), price);
            }
        }
    }
}
