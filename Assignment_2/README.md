# Assignment 2
## Made By
### [Tjalfe Møller](https://www.github.com/alfen123)
### [Alexander Nielsen](https://www.github.com/cph-an178)
### [David Carl](https://www.github.com/davidcarl)

## Timings

### Things to know

We made acronyms for our different symbol tables, they are present here aswell as in the code.

 * LST =   LinkedSymbolTable
 * AST =   ArraySymbolTable
 * HST =   HashedSymbolTable
 * BTST =  BalancedTreeSymbolTable

### Results

We make a smaller filer to do this quicker, but our results are the following from a computer overclocked to 5Ghz

#### Small text file

 * LST: 971 millis (0.971 Seconds)
 * AST: 619 millis (0.619 seconds)
 * HST: 61 millis (0.061 seconds)
 * BTST: 14 millis (0.014 seconds)

#### Full length text file

 * LST: 12904 millis (12.904 Seconds)
 * AST: 10945 millis (10.945 seconds)
 * HST: 278 millis (0.278 seconds)
 * BTST: 89 millis (0.089 seconds)

### Our thoughts

A thing to take into consideration before reading further and to much into the results. Its important to think about the CPU being 'warmed' to the latter algorithms and can also help explain why it performs faster. Tho I would not take this as a sole reason for the time difference, just another factor.

So as you can see in the following timings, BTST is the fastest, we suspect the reason being that its being sorted as we go, so its easier to lookup words to see if its already existing or it should be added as new, where as in our other methods its completly unsorted and that requires our algorithm to loop over the whole list / array to see if it exist or not.

We have not performed a test where our list has been sorted first, even tho it could be a fun experiment as then we would likely see some other result, but it would put our BTST to a disadvantage as it would create a one side heavy tree.