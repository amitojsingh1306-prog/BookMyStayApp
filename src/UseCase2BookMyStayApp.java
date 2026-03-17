/**
 * ============================================================
 * CLASS - UseCase2BookMyStayApp
 * ============================================================
 *
 * Use Case 2: Display Available Rooms
 *
 * Description:
 * This class demonstrates how room data is stored
 * and displayed using arrays.
 *
 * It shows available rooms to the user.
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase2BookMyStayApp {

    public static void execute() {

        // Sample room data
        int[] roomNumbers = {101, 102, 103, 104, 105};
        String[] roomTypes = {"Single", "Double", "Suite", "Deluxe", "Single"};
        boolean[] isAvailable = {true, false, true, true, false};

        System.out.println("\nAvailable Rooms:");
        System.out.println("-------------------------");

        for (int i = 0; i < roomNumbers.length; i++) {

            if (isAvailable[i]) {
                System.out.println("Room No: " + roomNumbers[i] +
                        " | Type: " + roomTypes[i]);
            }
        }
    }
}