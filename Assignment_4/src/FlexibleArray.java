
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlexibleArray<T> implements Iterable<T> {

    public T[] data;
    private int index = -1;

    public FlexibleArray(int i) {
        data = (T[]) new Object[i];
    }

    public T get(int getIndex) {
        try {
            return data[getIndex];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void set(int atIndex, T item) {
        if (atIndex < 0) {
            throw new IllegalArgumentException();
        }
        while (atIndex > data.length -1) {
            doubleTheSize();
        }
        data[atIndex] = item;
    }

    public int length() {
        return index + 1;
    }


    public void add(T i) {
        while (true) {
            int newIndex = ++index;
            if (newIndex >= data.length) {
                doubleTheSize();
            }
            if (data[newIndex] != null) {
                continue;
            }
            data[newIndex] = i;
            break;
        }

    }

    private void doubleTheSize() {
        T[] newArray = (T[]) new Object[data.length * 2];
        System.arraycopy(this.data, 0, newArray, 0, data.length);
        data = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i;

        public ArrayIterator() {
            i = 0;
        }

        public boolean hasNext() {
            return data.length > i && data[i] != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return data[i++];
        }
    }

}
