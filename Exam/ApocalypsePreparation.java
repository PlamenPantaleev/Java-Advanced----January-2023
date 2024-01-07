import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();

        Map<String, Integer> goods = new TreeMap<>();
        goods.put("Patch", 0);
        goods.put("Bandage", 0);
        goods.put("MedKit", 0);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(medicaments::push);

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currentTextile = textiles.peek();
            int currentMedicament = medicaments.peek();
            int sum = currentTextile + currentMedicament;

            if (sum == 30) {
                goods.put("Patch", goods.get("Patch") + 1);
                textiles.poll();
                medicaments.pop();
            } else if (sum == 40) {
                goods.put("Bandage", goods.get("Bandage") + 1);
                textiles.poll();
                medicaments.pop();
            } else if (sum == 100) {
                goods.put("MedKit", goods.get("MedKit") + 1);
                textiles.poll();
                medicaments.pop();
            } else {
                if (sum > 100) {
                    goods.put("MedKit", goods.get("MedKit") + 1);
                    textiles.poll();
                    medicaments.pop();
                    int sumToAdd = sum - 100;
                    int medicamentToUpgrade = medicaments.pop() + sumToAdd;
                    medicaments.push(medicamentToUpgrade);
                } else {
                    textiles.poll();
                    medicaments.pop();
                    currentMedicament = currentMedicament + 10;
                    medicaments.push(currentMedicament);
                }
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else {
            if (textiles.isEmpty()) {
                System.out.println("Textiles are empty.");
            } else {
                System.out.println("Medicaments are empty.");
            }
        }

        List<Integer> v = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : goods.entrySet()) {
            v.add(entry.getValue());
        }
        Collections.sort(v);
        Collections.reverse(v);
        while (!goods.isEmpty()) {
            for (Map.Entry<String, Integer> entry : goods.entrySet()) {
                if (entry.getValue().equals(v.get(0))) {
                    if (entry.getValue() == 0) {
                        goods.remove(entry.getKey());
                        v.remove(0);
                        break;
                    }
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    goods.remove(entry.getKey());
                    v.remove(0);
                    break;
                }
            }
        }
        if (!medicaments.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Medicaments left: ");
            int turns = medicaments.size();
            for (int i = 0; i < turns; i++) {
                if (i == turns - 1) {
                    sb.append(medicaments.pop());
                } else {
                    sb.append(medicaments.pop()).append(", ");
                }
            }
            System.out.println(sb);
        }
        if (!textiles.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Textiles left: ");
            int turns = textiles.size();
            for (int i = 0; i < turns; i++) {
                if (i == turns - 1) {
                    sb.append(textiles.poll());
                } else {
                    sb.append(textiles.poll()).append(", ");
                }
            }
            System.out.println(sb);
        }
    }
}
