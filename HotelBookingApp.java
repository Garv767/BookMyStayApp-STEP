/**
 * MAIN CLASS - HotelBookingApp
 * The entry point of the Hotel Booking Management System.
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Book My Stay App\n");

        RoomInventory inventory = new RoomInventory();
        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Initial Room Search:");
        searchService.searchAvailableRooms(inventory, single, doubleRm, suite);

        System.out.println("System Update: Suite Rooms are now fully booked\n");
        inventory.updateAvailability("Suite Room", 0);

        System.out.println("Updated Room Search:");
        searchService.searchAvailableRooms(inventory, single, doubleRm, suite);
        
        System.out.println("Application execution complete.");
    }
}
