import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookMyStayApp {

    // Version 5.0 - First-Come-First-Served booking requests
    static class Reservation {
        private final String guestName;
        private final String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() { return guestName; }
        public String getRoomType() { return roomType; }

        public void display() {
            System.out.println("Guest: " + guestName + ", Requested Room: " + roomType);
        }
    }

    static class BookingRequestQueue {
        private final Queue<Reservation> queue;

        public BookingRequestQueue() {
            queue = new LinkedList<>(); // FIFO queue
        }

        // Add a booking request to the queue
        public void addRequest(Reservation reservation) {
            queue.add(reservation);
            System.out.println("Booking request added for " + reservation.getGuestName());
        }

        // Display all queued requests
        public void displayQueue() {
            System.out.println("\n=== Booking Request Queue ===");
            if (queue.isEmpty()) {
                System.out.println("No pending requests.");
                return;
            }
            for (Reservation r : queue) {
                r.display();
            }
        }

        // Peek at the first request (without removing)
        public Reservation peekRequest() {
            return queue.peek();
        }

        // Remove and return the first request (for future allocation)
        public Reservation processRequest() {
            return queue.poll();
        }
    }

    // Execute method for this use case
    public static void execute() {
        System.out.println("\n=== Use Case 5: Booking Request (First-Come-First-Served) ===");

        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Simulate booking requests
        requestQueue.addRequest(new Reservation("Alice", "Single"));
        requestQueue.addRequest(new Reservation("Bob", "Double"));
        requestQueue.addRequest(new Reservation("Charlie", "Suite"));

        // Display queued requests
        requestQueue.displayQueue();

        // Peek and process first request (optional demonstration)
        System.out.println("\nFirst request in queue:");
        Reservation first = requestQueue.peekRequest();
        if (first != null) first.display();
    }
}