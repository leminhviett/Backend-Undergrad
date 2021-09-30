# Fundamentals:

1. **Spin lock**
    - Def: any locking solutions require threads to do busy waiting when acquiring locks (i.e: test&set() hardware solutions)
    - Usage: mutual exclusion
    - Note:
        - Advantage:
        - Disadvanatage: waste CPU cycle for nothing
2. **Standard Mutex** (sleeping lock)

    - Def: when acquiring locks, threads will wait by go to sleep in a _thread-queue_. Runtime system will wake-up threads when the lock is ready
    - Usage: mutual exclusion
    - Note:
        - Advantage: Release CPU for other tasks
        - Disadvanatage: sleep & wake-up threads will require context switching, which needs CPU usage as well

    => So,if waiting time is short, spin lock is better; if waiting time is long, mutex is better

In Python, RLock is standard mutex

https://www.sciencedirect.com/topics/computer-science/waiting-thread

3. **Semaphores**

Compare between [Semaphores](https://blog.feabhas.com/2009/09/mutex-vs-semaphores-%E2%80%93-part-1-semaphores/) and [Mutex](https://blog.feabhas.com/2009/09/mutex-vs-semaphores-%e2%80%93-part-2-the-mutex/)

-   Def: a variable (binary/ counting semaphore) protected by a sleeping lock.

          Unlike lock/ mutex (point 1, 2), it doesn't have ownership, which means any threads can modify semaphores. That is why it is not used for mutual exclusion

    -   Usage: Signalling & synchronization
    -   Note:
        -   Advantage: As it removed concept of ownership, it can be used for synchronization purposes.
        -   Disadvanatage: Lacking of ownership also a problem of itself (that's why it is not used for mutual exclusion)
            -   acidentally incre() semaphore
            -   dead lock - due to death task or recursive call

[CV and monitors](https://people.eecs.berkeley.edu/~kubitron/courses/cs162-F10/hand-outs/synch.html)

1.  **Condition Variable**

    -   Def: a queue of threads waiting for some condition to be met. Condition states and the queue are both protected by a lock (standard lock in Python).

        Multiple condtion variables can share a same lock. But vice versa is not correct

    -   Usage: signalling & synchronization

        ```
        Initialization: Cv, states, Lock

        with Lock:
            while (some condition using states):
            Cv.wait() # enter critical region

                    # states might be changed here
                    cv.signal()
        ```

2.  **Monitors**
    Some condition variables with same lock
