import java.util.Scanner;

public class BookMyStayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Book My Stay App =====");
            System.out.println("1. Use Case 1 - Welcome Message");
            System.out.println("2. Use Case 2");
            System.out.println("3. Use Case 3");
            System.out.println("4. Use Case 4");
            System.out.println("5. Use Case 5");
            System.out.println("6. Use Case 6");
            System.out.println("7. Use Case 7");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    UseCase1BookMyStayApp.execute();
                    break;
                case 2:
                    UseCase2BookMyStayApp.execute();
                    break;
                case 3:
                    UseCase3BookMyStayApp.execute();
                    break;
                case 4:
                    UseCase4BookMyStayApp.execute();
                    break;
                case 5:
                    UseCase5BookMyStayApp.execute();
                    break;
                case 6:
                    UseCase6BookMyStayApp.execute();
                    break;
                case 7:
                    UseCase7BookMyStayApp.execute();
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}