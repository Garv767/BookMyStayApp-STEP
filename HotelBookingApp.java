import java.util.Map;

/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC6: Reservation Confirmation & Room Allocation
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - UC6 Initialization");

        // 1. Initialize Inventory and Queue
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // 2. Create booking requests (Simulating guests arriving)
        // Note: Inventory initially has 5 Single, 3 Double, and 2 Suite Rooms.
        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Double Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Karthik", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Priya", "Suite Room")); // This 3rd Suite request should fail

        // 3. Initialize the Allocation Service
        BookingAllocationService allocationService = new BookingAllocationService();

        // 4. Delegate the processing to the service
        allocationService.processBookings(bookingQueue, inventory);

        // 5. Display Final Inventory state
        System.out.println("\nFinal Room Inventory State");
        for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }
    }
}