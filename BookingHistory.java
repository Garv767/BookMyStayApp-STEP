import java.util.ArrayList;
import java.util.List;

/**
 * CLASS - BookingHistory
 * Maintains a record of all processed reservations and provides reporting capabilities.
 */
public class BookingHistory {
    private List<Reservation> bookingRecords;

    public BookingHistory() {
        this.bookingRecords = new ArrayList<>();
    }

    public void addRecord(Reservation reservation) {
        bookingRecords.add(reservation);
    }

    /**
     * UC10: Retrieves a reservation by its ID.
     */
    public Reservation getReservationById(int reservationId) {
        for (Reservation res : bookingRecords) {
            if (res.getReservationId() == reservationId) {
                return res;
            }
        }
        return null; // Not found
    }

    public void displayReport() {
        System.out.println("\nBooking History & Summary Report");
        
        if (bookingRecords.isEmpty()) {
            System.out.println("No bookings have been processed yet.");
            return;
        }

        int confirmedCount = 0;
        int failedCount = 0;
        int cancelledCount = 0;

        for (Reservation res : bookingRecords) {
            System.out.println("Res ID: " + res.getReservationId() + 
                               " | Guest: " + res.getGuestName() + 
                               " | Room: " + res.getRoomType() + 
                               " | Status: " + res.getStatus());
            
            if ("CONFIRMED".equals(res.getStatus())) {
                confirmedCount++;
            } else if ("FAILED".equals(res.getStatus())) {
                failedCount++;
            } else if ("CANCELLED".equals(res.getStatus())) {
                cancelledCount++;
            }
        }

        System.out.println("Total Booking Requests : " + bookingRecords.size());
        System.out.println("Active Confirmed       : " + confirmedCount);
        System.out.println("Cancelled Bookings     : " + cancelledCount);
        System.out.println("Failed/Declined        : " + failedCount);
    }
}