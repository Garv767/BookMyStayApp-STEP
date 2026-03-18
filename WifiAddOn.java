/**
 * CONCRETE DECORATOR - WiFiAddOn
 * Adds premium high-speed WiFi to the room.
 */
public class WiFiAddOn extends RoomAddOn {
    private static final double WIFI_COST = 200.0;

    public WiFiAddOn(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return wrappedRoom.getDescription() + " + Premium WiFi";
    }

    @Override
    public double getCost() {
        return wrappedRoom.getCost() + WIFI_COST;
    }
}