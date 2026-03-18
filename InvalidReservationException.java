/**
 * CUSTOM EXCEPTION - InvalidReservationException
 * Thrown when a reservation fails basic validation checks.
 */
public class InvalidReservationException extends Exception {
    public InvalidReservationException(String message) {
        super(message);
    }
}