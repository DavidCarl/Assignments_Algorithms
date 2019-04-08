# Group StoogeSort

## Output of running this application
```
MAG 1825
MAS 1835
Conversion of data!
368.448986 ms

Depth First Search, Result:
true
160.963065 ms 

Breadth First Search, Result:
1835 to 1825 (1):  139.258631 ms

Dijkstra Distance, Result:
1835 to 1825 (393.72))  508.651779 ms
```

## What we have done

Since it said nowhere we had to implement all the different stuff ourself, we choose to make a Converter to the files the book use.
We then took the implementations from the code examples and ran with our converted data.

We came to the conclusion this was the most optimal way to do it.

## Timings

Its possible to see our timings in the output section of this readme file.

## Size of Graph Structure

Since we got 5653 airports, and we gotta go out of both axises, we need to take 5653 to the power of 2. We then get the following result `5653^2 bits = 31956409 bits = 3.99 mb`
