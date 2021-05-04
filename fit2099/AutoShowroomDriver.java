package Bootcamp06.fit2099;

import Bootcamp06.fit2099.exceptions.BidException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 */
public class AutoShowroomDriver {
    /**
     * A boolean variable to store whether the AutoShowroom is still running.
     */
    private static boolean isRunning = true;
    /**
     * An instance of the AutoShowroom class.
     */
    private static AutoShowroom showroom;

    /**
     * The Main method of this project.
     * @param args
     */
    public static void main(String[] args) {
        showroom = new AutoShowroom();
        printStatus();
    }

    /**
     * Displays console options, reads input and calls corresponding AutoShowroom method.
     */
    static void consoleMenu() throws BidException {
        assert isRunning == true;
        Scanner menuScanner = new Scanner(System.in);
        System.out.println("""
                
                Select a Menu Option below:
                (1) New Sedan
                (2) New Truck
                (3) Add Buyer
                (4) Add Bid
                (5) Display Fleet
                (6) Display Buyers
                (7) Delete Bid
                (8) Display Highest Bid
                (9) Display Lowest Bid
                (10) Sell Vehicle
                (11) Display Sold Vehicles
                (12) Exit
                """);
        System.out.print("Enter option number: ");
        int selection = menuScanner.nextInt();
        switch (selection) {
            case 1 -> showroom.createSedan();
            case 2 -> showroom.createTruck();
            case 3 -> showroom.createBuyer();
            case 4 -> showroom.createBid();
            case 5 -> showroom.displayFleet();
            case 6 -> showroom.displayBuyers();
            case 7 -> showroom.deleteBid();
            case 8 -> showroom.displayBid("Highest");
            case 9 -> showroom.displayBid("Lowest");
            case 10 -> showroom.sellVehicle();
            case 11 -> showroom.displaySoldVehicles();
            case 12 -> isRunning = false;
            default -> System.out.println("Invalid option, try again...");
        }
    }

    /**
     * Displays AutoShowroom status and calls consoleMenu().
     */
    static void printStatus() {
        System.out.println("""

                +---------------------------------------+
                |  Welcome to the FIT2099 AutoShowroom! |
                +---------------------------------------+""");
        while(isRunning){
            try {
                consoleMenu();
            } catch (InputMismatchException e) {
                System.out.println("\nInput Mismatch Exception encountered, sorry for the inconvenience!");
            } catch (RuntimeException e) {
                System.out.println("\nRuntime Exception encountered, sorry for the inconvenience!");
            } catch (Exception e) {
                System.out.println("\nSome other Exception encountered, sorry for the inconvenience!");
            }
        }
        System.out.println("\nThank you for visiting the FIT2099 Showroom");
    }
}
