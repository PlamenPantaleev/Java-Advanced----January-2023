package JavaAdvancedLab.Generics.GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) == 0) {
            return null;
        } else if (left.compareTo(right) > 0) {
            return left;
        } else {
            return right;
        }
    }
}
