# JavaFuturesDemo
A project that demonstrates how to use Java Futures

# Use cases

There are two use cases. The first is a travel use case that runs Hotel, Airline and Car Rental reservations in 
parallel.

![travel-sequence-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/a5d4c8f0-7ed2-4a5d-9491-e68dc30a043c)



The second use case is a commerce scenario that runs futures in two sequential styles. The first style is to run the activities in the use case as a sequence of blocking `CompletableFuture<T>`s.

![sequence-commerce-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/f5b698a4-8454-4dc0-862e-97d1cf5f4d7d)


The second style runs the activites a a chain of blocking `CompletableFuture<T>`s.

![chained-commerce-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/16f8726a-6eaa-44a5-8d3a-54c10e71469f)


In both styles, the sequence of futures gets an order and then pays for the order, ships the order, delivers the order and then finally confirms the order.


# Getting the code up and running

The project is Java code that runs in the Maven framework.

**Step 1:**  Confirm Java is installed.

```bash
java -version
```

You'll get output similar to the following. If not, [install the Java SDK](https://openjdk.org/install/).

```text
openjdk version "21" 2023-09-19
OpenJDK Runtime Environment (build 21+35-2513)
OpenJDK 64-Bit Server VM (build 21+35-2513, mixed mode, sharing)

```

---

**Step 2:** Confirm Maven is installed on your host machine

```bash
mvn --version
```

You'll get output similar to the following. If not, [install Maven](https://maven.apache.org/install.html).

```
Maven home: /usr/share/maven
Java version: 18.0.2, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-18.0.2
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.19.0-46-generic", arch: "amd64", family: "unix"
```

---

**Step 3:** Do some Maven housecleaning

Run the following command in a terminal window to create a fresh Maven application environment:
```bash
mvn clean package install
```

## Running the Parallel Futures use case

Execute the following code in a terminal window to run the Travel use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.TravelProgram"
```

You'll get output similar to the following:

```text
Start time: 2024-02-19 16:56:45
Booking hotel, airline, and car rental reservations in parallel using CompletableFuture.

Airline booking started at: 2024-02-19 16:56:45
Hotel booking started at: 2024-02-19 16:56:45
CarRental booking started at: 2024-02-19 16:56:45
Airline booking ended at: 2024-02-19 16:56:47 and took 2 seconds.
CarRental booking ended at: 2024-02-19 16:56:50 and took 5 seconds.
Hotel booking ended at: 2024-02-19 16:56:55 and took 10 seconds.

Confirmations:

Confirmation id: 407e624c-bca5-498d-84a8-b3a611b78951 message: Hotel booking completed business type: hotel
Confirmation id: b94b3606-a009-41b9-8ca5-43f4e6cb019c message: Airline booking completed business type: airline
Confirmation id: 7ccd20cb-ba9f-4e6e-903f-686522c974a7 message: CarRental booking completed business type: car rental
End time: 2024-02-19 16:56:55
Total time: 10 seconds
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.277 s
[INFO] Finished at: 2024-02-19T16:56:55-08:00
[INFO] ------------------------------------------------------------------------
```

## Running the Sequential CompletableFutures use case:

Execute the following code in a terminal window to run the Commerce use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.SequenceCommerceProgram"
```

You'll get output similar to the following:

```text
Start time: 2024-02-19 16:55:41
Running a sequential business process

Dispatcher started at 2024-02-19 16:55:41
Shipped: Order 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5, ended at 2024-02-19 16:55:42 and took 1 seconds
Order: 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5 is pending
Payment started at 2024-02-19 16:55:42
Shipped: Order 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5, ended at 2024-02-19 16:55:44 and took 2 seconds
Order: 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5 is paid
Shipper started at 2024-02-19 16:55:44
Shipped: Order 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5, ended at 2024-02-19 16:55:47 and took 3 seconds
Order: 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5 is shipped
Delivery started at 2024-02-19 16:55:47
Shipped: Order 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5, ended at 2024-02-19 16:55:57 and took 10 seconds
Order: 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5 is delivered
Confirmation started at 2024-02-19 16:55:57
Shipped: Order 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5, ended at 2024-02-19 16:55:58 and took 1 seconds
Order: 7db49d8c-badc-4663-99d1-dcc7c2ef2bf5 is confirmed
End time: 2024-02-19 16:55:58
Total time: 17 seconds
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.389 s
[INFO] Finished at: 2024-02-19T16:55:58-08:00
[INFO] ------------------------------------------------------------------------
```

## Running the Chained Sequential CompletableFutures use case:

Execute the following code in a terminal window to run the Chained Commerce use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.ChainedCommerceProgram"
```

You'll get output similar to the following:

```text
Start time: 2024-02-19 16:54:48
Running a chained business process

Dispatcher started at 2024-02-19 16:54:48
Shipped: Order 6033774c-d34b-42e3-9575-3cf597dbfc9b, ended at 2024-02-19 16:54:49 and took 1 seconds
Order: 6033774c-d34b-42e3-9575-3cf597dbfc9b is pending
Payment started at 2024-02-19 16:54:49
Shipped: Order 6033774c-d34b-42e3-9575-3cf597dbfc9b, ended at 2024-02-19 16:54:51 and took 2 seconds
Order: 6033774c-d34b-42e3-9575-3cf597dbfc9b is paid at 2024-02-19 16:54:51
Shipper started at 2024-02-19 16:54:51
Shipped: Order 6033774c-d34b-42e3-9575-3cf597dbfc9b, ended at 2024-02-19 16:54:54 and took 3 seconds
Order: 6033774c-d34b-42e3-9575-3cf597dbfc9b is shipped at 2024-02-19 16:54:54
Delivery started at 2024-02-19 16:54:54
Shipped: Order 6033774c-d34b-42e3-9575-3cf597dbfc9b, ended at 2024-02-19 16:55:04 and took 10 seconds
Order: 6033774c-d34b-42e3-9575-3cf597dbfc9b is delivered at 2024-02-19 16:55:05
Confirmation started at 2024-02-19 16:55:05
Shipped: Order 6033774c-d34b-42e3-9575-3cf597dbfc9b, ended at 2024-02-19 16:55:06 and took 1 seconds
Order: 6033774c-d34b-42e3-9575-3cf597dbfc9b is confirmed at 2024-02-19 16:55:06
End time: 2024-02-19 16:55:06
Total time: 17 seconds
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.495 s
[INFO] Finished at: 2024-02-19T16:55:06-08:00
[INFO] ------------------------------------------------------------------------
```
