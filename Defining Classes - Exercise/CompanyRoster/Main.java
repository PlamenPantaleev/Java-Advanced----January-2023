package JavaAdvancedExercise.DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departmentHashMap = new HashMap<>();
        for (int i = 1; i <= numberOfInputs; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            Employee employee = null;
            if (input.length == 6) {
                employee = getEmployee(input);
            } else if (input.length == 5) {
                employee = getEmployee(input);
            } else {
                employee = getEmployee(input);
            }

            if (!departmentHashMap.containsKey(input[3])) {
                departmentHashMap.put(input[3], new Department(input[3]));
            }
            departmentHashMap.get(input[3]).getEmployees().add(employee);
        }
        Department maxSalary = departmentHashMap.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.printf("Highest Average Salary: %s%n", maxSalary.getName());
        maxSalary.getEmployees().stream().sorted((e1, e2) ->Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }

    private static Employee getEmployee(String[] input) {
        if (input.length == 6) {
            return new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5]));
        } else if (input.length == 5) {
            if (input[4].length() > 3) {
                return new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4]);
            } else {
                return new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], Integer.parseInt(input[4]));
            }
        } else {
            return new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);
        }
    }
}
