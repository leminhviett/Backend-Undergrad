# 1.0

-   each time a HTTP req & res happens, TCP conn is openned & closed -> extremely slow
-   Buffering the data before sending it
-   (invented when RAM is low)

# 1.1

-   Persisted conn: TCP conn keep alived for some time. Yet, still only 1 req & res at a time.
-   Streaming
-   Pipelining (disabled by default): multiple req can be sent before res come back. The response coming back need to be in order. Hence, it is hard to implement in server.

# 2

**Pros**

-   mutiplexing. Unlike pipelining, responses can come back in any order with the help of stream id [Compare with pipelining](https://stackoverflow.com/questions/34478967/what-is-the-difference-between-http-1-1-pipelining-and-http-2-multiplexing)
-   Secure by def
-   Compression (headers & data) thanks to stream id
-   server push. (intelligent response back with related resources)
-   Can be negotiated to use this ver 2 over TLS

**Cons**

-   Server push overwhelm network if not done correctly
-   Mixing of LB in H1 & server H2 is slower (waste for nothing)
