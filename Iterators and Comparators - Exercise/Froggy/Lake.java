package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake() {
        this.numbers = new ArrayList<>();
    }

    public void addNumbers(List<Integer> inputNumbers) {
        numbers.addAll(inputNumbers);
    }

    public int size() {
        return numbers.size();
    }

    public int getNum(int index) {
        return numbers.get(index);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        private int startIndex = 0;

        @Override
        public boolean hasNext() {
            return startIndex < numbers.size();
        }

        @Override
        public Integer next() {
            return numbers.get(startIndex++);
        }
    }
}
