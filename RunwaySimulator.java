/*
Joseph Spicer
12/06/2024
RunwaySimulator.java
Simulates a runway where planes either land or take off based on 2 queues. One for landing
planes, and one for takeoff planes.
 */

import java.util.Scanner;

public class RunwaySimulator {
    private Queue<String> landingQueue; //Queue for planes waiting to land
    private Queue<String> takeoffQueue; // Queue for planes waiting to take off

    // Constructor initializes the landing and takeoff queues
    public RunwaySimulator() {
        landingQueue = new Queue<>();
        takeoffQueue = new Queue<>();
    }

    // Adds a plane to the landing queue
    public void addLandingPlane(String flightSymbol) {
        landingQueue.enqueue(flightSymbol);
    }

    // Adds a plane to the takeoff queue
    public void addTakeoffPlane(String flightSymbol) {
        takeoffQueue.enqueue(flightSymbol);
    }

    // Simulates the next event
    public void simulateNext() {
        // First check if there are planes waiting to land
        if (!landingQueue.isEmpty()) {
            System.out.println("Next plane to land: " + landingQueue.dequeue());
        } else if (!takeoffQueue.isEmpty()) { // If no landing planes, check for takeoffs
            System.out.println("Next plane to take off: " + takeoffQueue.dequeue());
        } else {
            System.out.println("No planes to land or take off."); // No planes in either
        }
    }

    // Displays all planes in both the landing and takeoff queues
    public void displayQueues() {
        System.out.println("Planes waiting to land:");
        if (landingQueue.isEmpty()) {
            System.out.println("None");
        } else {
            Queue<String> temp = new Queue<>();
            while (!landingQueue.isEmpty()) {
                String plane = landingQueue.dequeue();
                System.out.println(plane);
                temp.enqueue(plane);
            }
            while (!temp.isEmpty()) {
                landingQueue.enqueue(temp.dequeue());
            }
        }

        System.out.println("Planes waiting to take off:");
        if (takeoffQueue.isEmpty()) {
            System.out.println("None"); // If landing queue is empty, print "None"
        } else {
            Queue<String> temp = new Queue<>();
            while (!takeoffQueue.isEmpty()) {
                String plane = takeoffQueue.dequeue();
                System.out.println(plane);
                temp.enqueue(plane);
            }
            while (!temp.isEmpty()) {
                takeoffQueue.enqueue(temp.dequeue());
            }
        }
    }
}
