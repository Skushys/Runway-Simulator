/*
Joseph Spicer
12/06/2024
RunwaySimulatorTest.java
Provides a menu-driven interface for the user to interact with the RunwaySimulator, allowing
them to add planes to landing or takeoff queues, simulate events, or display the current
state of queues.
*/

import java.util.Scanner;

public class RunwaySimulatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        RunwaySimulator simulator = new RunwaySimulator(); // Create an instance of the simulator

        // Loop to display the menu and handle user input
        while (true) {
            System.out.println("\nRunway Simulator Menu:");
            System.out.println("1. Enter a plane landing flight symbol");
            System.out.println("2. Enter a plane takeoff flight symbol");
            System.out.println("3. Simulate next event");
            System.out.println("4. Display all planes in queues");
            System.out.println("5. Quit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter landing plane flight symbol: ");
                    String landingFlight = scanner.nextLine();
                    simulator.addLandingPlane(landingFlight); // Add landing plane
                    break;

                case 2:
                    System.out.print("Enter takeoff plane flight symbol: ");
                    String takeoffFlight = scanner.nextLine();
                    simulator.addTakeoffPlane(takeoffFlight); // Add takeoff plane
                    break;

                case 3:
                    simulator.simulateNext(); // Simulate next event (landing or takeoff)
                    break;

                case 4:
                    simulator.displayQueues(); // Display current queues
                    break;

                case 5:
                    System.out.println("Exiting simulator.");
                    scanner.close(); // Close the scanner before quitting
                    return;

                default:
                    System.out.println("Invalid choice. Please try again."); // Handle incorrect input
            }
        }
    }
}
