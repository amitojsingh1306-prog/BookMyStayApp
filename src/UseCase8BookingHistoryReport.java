import java.util.*;

// Reservation class
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room Type: " + roomType;
    }
}

// Booking History class
class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add a confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(history);
    }

    // Generate simple report
    public void generateReport() {
        System.out.println("\n--- Booking Report ---");
        Map<String, Integer> roomCount = new HashMap<>();

        for (Reservation r : history) {
            roomCount.put(r.getRoomType(),
                    roomCount.getOrDefault(r.getRoomType(), 0) + 1);
        }

        System.out.println("Total Bookings: " + history.size());
        System.out.println("Bookings by Room Type:");
        for (String roomType : roomCount.keySet()) {
            System.out.println(roomType + ": " + roomCount.get(roomType));
        }
    }
}

// Main class for Use Case 8
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingHistory bookingHistory = new BookingHistory();

        while (true) {
            System.out.println("\n1. Confirm Booking");
            System.out.println("2. View Booking History");
            System.out.println("3. Generate Booking Report");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Reservation ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Guest Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room Type (Single/Double/Suite): ");
                    String type = sc.nextLine();

                    Reservation reservation = new Reservation(id, name, type);
                    bookingHistory.addReservation(reservation);

                    System.out.println("Booking confirmed and added to history!");
                }
                case 2 -> {
                    System.out.println("\n--- Booking History ---");
                    for (Reservation r : bookingHistory.getAllReservations()) {
                        System.out.println(r);
                    }
                }
                case 3 -> bookingHistory.generateReport();
                case 4 -> {
                    System.out.println("Exiting system...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}