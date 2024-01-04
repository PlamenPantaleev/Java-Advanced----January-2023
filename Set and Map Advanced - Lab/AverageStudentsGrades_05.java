package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timesOfInput = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < timesOfInput; i++) {
            String [] studentInfo = scanner.nextLine().split("\\s+");
            String studentName = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);

            if (studentGrades.containsKey(studentName)) {
                studentGrades.get(studentName).add(grade);
            } else {
                studentGrades.put(studentName, new ArrayList<>());
                studentGrades.get(studentName).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            String studentName = entry.getKey();
            int totalGrades = entry.getValue().size();
            double grades = 0;

            System.out.printf("%s -> ", studentName);
            for (int i = 0; i < totalGrades; i++) {
                System.out.printf("%.2f ", entry.getValue().get(i));
                grades = grades + entry.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)%n", grades / totalGrades);
        }
    }
}
