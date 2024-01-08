package StackIterator;

import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {
    private final int STACK_STARTING_SIZE = 4;

    private int[] elements;
    private int index;
    private int lastIndex;

    public StackIterator() {
        this.elements = new int[STACK_STARTING_SIZE];
        this.index = 0;
    }


    public void push(int element) {
        if (this.elements[elements.length - 1] != 0) {
            extendStack();
        }
        this.elements[index] = element;
        lastIndex = index;
        index++;
    }

    public int pop() {
        if (lastIndex < 0) {
            throw new ArrayStoreException("No elements");
        }
        int number = elements[lastIndex];
        removeLast();
        return number;
    }

    private void removeLast() {
        elements[lastIndex] = Integer.MIN_VALUE;
        lastIndex--;
    }

    private void extendStack() {
        int[] newStack = new int[elements.length + STACK_STARTING_SIZE];

        for (int i = 0; i < this.elements.length; i++) {
            newStack[i] = elements[i];
        }

        this.elements = newStack;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterating();
    }

    public class Iterating implements Iterator<Integer> {
        int counter = lastIndex;

        @Override
        public boolean hasNext() {
            return counter >= 0 && elements[counter] != 0;
        }

        @Override
        public Integer next() {
            return elements[counter--];
        }
    }
}
