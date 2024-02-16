# JavaFuturesDemo
A project that demonstrates how to use Java Futures

# Use cases

There are two use cases. The first is a travel use case that runs Hotel, Airline and Car Rental reservations in 
parallel.

![futures-travel-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/2b49ce70-e003-4f31-b9cb-8007816da47a)


The second use case a commerce scenario the gets an order and then pays for the order, ships the order, delivers the 
order and then finally confirms the order.

![futures-commerce-01](https://github.com/reselbob/JavaFuturesDemo/assets/1110569/fe74af89-2319-46c5-9d82-419e2fd9d28e)


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
.
.
.
Start time: 2024-02-16 11:52:26
Booking hotel, airline, and car rental reservations in parallel using CompletableFuture.

Airline booking started at: 2024-02-16 11:52:26
Hotel booking started at: 2024-02-16 11:52:26
CarRental booking started at: 2024-02-16 11:52:26
Airline booking ended at: 2024-02-16 11:52:28 and took 2 seconds.
CarRental booking ended at: 2024-02-16 11:52:31 and took 5 seconds.
Hotel booking ended at: 2024-02-16 11:52:36 and took 10 seconds.

Confirmations:

Confirmation id: 6cbe60a7-1897-454a-9573-27c0dc146519 message: Hotel booking completed business type: hotel
Confirmation id: cf0bba9f-b944-428e-93ec-1208819b7570 message: Airline booking completed business type: airline
Confirmation id: d9541bae-89ca-423f-bd7b-7e58d6490977 message: CarRental booking completed business type: car rental
End time: 2024-02-16 11:52:36
Total time: 10 seconds
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.252 s
[INFO] Finished at: 2024-02-16T11:52:36-08:00
[INFO] ------------------------------------------------------------------------

```

## Running the Sequential Futures use case:

Execute the following code in a terminal window to run the Commerce use case code:

```bash
mvn exec:java -Dexec.mainClass="futuresdemo.CommerceProgram"
```

You'll get output similar to the following:

```text
.
.
.
Start time: 2024-02-16 11:58:57
Running a business process

Order: 6f5f7f7c-e5f2-4704-82dc-07fb5a2a13b0 is pending
Order: 6f5f7f7c-e5f2-4704-82dc-07fb5a2a13b0 is paid at 2024-02-16 11:59:00
Order: 6f5f7f7c-e5f2-4704-82dc-07fb5a2a13b0 is shipped at 2024-02-16 11:59:03
Order: 6f5f7f7c-e5f2-4704-82dc-07fb5a2a13b0 is delivered at 2024-02-16 11:59:07
Order: 6f5f7f7c-e5f2-4704-82dc-07fb5a2a13b0 is confirmed at 2024-02-16 11:59:12
End time: 2024-02-16 11:59:12
Total time: 15 seconds
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.376 s
[INFO] Finished at: 2024-02-16T11:59:12-08:00
[INFO] ------------------------------------------------------------------------
```
