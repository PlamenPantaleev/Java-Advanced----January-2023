package JavaAdvancedLab.SetsAndMapAdvanced;

import com.sun.source.tree.Tree;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            double [] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            studentsGrades.put(studentName, new ArrayList<>());

            for (int j = 0; j < grades.length; j++) {
                double currentGrade = grades[j];

                studentsGrades.get(studentName).add(currentGrade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : studentsGrades.entrySet()) {
            String studentName = entry.getKey();
            int totalGrades = entry.getValue().size();
            double totalGrade = 0;
            DecimalFormat format = new DecimalFormat("0.#########");
            for (int i = 0; i < totalGrades; i++) {
                double currentGrade = entry.getValue().get(i);
                totalGrade += currentGrade;
            }
            System.out.printf("%s is graduated with %s%n", studentName, format.format(totalGrade / totalGrades));
        }
    }
}
