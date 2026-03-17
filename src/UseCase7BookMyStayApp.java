/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional services can be added
 * to an existing reservation without modifying booking logic.
 *
 * @author Developer
 * @version 7.0
 */

import java.util.*;

public class UseCase7BookMyStayApp {

    // Represents an Add-On Service
    static class Service {
        private final String name;
        private final double price;

        public Service(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    // Manages mapping between Reservation ID and Services
    static class AddOnServiceManager {
        private final Map<String, List<Service>> serviceMap;

        public AddOnServiceManager() {
            serviceMap = new HashMap<>();
        }

        // Add service to a reservation
        public void addService(String reservationId, Service service) {
            serviceMap.putIfAbsent(reservationId, new ArrayList<>());
            serviceMap.get(reservationId).add(service);
        }

        // Calculate total cost of services
        public double calculateTotalCost(String reservationId) {
            double total = 0;
            List<Service> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());

            for (Service s : services) {
                total += s.getPrice();
            }
            return total;
        }

        // Display services for a reservation
        public void displayServices(String reservationId) {
            System.out.println("\nServices for Reservation ID: " + reservationId);
            List<Service> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());

            if (services.isEmpty()) {
                System.out.println("No add-on services selected.");
                return;
            }

            for (Service s : services) {
                System.out.println("- " + s.getName() + " : " + s.getPrice());
            }

            System.out.println("Total Add-On Cost: " + calculateTotalCost(reservationId));
        }
    }

    // Execute method for Use Case 7
    public static void execute() {
        System.out.println("\n===== Use Case 7: Add-On Service Selection =====");

        AddOnServiceManager manager = new AddOnServiceManager();

        // Sample reservation ID
        String reservationId = "RES101";

        // Add services
        manager.addService(reservationId, new Service("Breakfast", 500));
        manager.addService(reservationId, new Service("Airport Pickup", 1200));
        manager.addService(reservationId, new Service("Extra Bed", 800));

        // Display services and total cost
        manager.displayServices(reservationId);
    }

    // Main method for standalone execution
    public static void main(String[] args) {
        execute();
    }
}