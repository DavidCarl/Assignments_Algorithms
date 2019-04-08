# Airport Priority Queue
Assignment 3 in Algorithms & Data structure course at CPH Business 2019. 

Made by: 
Tjalfe Møller, David Carl & Alexander Nielsen

## Task
Implement a priotitized queueing system for an airport. You can use any
priority queue algorithm, but you must be able to argue that the time complexity is no worse than *O(log n)* for enqueue and dequeue respectively.

Passenger priority is assumed to be derived from properties like passenger
category and arrival time (you decide the priority...):
- Late to flight - *1. priority*
- Business class - *2. priority*
- Disabled - *3. priority*
- Family - *4. priority*
- Monkey - *5. priority*

## Choice of algorithm
We decided to use `Heap` which means that our worse case time complexity for enqueue and dequeue is *O(log n)*.

|  Queue  | Time in seconds |
| ------- | --------------- |
| Dequeue | 0.000025        |
| Enqueue | 0.000016        |

This difference is because dequeue uses multiple comparisons.

In a real life case it would not make sense to change peoples queues. E.g. The last passenger in the queue would not be 
enqueued first in the queue when the previous passenger gets dequeued. For then only to move backwards in the queue again.

## How to run
1. Clone the project
2. Run main method in `Program.java`