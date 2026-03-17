import java.util.Scanner;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Book My Stay App =====");

        // Display the use case menu
        for (int i = 1; i <= 7; i++) {
            System.out.println("Use Case " + i);
        }

        System.out.print("\nEnter the Use Case number you want to run (1-7): ");
        int choice = sc.nextInt();

        // Execute the selected use case
        switch (choice) {
            //case 1 -> UseCase1BookMyStayApp.execute();
            //case 2 -> UseCase2BookMyStayApp.execute();
            case 3 -> UseCase3BookMyStayApp.execute();
            case 4 -> UseCase4BookMyStayApp.execute();
            default -> System.out.println("Invalid choice! Please enter a number between 1 and 7.");
        }

        sc.close();
    }
}