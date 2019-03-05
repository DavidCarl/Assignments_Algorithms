package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;

import java.util.NoSuchElementException;

public class PriorityQueueImplementation implements PriorityQueue<Passenger> {

    private Passenger[] items;
    private int size = 0;

    public PriorityQueueImplementation(int capacity) {
        this.items = new Passenger[capacity];
    }

    @Override
    public void enqueue(Passenger item) {
        if(items.length == size){
            throw new IllegalStateException("Cannot add to full queue");
        }
        items[size] = item;
        size++;
        heapify();
    }

    private void heapify() {
//        TODO WRITE SOME CODE HERE
    }

    @Override
    public Passenger dequeue() {
        if(size == 0){
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
//        TODO WRITE SOME CODE HERE
        return null;
    }

    @Override
    public Passenger peek() {
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        return items[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
