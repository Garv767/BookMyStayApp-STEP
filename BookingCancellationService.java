/**
 * CLASS - BookingCancellationService
 * Handles the business logic for cancelling a reservation and rolling back inventory.
 */
public class BookingCancellationService {
    
    private BookingHistory history;
    private RoomInventory inventory;

    public BookingCancellationService(BookingHistory history, RoomInventory inventory) {
        this.history = history;
        this.inventory = inventory;
    }

    /**
     * Attempts to cancel a booking by its ID.
     */
    public void cancelBooking(int reservationId) throws BookingCancellationException {
        System.out.println("\nAttempting to Cancel Reservation ID: " + reservationId);
        
        Reservation reservation = history.getReservationById(reservationId);

        if (reservation == null) {
            throw new BookingCancellationException("Cancellation Failed: Reservation ID " + reservationId + " not found.");
        }

        if (!"CONFIRMED".equals(reservation.getStatus())) {
            throw new BookingCancellationException("Cancellation Failed: Only CONFIRMED bookings can be cancelled. Current status is " + reservation.getStatus() + ".");
        }

        // 1. Change status
        reservation.setStatus("CANCELLED");
        System.out.println("Status updated to CANCELLED for Guest: " + reservation.getGuestName());

        // 2. Rollback inventory
        inventory.releaseRoom(reservation.getRoomType());
        
        System.out.println("Cancellation Successful.");
    }
}