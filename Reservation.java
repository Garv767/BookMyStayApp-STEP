/**
 * CLASS - Reservation
 * Represents a booking request made by a guest.
 * Updated for UC9 to include input validation.
 */
public class Reservation {
    private static int idCounter = 1000;
    
    private int reservationId;
    private String guestName;
    private String roomType;
    private String status;

    // Constructor now declares that it can throw InvalidReservationException
    public Reservation(String guestName, String roomType) throws InvalidReservationException {
        // Validation Logic
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidReservationException("Validation Failed: Guest name cannot be null or empty.");
        }
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidReservationException("Validation Failed: Room type cannot be null or empty.");
        }

        this.reservationId = ++idCounter;
        this.guestName = guestName.trim();
        this.roomType = roomType.trim();
        this.status = "PENDING";
    }

    public int getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}