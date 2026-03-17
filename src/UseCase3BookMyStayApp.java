import java.util.HashMap;
import java.util.Map;

public class UseCase3BookMyStayApp {

    // Version 3.1 - centralized room inventory
    static class RoomInventory {
        private final Map<String, Integer> inventory;

        // Constructor to initialize room availability
        public RoomInventory() {
            inventory = new HashMap<>();
        }

        // Register room type with initial count
        public void addRoomType(String roomType, int count) {
            if (count < 0) {
                System.out.println("Cannot add negative room count.");
                return;
            }
            inventory.put(roomType, count);
        }

        // Retrieve current availability
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Controlled update of room availability
        public void updateAvailability(String roomType, int countChange) {
            int current = inventory.getOrDefault(roomType, 0);
            int updated = current + countChange;
            if (updated < 0) {
                System.out.println("Cannot reduce availability below zero for " + roomType);
                return;
            }
            inventory.put(roomType, updated);
        }

        // Display current inventory state
        public void displayInventory() {
            System.out.println("\n--- Current Room Inventory ---");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    // Execute method for this use case
    public static void execute() {
        System.out.println("\n=== Use Case 3: Centralized Room Inventory Management ===");

        RoomInventory inventory = new RoomInventory();

        // Initialize inventory
        inventory.addRoomType("Single", 10);
        inventory.addRoomType("Double", 5);
        inventory.addRoomType("Suite", 2);

        // Display initial state
        inventory.displayInventory();

        // Simulate updates
        inventory.updateAvailability("Single", -2);   // 2 rooms booked
        inventory.updateAvailability("Double", 1);    // 1 room added
        inventory.updateAvailability("Suite", -1);    // 1 room booked

        // Display final state
        inventory.displayInventory();
    }
}