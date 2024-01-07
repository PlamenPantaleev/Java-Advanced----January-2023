package SoftUniStudents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.size() > this.capacity) {
            return "The hall is full";
        }
        for (Student student1 : this.data) {
            if (student1.getFirstName().equals(student.getFirstName())
            && student1.getLastName().equals(student.getLastName())) {
                return "Student is already in the hall";
            }
        }
        this.data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        if (this.data.contains(student)) {
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        List<Student> collect = this.data.stream().filter(s -> s.getFirstName().equals(firstName) &&
                s.getLastName().equals(lastName)).collect(Collectors.toList());

        return collect.get(0);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", this.data.size()));
        for (Student student : this.data) {
            sb.append(System.lineSeparator());
            sb.append(student);
        }
        return sb.toString();
    }
}
