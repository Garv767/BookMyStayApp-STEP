import java.util.Map;

/**
 * MAIN CLASS - UseCase3InventorySetup
 * Demonstrates centralized inventory management using HashMap.
 * @version 3.1
 */
public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> currentStatus = inventory.getRoomAvailability();

        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + currentStatus.get("Single Room") + "\n");

        System.out.println("Double Room:");
        doubleRm.displayRoomDetails();
        System.out.println("Available Rooms: " + currentStatus.get("Double Room") + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + currentStatus.get("Suite Room"));
    }
}
