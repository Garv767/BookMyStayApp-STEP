/**
 * CONCRETE DECORATOR - BreakfastAddOn
 * Adds a complimentary breakfast service to the room.
 */
public class BreakfastAddOn extends RoomAddOn {
    private static final double BREAKFAST_COST = 500.0;

    public BreakfastAddOn(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return wrappedRoom.getDescription() + " + Breakfast";
    }

    @Override
    public double getCost() {
        return wrappedRoom.getCost() + BREAKFAST_COST;
    }
}