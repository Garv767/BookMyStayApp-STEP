/**
 * MAIN CLASS - UseCase2RoomInitialization
 * Demonstrates room initialization and static availability.
 * @version 2.1
 */
public class HostelBookingApp {
    class SingleRoom extends Room {
        public SingleRoom() { super(1, 250, 1500.0); }
    }

    class DoubleRoom extends Room {
        public DoubleRoom() { super(2, 400, 2500.0); }
    }

    class SuiteRoom extends Room {
        public SuiteRoom() { super(3, 750, 5000.0); }
    }

    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization\n");

        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        System.out.println("Double Room:");
        doubleRm.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}
