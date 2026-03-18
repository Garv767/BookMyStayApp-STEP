/**
 * ABSTRACT DECORATOR - RoomAddOn
 * Wraps a Room object to add additional services dynamically.
 */
public abstract class RoomAddOn extends Room {
    protected Room wrappedRoom;

    public RoomAddOn(Room room) {
        // Pass the base room's physical attributes up the chain
        super(room.numberOfBeds, room.squareFeet, room.pricePerNight);
        this.wrappedRoom = room;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
