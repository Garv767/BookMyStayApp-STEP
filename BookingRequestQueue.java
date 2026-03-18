import java.util.LinkedList;
import java.util.Queue;

/**
 * CLASS - BookingRequestQueue
 * Manages booking requests using a FIFO Queue.
 * Updated for UC11 to be Thread-Safe.
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        this.requestQueue = new LinkedList<>();
    }

    public synchronized void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public synchronized Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public synchronized boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}