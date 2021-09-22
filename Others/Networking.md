# What happens when type google.com into your browser address box and hit enter?

1. Parsing what type in search bar?
    1. Search term ?
    2. Url ? (Focus on this)
2. Protocols ? (if user not specified, it depends on browser config/ or server config)
    1. HTTP (port 80)
    2. HTTPS (port 443)
3. DNS look up (for IP address)
    1. In cache (of browser or OS)
    2. Not in cache: first communication to outside world, a datagram will be sent via **UDP protocol** to DNS; this package can be encrypted (DoH, DoT) or not.
        1. DNS can configured (to Google, Cloudfare, ...). Default is ISP.
        2. DNS will recursively ask other servers to get the answer for us
4. TCP connection

    1. Establishment by 3 way handshake

        1. First send a _SYNC/SEQ_NO(client)_ package to server
        2. The server respond with ACK/next expected SEQ_NO (client) and SYNC/SEQ_NO(server)
        3. The client respond with ACK/next expected SEQ_NO (server)

        The SEQ_NO init number is arbitrary to eliminate securtiy risk. SEQ_NO is to synchronize package sequence number between 2 ends.

    2. Termination by 4 way handshake
        1. SYN/FIN (client -> server)
        2. ACK/FIN (server -> client)
        3. SYN/FIN (server -> client)
        4. ACK/FIN (client -> server)

5. TLS handshake

    1. Client Hello.
        1. Client support algo, TLS version, cypher suite, ...
    2. Server Hello.
        1. Agree on TLS version & cypher suite.
        2. Sever certificate & public key
        3. Session ID
    3. Client:
        1. verify server cert.
        2. send back session shared key (encrypted by server public key)
        3. send finished message (encrypted by session shared key)
    4. Server decrypte it & get the key. Then send finished message (encrypted by session shared key)

6. First GET/ index.html. (It will go through all the layers & sent to server)
7. Respond HTML file & client will parse & display it (query more if necessary)

# TCP/IP & OSI model

| TCP/IP models | OSI models   | data units                       |
| ------------- | ------------ | -------------------------------- |
| Application   | Application  | Data                             |
|               | Presentation |                                  |
|               | Session      |                                  |
| Transport     | Transport    | Segments (TCP)<br>Datagram (UDP) |
| Internet      | Network      | Packet                           |
| Data link     | Data link    | Frames                           |
| Physical      | Physical     | Bits                             |

-   Application layer:
    -   facilitate network application (i.e: Chrome, Outlook, Spotify, ...) to work properly
    -   protocols: https, ftp, ...
-   Presentation layer:
    -   manipulate data from above layer:
        -   translation
        -   compression
        -   encryption
-   Session layer: (difference between this vs transport layer)
    -   Session management
    -   Authentication
    -   Popularly, implemented using JWT or cookies in practice
    -   To differentiate from transport layer, one session can be using 1 or many TCP connections
-   Transport layer (from process-to-process):
    -   Segmentation: divides data into smaller units; then encapsulate each with PORT no & sequence no (in case of TCP only)
    -   Flow & congestion control
    -   Error control
    -   Connection(less) oriented protocol: TCP (UDP)

|                                                                               TCP                                                                                |                                           UDP                                           |
| :--------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------: |
| connection-oriented protocol<br>Need/ have:<br>opening connection: 3-way handshake<br>Closing connection: 4-way handshake<br>Acknowledgment of message delivered |                                 connectionless protocol                                 |
|                                                                      Surely, data delivered                                                                      |                                      Not reliable                                       |
|                                                                     Extensive error checking                                                                     |                                  Basic error checking                                   |
|                                                                   Ordered transmission packets                                                                   |                                 Order is not guaranteed                                 |
|                                                                      Retransmission support                                                                      |                               Retransmission not support                                |
|                                                                              Faster                                                                              |                                         Slower                                          |
|                                                  Suitable for transferring large files, need reliable delivery.                                                  | Suitable for transferring small amounts of data, such as broadcasting, video games, ... |

-   Network layer (from host-to-host, which might be in different network):

    -   IP addressing: Encapsulate with IP address -> packet
    -   Routing: determine path to route packets inside Internet

-   Datalink layer (from nodes-to-nodes, which are in the same network):
    -   Framing:
        -   frames = header (contains MAC address) + packet + trailer (error checksum)
    -   Control how data is put/take into/from media device:
        -   media access control
        -   error detection
-   Physical layer:
    -   convert packet (in Bits 1/0) into signal (electric/ light/ radio) then transmit

# Why SSL is needed

-   Secure communication (encrypt & decrypt message)
-   Authentication (server: compulsory, client: optional) - with the help of CA
-   Digital signature (non-repudation & intergrity of message)
    -   DS = Encrypt_by_secret_key( Hashed (Message))
    -   Hash be4 encrypttion using secret key is becz of size of hash is smaller
