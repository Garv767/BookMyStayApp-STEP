/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC6 (Allocation), UC7 (Add-ons), and UC8 (Reporting).
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        // 1. Initialize core components
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        BookingHistory bookingHistory = new BookingHistory(); 

        // 2. Setup the allocation service with the history tracker
        BookingAllocationService allocationService = new BookingAllocationService(bookingHistory);

        // 3. Create sample booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Double Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Karthik", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Priya", "Suite Room")); // Should fail (only 2 suites exist)

        // 4. Process all bookings
        allocationService.processBookings(bookingQueue, inventory);

        // --- UC7 Demonstration: Add-On Services ---
        System.out.println("\nUC7: Guest Customizing a Room with Add-ons");
        Room myRoom = new DoubleRoom();
        myRoom = new WiFiAddOn(myRoom);
        myRoom = new BreakfastAddOn(myRoom);
        myRoom.displayRoomDetails();

        // --- UC8 Demonstration: Booking History & Reporting ---
        // 5. Display the final booking report
        bookingHistory.displayReport();
    }
}