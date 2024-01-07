package sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.capacity > data.size()) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        Elephant elephant = this.data.stream().filter(h -> h.getName().equals(name))
                .findFirst().orElse(null);

        return this.data.remove(elephant);
    }

    public Elephant getElephant(String retiredFrom) {

        return this.data.stream().filter(h -> h.getRetiredFrom().equals(retiredFrom))
                .findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        int elephantAge = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < this.data.size(); i++) {
            int currentAge = this.data.get(i).getAge();

            if (elephantAge < currentAge) {
                elephantAge = currentAge;
                index = i;
            }
        }
        return this.data.get(index);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:");

        for (Elephant elephant : this.data) {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()));
        }

        return sb.toString();
    }
}
