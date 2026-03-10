import java.util.Map;

/**
 * CLASS - RoomSearchService
 * Provides read-only search functionality to view available rooms.
 */
public class RoomSearchService {
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom, 
            Room doubleRoom, 
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms for Booking");

        if (availability.getOrDefault("Single Room", 0) > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single Room") + "\n");
        }

        if (availability.getOrDefault("Double Room", 0) > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double Room") + "\n");
        }

        if (availability.getOrDefault("Suite Room", 0) > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite Room") + "\n");
        }
    }
}
