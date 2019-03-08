package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;

import java.util.NoSuchElementException;

public class PriorityQueueImplementation<T extends Comparable<T>> implements PriorityQueue<T> {

    private Object[] items;
    private int size = 0;
    private int direction = -1;


    public PriorityQueueImplementation(int capacity) {
        this.items = new Object[capacity];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(((T) items[i]));
        }
    }

    @Override
    public void enqueue(T item) {
        if (items.length == size) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        items[size] = item;
        heapifyUp(size);
        size++;
    }


    private void heapifyUp(int n) {
        int p = parent(n);
        if (p < 0) return;
        if (((T) items[n]).compareTo((T) items[p]) * direction <= 0) return;
        swap(n, p);
        heapifyUp(p);
    }


    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        T result = (T) items[0];
        size--;
        items[0] = items[size];
        heapifyDown(0);
        return result;
    }

    private void heapifyDown(int n) {
        int l = left(n);
        int r = right(n);
        if (l > size - 1) return;

        int swp;
        if (r > size -1) swp = l;
        else swp = (((T) items[l]).compareTo((T) items[r]) * direction > 0) ? r : l;

        if (((T) items[n]).compareTo((T) items[swp]) * direction < 0) {
            swap(n, swp);
            heapifyDown(swp);
        }
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        return (T) items[0];
    }

    @Override
    public int size() {
        return size;
    }


    private void swap(int n, int m) {
        Object swp = items[n];
        items[n] = items[m];
        items[m] = swp;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i * 2) + 2;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return (i - 1) / 2;
        } else {
            return (i - 2) / 2;
        }
    }
}
