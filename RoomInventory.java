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
     * Checks availability and books the room if available.
     */
    public boolean checkAndBookRoom(String roomType) {
        int availableCount = roomAvailability.getOrDefault(roomType, 0);
        if (availableCount > 0) {
            roomAvailability.put(roomType, availableCount - 1);
            return true;
        }
        return false;
    }

    /**
     * UC10: Rolls back inventory by incrementing the available count for a room type.
     */
    public void releaseRoom(String roomType) {
        int currentCount = roomAvailability.getOrDefault(roomType, 0);
        roomAvailability.put(roomType, currentCount + 1);
        System.out.println("Inventory Rollback: 1 " + roomType + " added back to inventory.");
    }
}