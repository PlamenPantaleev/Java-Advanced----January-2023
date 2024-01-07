package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();

    }

    public boolean addChild(Child child) {
        if (this.capacity > this.registry.size()) {
            return this.registry.add(child);
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName) {
        Child child = this.registry.stream().filter(c -> c.getFirstName().equals(firstName))
                .findFirst().orElse(null);

        return this.registry.remove(child);
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream().filter(c -> c.getFirstName().equals(firstName))
                .findFirst().get();
    }

    public String registryReport() {
        Collections.sort(registry,
                Comparator.comparing(Child::getFirstName)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName));

        StringBuilder report = new StringBuilder();
        report.append(String.format("Registered children in %s:", this.name));
        report.append(System.lineSeparator());

        for (Child child : this.registry) {
            report.append("--").append(System.lineSeparator());
            report.append(child.toString());
            report.append(System.lineSeparator());
        }
        report.deleteCharAt(report.length() - 1);
        return report.toString();
    }

}
