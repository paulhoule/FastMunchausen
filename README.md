This project is based on the code at [SpeedTest](https://github.com/jabbalaci/SpeedTests) which compares the speed of a simple task, computing the set of [Munchausen numbers](https://mathworld.wolfram.com/MuenchhausenNumber.html) in base 10, across a large number of programming languages.  Their programs were faster in some programming languages than others but it seemed to me that the algorithm they were using was inefficient,  doing a lot of division to take numbers apart and then adding up all the values for all of the digits for every number whereas most of the time just one digit (and one value) changes when we add one to a number.  [DeepLoop](https://github.com/paulhoule/FastMunchausen/blob/main/src/main/java/DeepLoop.java) is about 7.2 times as fast as [Original](https://github.com/paulhoule/FastMunchausen/blob/main/src/main/java/Original.java) when implemented in Java.

Original

```
Benchmarking class Original
0
1
3435
438579088

Pass 0 Elapsed time 2776 ms
Pass 1 Elapsed time 2609 ms
Pass 2 Elapsed time 2599 ms
Pass 3 Elapsed time 2602 ms
Pass 4 Elapsed time 2609 ms

Average elapsed time = 2639.0 ms
```

DeepLoop
```
Benchmarking class DeepLoop
0
1
3435
438579088

Pass 0 Elapsed time 155 ms
Pass 1 Elapsed time 524 ms
Pass 2 Elapsed time 384 ms
Pass 3 Elapsed time 383 ms
Pass 4 Elapsed time 392 ms

Average elapsed time = 367.6 ms
```
