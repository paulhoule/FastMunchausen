This project is based on the code at https://github.com/jabbalaci/SpeedTests which compares the speed of a simple task across a large number of programming languages.  It seemed to me that that algorithm being used wasn't very efficient so I coded up the implementation of DeepLoop which is much more complex program that
runs much faster.

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
