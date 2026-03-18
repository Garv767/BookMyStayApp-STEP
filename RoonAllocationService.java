/**
 * CLASS - BookingAllocationService
 * Handles the business logic of allocating rooms to pending reservations
 * and logging them into the booking history.
 */
public class BookingAllocationService {

    private BookingHistory history;

    // Injecting the history dependency
    public BookingAllocationService(BookingHistory history) {
        this.history = history;
    }

    /**
     * Processes all pending booking requests in the queue.
     * @param bookingQueue The queue containing pending reservations
     * @param inventory    The hotel's room inventory
     */
    public void processBookings(BookingRequestQueue bookingQueue, RoomInventory inventory) {
        System.out.println("\nProcessing Booking Requests via Allocation Service");

        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();
            System.out.println("Processing request for Guest: " + current.getGuestName() + 
                               " | Room: " + current.getRoomType());

            if (inventory.checkAndBookRoom(current.getRoomType())) {
                current.setStatus("CONFIRMED");
                System.out.println(" -> SUCCESS: Booking Confirmed! Reservation ID: " + current.getReservationId());
            } else {
                current.setStatus("FAILED");
                System.out.println(" -> FAILED: Out of inventory for " + current.getRoomType() + 
                                   ". Cannot confirm booking.");
            }
            
            // Log the processed reservation into the history
            history.addRecord(current);
        }
    }
}