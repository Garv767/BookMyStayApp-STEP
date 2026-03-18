import java.io.*;

/**
 * CLASS - DataPersistenceService
 * Handles saving and loading the application state to/from a binary file.
 */
public class DataPersistenceService {
    private static final String FILE_NAME = "hotel_bookings.ser";

    /**
     * Saves the BookingHistory object to a file.
     */
    public void saveData(BookingHistory history) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(history);
            System.out.println("\n[SYSTEM] Data successfully saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("\n[SYSTEM ERROR] Failed to save data: " + e.getMessage());
        }
    }

    /**
     * Loads the BookingHistory object from a file, if it exists.
     */
    public BookingHistory loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("\n[SYSTEM] No existing data found. Starting a fresh system.");
            return new BookingHistory();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            BookingHistory history = (BookingHistory) ois.readObject();
            System.out.println("\n[SYSTEM] Data successfully recovered from " + FILE_NAME);
            return history;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("\n[SYSTEM ERROR] Failed to load data. Starting fresh. Error: " + e.getMessage());
            return new BookingHistory();
        }
    }
}