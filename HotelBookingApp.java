/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC12: Data Persistence alongside previous functionality.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        DataPersistenceService persistenceService = new DataPersistenceService();
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        
        // --- UC12: System Recovery ---
        BookingHistory bookingHistory = persistenceService.loadData();
        
        // Rebuild inventory state and ID counters based on loaded history
        for (Reservation res : bookingHistory.getBookingRecords()) {
            if ("CONFIRMED".equals(res.getStatus())) {
                inventory.checkAndBookRoom(res.getRoomType()); // Deduct confirmed rooms from fresh inventory
            }
            Reservation.updateIdCounter(res.getReservationId()); // Sync ID counter
        }

        BookingAllocationService allocationService = new BookingAllocationService(bookingHistory);
        BookingCancellationService cancellationService = new BookingCancellationService(bookingHistory, inventory);

        // Run a sample booking to show the system works across restarts
        System.out.println("\nProcessing New Booking Requests");
        attemptBooking(bookingQueue, "NewGuest_Alice", "Double Room");
        allocationService.processBookings(bookingQueue, inventory);

        // Display the report (will show both old loaded data + new data)
        bookingHistory.displayReport();

        // --- UC12: Data Persistence (Save before exiting) ---
        persistenceService.saveData(bookingHistory);
        System.out.println("=== System Shutdown ===");
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