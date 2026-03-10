/**
 * CLASS - Reservation
 * Represents a booking request made by a guest.
 * At this stage, it captures intent, not a confirmed booking.
 */
public class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}
