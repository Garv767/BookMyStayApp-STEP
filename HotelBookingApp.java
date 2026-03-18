/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC6-UC8, plus UC9 (Error Handling & Validation).
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        BookingHistory bookingHistory = new BookingHistory(); 
        BookingAllocationService allocationService = new BookingAllocationService(bookingHistory);

        System.out.println("\nUC9: Capturing Booking Requests with Validation");

        // Valid and Invalid requests wrapped in a helper method or try-catch block
        attemptBooking(bookingQueue, "Abhi", "Single Room");
        attemptBooking(bookingQueue, "Subha", "Double Room");
        
        // Simulating Invalid Inputs (UC9 Error Handling)
        attemptBooking(bookingQueue, "", "Suite Room");          // Fails: Empty Name
        attemptBooking(bookingQueue, "Karthik", null);           // Fails: Null Room Type
        
        attemptBooking(bookingQueue, "Vanmathi", "Suite Room");
        attemptBooking(bookingQueue, "Priya", "Suite Room"); 

        // Process all valid bookings
        allocationService.processBookings(bookingQueue, inventory);

        // --- UC7 Demonstration: Add-On Services ---
        System.out.println("\nUC7: Guest Customizing a Room with Add-ons");
        Room myRoom = new DoubleRoom();
        myRoom = new WiFiAddOn(myRoom);
        myRoom = new BreakfastAddOn(myRoom);
        myRoom.displayRoomDetails();

        // --- UC8 Demonstration: Booking History & Reporting ---
        bookingHistory.displayReport();
    }

    /**
     * Helper method to demonstrate try-catch exception handling for UC9.
     */
    private static void attemptBooking(BookingRequestQueue queue, String guestName, String roomType) {
        try {
            Reservation reservation = new Reservation(guestName, roomType);
            queue.addRequest(reservation);
            System.out.println("Queued successfully: " + guestName + " for a " + roomType);
        } catch (InvalidReservationException e) {
            // Gracefully catch the error without crashing the application
            System.err.println("ERROR adding to queue: " + e.getMessage());
        }
    }
}