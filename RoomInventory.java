import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 * Acts as the single source of truth for room availability.
 * Updated for UC11 to be Thread-Safe.
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
        roomAvailability.put("Suite Room", 2); // Only 2 suites available
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public synchronized void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    /**
     * Synchronized to prevent Race Conditions during concurrent bookings.
     */
    public synchronized boolean checkAndBookRoom(String roomType) {
        int availableCount = roomAvailability.getOrDefault(roomType, 0);
        if (availableCount > 0) {
            // Simulate a slight delay that would normally cause a race condition if not synchronized
            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            
            roomAvailability.put(roomType, availableCount - 1);
            return true;
        }
        return false;
    }

    /**
     * Synchronized to prevent issues when multiple cancellations happen simultaneously.
     */
    public synchronized void releaseRoom(String roomType) {
        int currentCount = roomAvailability.getOrDefault(roomType, 0);
        roomAvailability.put(roomType, currentCount + 1);
        System.out.println("Inventory Rollback: 1 " + roomType + " added back to inventory.");
    }
}