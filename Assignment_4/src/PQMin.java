import java.util.NoSuchElementException;

public class PQMin <T extends Comparable> {

    FlexibleArray<T> pq = new FlexibleArray<T>(32);
    int head = 0;



    private void swim(int index){
        while (index > 1 && bigger(pq.get(index/2), pq.get(index))) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    private void sink(int index){
        while (2*index <= head) {
            int firstOrBiggest = index * 2;

            if( firstOrBiggest < head && bigger(pq.get(firstOrBiggest), pq.get(firstOrBiggest+1)) ) firstOrBiggest ++;
            if( bigger(pq.get(firstOrBiggest), pq.get(index)) ) break;

            swap(index, firstOrBiggest);
            index = firstOrBiggest;
        }
    }

    private void swap(int a, int b){
        T tmp = pq.get(a);
        pq.set(a, pq.get(b));
        pq.set(b, tmp);
    }

    public boolean bigger(T a, T b){
        return a.compareTo(b) > 0;
    }

    public void enqueue(T item) {
        pq.set(++head, item);
        swim(head);
    }

    public T dequeue() {
        T min = pq.get(1);

        swap(1, head--);
        pq.set(head + 1, null);
        sink(1);

        return min;
    }

    public T peek() {
        if (head == 0)
            throw new NoSuchElementException("Cannot peek into empty queue");
        return pq.get(1);

    }

    public int size() {
        return head;
    }
}
