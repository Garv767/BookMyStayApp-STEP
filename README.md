# BookMyStayApp - Hotel Booking System

A robust, console-based Java application that simulates a real-world hotel booking system. This project was built progressively through a series of use cases to demonstrate core Java concepts, Object-Oriented Programming (OOP) principles, design patterns, and system design.

## 🚀 Features & Use Cases Implemented

This system evolved through multiple phases, starting from basic bootstrapping to a fully concurrent and persistent application. 

**Foundational Features (UC1 - UC5):**
* **Application Entry Point (UC1):** Bootstrapped the project and implemented the main entry point for the application.
* **Room Initialization (UC2):** Defined the core `Room` entities (`SingleRoom`, `DoubleRoom`, `SuiteRoom`) establishing the class hierarchy.
* **Inventory Management (UC3):** Implemented the `RoomInventory` to act as the single source of truth for hotel room counts.
* **Room Search & Availability Check (UC4):** Provided read-only search functionality to view available rooms and their details.
* **Booking Request (UC5):** Introduced the `Reservation` class to capture early guest booking intent.

**Advanced Features (UC6 - UC12):**
* **Room Allocation & Queueing (UC6):** Processes booking requests using a First-In-First-Out (FIFO) queue (`LinkedList`) to ensure fairness when guests book rooms.
* **Add-On Services (UC7):** Allows guests to customize their stay with dynamic add-ons (like WiFi and Breakfast) using the **Decorator Design Pattern**.
* **Booking History & Reporting (UC8):** Maintains a comprehensive history of all transactions and generates a summary report of `CONFIRMED`, `CANCELLED`, and `FAILED` bookings.
* **Error Handling & Validation (UC9):** Ensures data integrity by rejecting malformed booking requests (e.g., missing names or room types) using custom exceptions (`InvalidReservationException`).
* **Cancellation & Inventory Rollback (UC10):** Allows guests to cancel confirmed bookings, automatically updating the reservation status and returning the room back to the available inventory.
* **Concurrent Booking Simulation (UC11):** Handles high-traffic scenarios where multiple booking agents attempt to book the same limited rooms simultaneously, utilizing **Multithreading** and synchronization to prevent race conditions.
* **Data Persistence & System Recovery (UC12):** Saves application state (bookings and inventory) to a file upon exit and successfully restores it on startup using Java **Serialization**.

## 🛠️ Technical Stack & Concepts Applied

* **Language:** Java
* **Core Concepts:**
    * Object-Oriented Programming (Inheritance, Polymorphism, Encapsulation, Abstraction)
    * Collections Framework (`Queue`, `List`, `Map`)
    * Exception Handling (Custom Checked Exceptions)
    * Multithreading (`Runnable` interface, `synchronized` keyword, `Thread.join()`)
    * File I/O & Serialization (`ObjectOutputStream`, `ObjectInputStream`, `Serializable`)
* **Design Patterns:** Decorator Pattern, Single Responsibility Principle (Service Classes)

## 📁 Project Structure

The repository contains the following active Java files:

**Core Entities & Models:**
* `Room.java` / `SingleRoom`, `DoubleRoom`, `SuiteRoom`: Represents room entities.
* `Reservation.java`: Holds guest details, ID, and booking status.
* `RoomInventory.java`: Thread-safe manager for room availability.
* `BookingRequestQueue.java`: Thread-safe FIFO queue for incoming reservations.
* `BookingHistory.java`: Stores all processed reservations for reporting.

**Business Logic (Services):**
* `BookingAllocationService.java`: Processes the queue and allocates rooms.
* `BookingCancellationService.java`: Handles booking cancellations and rollbacks.
* `DataPersistenceService.java`: Manages saving and loading state to `hotel_bookings.ser`.

**Add-ons (Decorators):**
* `RoomAddOn.java`, `WiFiAddOn.java`, `BreakfastAddOn.java`: Dynamically adds features and costs to base rooms.

**Concurrency & Exceptions:**
* `BookingAgent.java`: A `Runnable` class simulating parallel booking attempts.
* `InvalidReservationException.java`: Custom exception for bad inputs.
* `BookingCancellationException.java`: Custom exception for invalid cancellations.

**Main Runner:**
* `HotelBookingApp.java`: The central entry point orchestrating all the components and demonstrating the use cases.

## 💻 How to Run the Project

1. **Clone the repository:**
   ```bash
   git clone <your-repository-url>
   cd BookMyStayApp
   ```
2. **Compile the Java files:**
  Ensure you have the Java Development Kit (JDK) installed.
   ```bash
   javac *.java
   ```
3. **Run the application:**
    ```bash
    java HotelBookingApp
    ```

> **Note:** Upon running for the first time, it will create a `hotel_bookings.ser` file in the same directory to store data. Subsequent runs will read from this file.
    
   
