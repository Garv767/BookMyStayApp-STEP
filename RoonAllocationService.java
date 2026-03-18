/**
 * CLASS - BookingAllocationService
 * Handles the business logic of allocating rooms to pending reservations
 * from the queue and updating their statuses based on inventory availability.
 */
public class BookingAllocationService {

    /**
     * Processes all pending booking requests in the queue.
     * * @param bookingQueue The queue containing pending reservations (FIFO)
     * @param inventory    The hotel's room inventory
     */
    public void processBookings(BookingRequestQueue bookingQueue, RoomInventory inventory) {
        System.out.println("\nProcessing Booking Requests via Allocation Service");

        // Process queued requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();
            System.out.println("Processing request for Guest: " + current.getGuestName() + 
                               " | Room: " + current.getRoomType());

            // Attempt to book the room via the inventory
            if (inventory.checkAndBookRoom(current.getRoomType())) {
                current.setStatus("CONFIRMED");
                System.out.println(" -> SUCCESS: Booking Confirmed! Reservation ID: " + current.getReservationId());
            } else {
                current.setStatus("FAILED");
                System.out.println(" -> FAILED: Out of inventory for " + current.getRoomType() + 
                                   ". Cannot confirm booking.");
            }
        }
    }
}