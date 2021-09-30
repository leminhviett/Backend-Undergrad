1.  Entities ? APIs? Actions ? Services
2.  Work out the logic to do these things 1st
3.  Back of the envelop
    -   nums of users
    -   qps?
    -   size of db
    -   user gloablly/ regional
4.  High level design. Services? (should separate services (Read/Write), so that can scalable)
5.  Detail (DB scale, cache, load balancer)

# Components

1. Load balancers
    - how they communicate with each other to dertermine target server?
    - how service know which LB to call?
2. Web servers
3. Web services (separate different kind of service - Single responsibility, how )
    - Identify all API
    - API design
    - Async job
4. Databases (Scale read & write) (to read)
    - Schema design
    - Query logic
5. Caching (to read)

# CAP theorem

Idempotent queue https://www.codit.eu/blog/the-importance-of-idempotent-receivers/?country_sel=be

active-active/ active-passive

# Service registry

-   client & server discovery
-   self & 3rd party registration

# Nosql vs sql

-   less structured, faster to set up. Store also easier because do not need to care about rows 

*   lack of some features, release some ACID (+/-)

# Consistent hashing
- minimize data movement when rehashing when size of buckets change or hash function change
- identify hotspot then can break it down ez 