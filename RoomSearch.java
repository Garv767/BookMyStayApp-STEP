/**
 * MAIN CLASS - UseCase4RoomSearch
 * Demonstrates search functionality and read-only access.
 * @version 4.0
 */
public class RoomSearch {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, single, doubleRm, suite);

        System.out.println("System Update: Suite Rooms are now fully booked\n");
        inventory.updateAvailability("Suite Room", 0);

        searchService.searchAvailableRooms(inventory, single, doubleRm, suite);
    }
}
