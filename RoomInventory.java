import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 * Acts as the single source of truth for room availability.
 */
public class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    /**
     * UC6: Checks availability and books the room if available.
     * @return true if successfully booked, false if unavailable.
     */
    public boolean checkAndBookRoom(String roomType) {
        int availableCount = roomAvailability.getOrDefault(roomType, 0);
        if (availableCount > 0) {
            // Allocate the room by decrementing the count
            roomAvailability.put(roomType, availableCount - 1);
            return true;
        }
        return false;
    }
}