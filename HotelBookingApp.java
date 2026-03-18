/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC11: Concurrent Booking Simulation alongside previous use cases.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        BookingHistory bookingHistory = new BookingHistory(); 
        
        BookingAllocationService allocationService = new BookingAllocationService(bookingHistory);

        // --- UC11 Demonstration: Concurrent Booking Simulation ---
        System.out.println("\nUC11: Simulating Concurrent Bookings");
        System.out.println("Scenario: 4 Agents trying to book 2 available Suite Rooms simultaneously.");

        // Create threads (agents) trying to book the exact same resource type
        Thread agent1 = new Thread(new BookingAgent("Agent_Alice", "Suite Room", bookingQueue, allocationService, inventory), "Thread-1");
        Thread agent2 = new Thread(new BookingAgent("Agent_Bob", "Suite Room", bookingQueue, allocationService, inventory), "Thread-2");
        Thread agent3 = new Thread(new BookingAgent("Agent_Charlie", "Suite Room", bookingQueue, allocationService, inventory), "Thread-3");
        Thread agent4 = new Thread(new BookingAgent("Agent_Diana", "Suite Room", bookingQueue, allocationService, inventory), "Thread-4");

        // Start threads concurrently
        agent1.start();
        agent2.start();
        agent3.start();
        agent4.start();

        // Wait for all threads to finish before continuing
        try {
            agent1.join();
            agent2.join();
            agent3.join();
            agent4.join();
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted.");
        }

        System.out.println("\nFinal Inventory State");
        System.out.println("Suite Rooms remaining: " + inventory.getRoomAvailability().get("Suite Room"));

        // --- UC8 Demonstration: Final Booking History ---
        bookingHistory.displayReport();
    }
}