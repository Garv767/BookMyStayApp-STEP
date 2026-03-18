/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC6-UC10.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        BookingHistory bookingHistory = new BookingHistory(); 
        
        BookingAllocationService allocationService = new BookingAllocationService(bookingHistory);
        BookingCancellationService cancellationService = new BookingCancellationService(bookingHistory, inventory);

        System.out.println("\n=== Processing Initial Bookings ===");
        attemptBooking(bookingQueue, "Abhi", "Suite Room");
        attemptBooking(bookingQueue, "Subha", "Suite Room");
        attemptBooking(bookingQueue, "Karthik", "Suite Room"); // Fails, only 2 suites
        allocationService.processBookings(bookingQueue, inventory);

        // Capture a valid ID to test cancellation (Abhi should be 1001)
        int idToCancel = 1001; 

        // --- UC10 Demonstration: Cancellation & Rollback ---
        System.out.println("\nUC10: Booking Cancellation & Inventory Rollback");
        
        // Before Cancellation
        System.out.println("Inventory before cancellation: " + inventory.getRoomAvailability().get("Suite Room") + " Suite Rooms available.");

        // Attempt valid cancellation
        try {
            cancellationService.cancelBooking(idToCancel);
        } catch (BookingCancellationException e) {
            System.err.println(e.getMessage());
        }

        // After Cancellation
        System.out.println("Inventory after cancellation: " + inventory.getRoomAvailability().get("Suite Room") + " Suite Rooms available.");

        // Attempt invalid cancellation (already cancelled or doesn't exist)
        try {
            cancellationService.cancelBooking(idToCancel); // Already cancelled
        } catch (BookingCancellationException e) {
            System.err.println(e.getMessage());
        }

        try {
            cancellationService.cancelBooking(9999); // Doesn't exist
        } catch (BookingCancellationException e) {
            System.err.println(e.getMessage());
        }

        // --- UC8 Demonstration: Final Booking History ---
        bookingHistory.displayReport();
    }

    private static void attemptBooking(BookingRequestQueue queue, String guestName, String roomType) {
        try {
            Reservation reservation = new Reservation(guestName, roomType);
            queue.addRequest(reservation);
            System.out.println("Queued successfully: " + guestName + " for a " + roomType);
        } catch (InvalidReservationException e) {
            System.err.println("ERROR adding to queue: " + e.getMessage());
        }
    }
}