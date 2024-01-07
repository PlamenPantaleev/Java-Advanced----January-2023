package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        Animal animal = this.data.stream().filter(a -> a.getName().equals(name))
                .findFirst().orElse(null);

        return this.data.remove(animal);
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animal = this.data.stream().filter(a -> a.getName().equals(name)
                        && a.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);

        return animal;
    }

    public Animal getOldestAnimal() {
        int animalAge = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            int currentAge = this.data.get(i).getAge();
            if (animalAge < currentAge) {
                animalAge = currentAge;
                index = i;
            }
        }
        return this.data.get(index);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");

        for (Animal animal : this.data) {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", animal.getName(), animal.getCaretaker()));
        }
        return sb.toString();
    }
}
