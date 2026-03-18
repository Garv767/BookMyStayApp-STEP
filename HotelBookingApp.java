import java.util.Map;

/**
 * MAIN CLASS - HotelBookingApp
 * Demonstrates UC6 (Allocation) and UC7 (Decorator Pattern for Add-ons).
 */
public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Booking System - Initialization");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Double Room"));

        BookingAllocationService allocationService = new BookingAllocationService();
        allocationService.processBookings(bookingQueue, inventory);

        // --- UC7 Demonstration: Add-On Services ---
        System.out.println("\nUC7: Guest Customizing a Room with Add-ons");
        
        // 1. Guest books a basic Double Room
        Room myRoom = new DoubleRoom();
        System.out.println("Initial Booking");
        myRoom.displayRoomDetails();

        // 2. Guest adds Premium WiFi
        System.out.println("\nGuest adds Premium WiFi");
        myRoom = new WiFiAddOn(myRoom);
        myRoom.displayRoomDetails();

        // 3. Guest adds Breakfast
        System.out.println("\nGuest adds Breakfast");
        myRoom = new BreakfastAddOn(myRoom);
        myRoom.displayRoomDetails();
    }
}