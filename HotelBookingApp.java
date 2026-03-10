/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates how booking requests are accepted and queued in FIFO order.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize the booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests (Simulating guests arriving at different times)
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue (FIFO: First-In-First-Out)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process and display queued booking requests in arrival order
        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + current.getGuestName() + 
                               ", Room Type: " + current.getRoomType());
        }
    }
}
