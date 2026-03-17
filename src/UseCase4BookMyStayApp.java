import java.util.HashMap;
import java.util.Map;

public class UseCase4BookMyStayApp {

    // Version 4.0 - read-only search
    static class Room {
        private final String type;
        private final int price;
        private final String amenities;

        public Room(String type, int price, String amenities) {
            this.type = type;
            this.price = price;
            this.amenities = amenities;
        }

        public String getType() { return type; }
        public int getPrice() { return price; }
        public String getAmenities() { return amenities; }

        public void display() {
            System.out.println("Room Type: " + type);
            System.out.println("Price: $" + price);
            System.out.println("Amenities: " + amenities);
            System.out.println("------------------------");
        }
    }

    static class RoomInventory {
        private final Map<String, Integer> inventory;

        public RoomInventory() {
            inventory = new HashMap<>();
        }

        public void addRoomType(String roomType, int count) {
            inventory.put(roomType, count);
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        public Map<String, Integer> getAllAvailability() {
            return new HashMap<>(inventory); // return copy to ensure read-only access
        }
    }

    static class SearchService {
        private final RoomInventory inventory;
        private final Map<String, Room> rooms;

        public SearchService(RoomInventory inventory) {
            this.inventory = inventory;
            rooms = new HashMap<>();
        }

        public void addRoomDetails(Room room) {
            rooms.put(room.getType(), room);
        }

        // Read-only search
        public void displayAvailableRooms() {
            System.out.println("\n=== Available Rooms ===");
            for (String type : rooms.keySet()) {
                if (inventory.getAvailability(type) > 0) {
                    rooms.get(type).display();
                }
            }
        }
    }

    // Execute method for Use Case 4
    public static void execute() {
        System.out.println("\n=== Use Case 4: Room Search & Availability Check ===");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 8);
        inventory.addRoomType("Double", 0); // unavailable room
        inventory.addRoomType("Suite", 3);

        // Initialize rooms
        SearchService search = new SearchService(inventory);
        search.addRoomDetails(new Room("Single", 100, "WiFi, TV, AC"));
        search.addRoomDetails(new Room("Double", 150, "WiFi, TV, AC"));
        search.addRoomDetails(new Room("Suite", 300, "WiFi, TV, AC, Mini Bar"));

        // Display available rooms (read-only)
        search.displayAvailableRooms();
    }
}