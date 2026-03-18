/**
 * CLASS - BookingAgent
 * Implements Runnable to simulate concurrent booking requests.
 */
public class BookingAgent implements Runnable {
    private String guestName;
    private String roomType;
    private BookingRequestQueue queue;
    private BookingAllocationService allocationService;
    private RoomInventory inventory;

    public BookingAgent(String guestName, String roomType, BookingRequestQueue queue, 
                        BookingAllocationService allocationService, RoomInventory inventory) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.queue = queue;
        this.allocationService = allocationService;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is attempting to book a " + roomType + " for " + guestName);
            
            // Create reservation and add to the shared queue
            Reservation reservation = new Reservation(guestName, roomType);
            queue.addRequest(reservation);
            
            // Trigger the allocation service processing
            allocationService.processBookings(queue, inventory);
            
        } catch (InvalidReservationException e) {
            System.err.println("Validation Error for " + guestName + ": " + e.getMessage());
        }
    }
}