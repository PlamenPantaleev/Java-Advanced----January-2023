package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timesOfInput = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> nestedMap = new LinkedHashMap<>();

        for (int i = 0; i < timesOfInput; i++) {
            String [] currentInput = scanner.nextLine().split("\\s+");
            String continent = currentInput[0];
            String country = currentInput[1];
            String city = currentInput[2];

            if (!nestedMap.containsKey(continent)) {
                nestedMap.put(continent, new LinkedHashMap<>());
                nestedMap.get(continent).put(country, new ArrayList<>());
                nestedMap.get(continent).get(country).add(city);
            } else {
                if (!nestedMap.get(continent).containsKey(country)) {
                    nestedMap.get(continent).put(country, new ArrayList<>());
                    nestedMap.get(continent).get(country).add(city);
                } else {
                    nestedMap.get(continent).get(country).add(city);
                }
            }
        }
        for(Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : nestedMap.entrySet()) {
            String continent = entry.getKey();
            System.out.println(continent + ":");

            for (String country : entry.getValue().keySet()) {
                int numberOfCities = entry.getValue().get(country).size();
                System.out.print(country + " -> ");
                for (int i = 0; i < numberOfCities; i++) {
                    if (i == numberOfCities - 1) {
                        System.out.print(entry.getValue().get(country).get(i));
                    } else {
                        System.out.print(entry.getValue().get(country).get(i) + ", ");
                    }
                }
                System.out.println();
            }
        }
    }
}
