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

    /**
     * Adds a processed reservation to the history.
     */
    public void addRecord(Reservation reservation) {
        bookingRecords.add(reservation);
    }

    /**
     * Generates and displays a summary report of all bookings.
     */
    public void displayReport() {
        System.out.println("\nBooking History & Summary Report");
        
        if (bookingRecords.isEmpty()) {
            System.out.println("No bookings have been processed yet.");
            return;
        }

        int confirmedCount = 0;
        int failedCount = 0;

        // Display individual records
        for (Reservation res : bookingRecords) {
            System.out.println("Res ID: " + res.getReservationId() + 
                               " | Guest: " + res.getGuestName() + 
                               " | Room: " + res.getRoomType() + 
                               " | Status: " + res.getStatus());
            
            if ("CONFIRMED".equals(res.getStatus())) {
                confirmedCount++;
            } else if ("FAILED".equals(res.getStatus())) {
                failedCount++;
            }
        }

        // Display summary statistics
        System.out.println("Total Booking Requests : " + bookingRecords.size());
        System.out.println("Confirmed Bookings     : " + confirmedCount);
        System.out.println("Failed/Declined        : " + failedCount);
    }
}