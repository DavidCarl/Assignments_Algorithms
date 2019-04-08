package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueueImplementation;

public class QueueValidaterTesting {
    public static void main(String[] args) {
        PriorityQueue<Passenger> queue = new PriorityQueueImplementation(10000);
        Passenger p1 = new Passenger(1, new Time(43432), Category.BusinessClass, new Plane(new Time(876)));
        Passenger p2 = new Passenger(2, new Time(43432), Category.Monkey, new Plane(new Time(876)));
        Passenger p4 = new Passenger(4, new Time(43432), Category.Monkey, new Plane(new Time(876)));
        Passenger p3 = new Passenger(3, new Time(43432), Category.BusinessClass, new Plane(new Time(876)));
//        System.out.println(p2.compareTo(p1));
        queue.enqueue(p2);
        queue.enqueue(p1);
        queue.enqueue(p3);
        queue.enqueue(p3);
//        queue.enqueue(p4);
//        queue.enqueue(p3);

//        ((PriorityQueueImplementation<Passenger>) queue).print();
        while (true) {
            System.out.println(queue.dequeue());
        }
    }

}
