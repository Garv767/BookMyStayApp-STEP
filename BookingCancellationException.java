/**
 * CUSTOM EXCEPTION - BookingCancellationException
 * Thrown when a cancellation request is invalid.
 */
public class BookingCancellationException extends Exception {
    public BookingCancellationException(String message) {
        super(message);
    }
}