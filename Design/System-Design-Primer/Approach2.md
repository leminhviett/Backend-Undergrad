## Overview

1. Understand the problem
2. High-level design
3. Deep dive design
4. Wrap-up

## Details

### 1. Understand the problem

-   What are the features? Target users?
-   What are non-func requirements? Do some estimate calculation

    -   **Performance**: latency, response time, qps
    -   **Scalability**: how system handle in peak hours
    -   **Reliablity**: cosistency, availability

**To support the design latter**

-   QPS
-   Storage size, type of data
-   Consistency level (NoSQL vs SQL)

### 2. High-level design

-   List of APIs
-   High-level diagram:
    -   API GW/ load balancers
    -   Different services
    -   DB layer

### 3. Deep dive

-   DB schema
-   Only at this point, discuss about non-functional requirement

### random note

During peak hrs, response_time = 1s; qps can be 1k qps (successful, 100machines used). response_time = 1s; qps can be 10k qps (successful, 1000 machines used)

=> so high qps != low response time (qps increase but response time low)
