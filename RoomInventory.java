import java.io.Serializable;

/**
 * CLASS - Reservation
 * Represents a booking request made by a guest.
 * Updated for UC12: Implements Serializable for data persistence.
 */
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version compatibility during deserialization
    
    private static int idCounter = 1000; 
    
    private int reservationId;
    private String guestName;
    private String roomType;
    private String status;

    public Reservation(String guestName, String roomType) throws InvalidReservationException {
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

    /**
     * Helper method to prevent ID collisions when loading past reservations.
     */
    public static void updateIdCounter(int loadedId) {
        if (loadedId >= idCounter) {
            idCounter = loadedId;
        }
    }
}