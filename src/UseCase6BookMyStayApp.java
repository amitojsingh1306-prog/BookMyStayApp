import java.util.*;

public class UseCase6BookMyStayApp {

    // Version 6.0 - Reservation Confirmation & Room Allocation
    static class Reservation {
        private final String guestName;
        private final String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() { return guestName; }
        public String getRoomType() { return roomType; }
    }

    static class RoomInventory {
        private final Map<String, Integer> inventory;
        private final Map<String, Set<String>> allocatedRooms; // roomType -> allocated IDs
        private int roomIdCounter = 100; // simple unique ID generator

        public RoomInventory() {
            inventory = new HashMap<>();
            allocatedRooms = new HashMap<>();
        }

        public void addRoomType(String roomType, int count) {
            inventory.put(roomType, count);
            allocatedRooms.put(roomType, new HashSet<>());
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        public String allocateRoom(String roomType) {
            if (getAvailability(roomType) <= 0) return null; // no rooms left

            String roomId = roomType.substring(0, 1).toUpperCase() + roomIdCounter++;
            allocatedRooms.get(roomType).add(roomId);
            inventory.put(roomType, inventory.get(roomType) - 1);
            return roomId;
        }

        public void displayAllocatedRooms() {
            System.out.println("\n=== Allocated Rooms ===");
            for (String type : allocatedRooms.keySet()) {
                System.out.println(type + ": " + allocatedRooms.get(type));
            }
        }
    }

    static class BookingService {
        private final Queue<Reservation> requestQueue;
        private final RoomInventory inventory;

        public BookingService(Queue<Reservation> requestQueue, RoomInventory inventory) {
            this.requestQueue = requestQueue;
            this.inventory = inventory;
        }

        public void processBookings() {
            System.out.println("\n=== Processing Bookings ===");
            while (!requestQueue.isEmpty()) {
                Reservation r = requestQueue.poll();
                String allocatedRoomId = inventory.allocateRoom(r.getRoomType());
                if (allocatedRoomId != null) {
                    System.out.println("Confirmed: " + r.getGuestName() + " -> Room " + allocatedRoomId);
                } else {
                    System.out.println("No availability for " + r.getGuestName() + " (" + r.getRoomType() + ")");
                }
            }
        }
    }

    // Execute method for this use case
    public static void execute() {
        System.out.println("\n=== Use Case 6: Reservation Confirmation & Room Allocation ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 2);
        inventory.addRoomType("Double", 1);
        inventory.addRoomType("Suite", 1);

        // Initialize booking request queue (simulate previous use case)
        Queue<Reservation> requestQueue = new LinkedList<>();
        requestQueue.add(new Reservation("Alice", "Single"));
        requestQueue.add(new Reservation("Bob", "Double"));
        requestQueue.add(new Reservation("Charlie", "Single"));
        requestQueue.add(new Reservation("David", "Suite"));
        requestQueue.add(new Reservation("Eve", "Single"));

        // Process bookings
        BookingService bookingService = new BookingService(requestQueue, inventory);
        bookingService.processBookings();

        // Display all allocated rooms
        inventory.displayAllocatedRooms();
    }
}