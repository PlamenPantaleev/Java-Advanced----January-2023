package JavaAdvancedLab.Generics.Jar;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {

    private List<T> items;

    public Jar() {
        this.items = new ArrayList<>();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public void remove() {
        if (this.items.isEmpty()) {
            throw new RuntimeException("Jar is empty");
        }
        this.items.remove(items.size() - 1);
    }
}
