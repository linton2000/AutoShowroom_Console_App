package Bootcamp06.fit2099;

import Bootcamp06.fit2099.bids.Bid;
import Bootcamp06.fit2099.exceptions.BidException;
import Bootcamp06.fit2099.exceptions.SedanException;
import Bootcamp06.fit2099.exceptions.TruckException;
import Bootcamp06.fit2099.exceptions.VehicleException;
import Bootcamp06.fit2099.vehicles.Sedan;
import Bootcamp06.fit2099.vehicles.Truck;
import Bootcamp06.fit2099.vehicles.Vehicle;
import Bootcamp06.fit2099.buyers.Buyer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see VehicleBidManager
 */
public class AutoShowroom {

    /**
     * An ArrayList of Vehicle instances.
     */
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    /**
     * An ArrayList of Vehicle instances that were sold.
     */
    ArrayList<Vehicle> soldVehicles = new ArrayList<>();
    /**
     * An ArrayList of Buyer instances.
     */
    ArrayList<Buyer> buyers = new ArrayList<>();
    /**
     * An instance of VehicleBidManager.
     */
    VehicleBidManager bids = new VehicleBidManager();

    /**
     * Creates a Sedan instance from user input and adds it to the vehicles ArrayList.
     */
    void createSedan() {
        Scanner sedanScanner = new Scanner(System.in);
        Utils.print("Enter sedan's make: ");
        String make = sedanScanner.next();
        Utils.print("Enter sedan's model: ");
        String model = sedanScanner.next();
        Utils.print("Enter sedan's no. of seats: ");
        int seats = sedanScanner.nextInt();
        try {
            Vehicle newSedan = new Sedan(make, model, seats);
            vehicles.add(newSedan);
            bids.addVehicle(newSedan);
            Utils.println("The sedan " + newSedan.description() + " has been added.");
        }
        catch (SedanException e) {
            Utils.println(e.getMessage());
        } catch (VehicleException e) {
            Utils.println(e.getMessage());
        } catch (Exception e) {
            Utils.println(e.getMessage());
        }
    }

    /**
     * Creates a Truck instance from user input and adds it to the vehicles ArrayList.
     */
    void createTruck() {
        Scanner truckScanner = new Scanner(System.in);
        Utils.print("Enter truck's make: ");
        String make = truckScanner.next();
        Utils.print("Enter truck's model: ");
        String model = truckScanner.next();
        Utils.print("Enter truck's no. of wheels: ");
        int wheels = truckScanner.nextInt();
        Utils.print("Enter truck's capacity: ");
        int capacity = truckScanner.nextInt();
        try {
            Vehicle newTruck = new Truck(make, model, wheels, capacity);
            vehicles.add(newTruck);
            bids.addVehicle(newTruck);
            Utils.println("The truck " + newTruck.description() + " has been added.");
        } catch (TruckException e) {
            Utils.println(e.getMessage());
        } catch (VehicleException e) {
            Utils.println(e.getMessage());
        } catch (Exception e) {
            Utils.println(e.getMessage());
        }
    }

    /**
     * Creates a Buyer instance from user input and adds it to the buyers ArrayList.
     */
    void createBuyer() {
        Scanner buyerScanner = new Scanner(System.in);
        Utils.print("Enter buyer's given name: ");
        String gName = buyerScanner.next();
        Utils.print("Enter buyer's family name: ");
        String fName = buyerScanner.next();
        int buyerID = Utils.nextID(1000, 9999);
        Buyer newBuyer = Buyer.getInstance(gName, fName);
        if(newBuyer != null) {
            buyers.add(newBuyer);
            Utils.println("The buyer " + newBuyer.description() + " has been added.");
        } else {
            Utils.println("Exception: Incorrect Given or Family Name.");
        }
    }

    /**
     * Creates a Bid instance from user input and adds it to the BidManager of it's corresponding Vehicle instance.
     */
    void createBid() {
        if (vehicles.size() == 0) {
            Utils.println("No vehicles to bid on yet.");
        } else {
            Scanner bidScanner = new Scanner(System.in);
            Utils.print("Enter vehicle ID: ");
            int vehicleId = bidScanner.nextInt();
            Utils.print("Enter buyer ID: ");
            int buyerId = bidScanner.nextInt();
            Utils.print("Enter vehicle price: ");
            double price = bidScanner.nextDouble();
            Utils.print("Enter bid's date (dd/mm/yyyy): ");
            String date = bidScanner.next();
            bids.addBid(vehicleId, buyerId, price, date);
            Utils.println(bids.getVehicleBids(vehicleId).description(buyerId, vehicleId));
        }
    }

    /**
     * Displays a list of all vehicles, including its bids, to the console.
     */
    void displayFleet() {
        if (vehicles.size() == 0) {
            Utils.println("No vehicles in this autoshowroom yet.");
        } else {
            Utils.println("List of vehicles:");
            for (Vehicle vehicle : vehicles) {
                Utils.println("    " + vehicle.description() + " has bids:");
                if (bids.getVehicleBids(vehicle.getvId()).getBids().size() == 0)
                    Utils.println("No current bids for this vehicle yet.");
                for (Bid bid : bids.getVehicleBids(vehicle.getvId()).getBids().values()) {
                    Utils.println("        " + bid.description());
                }
            }
        }
    }

    /**
     * Displays a list of all buyers to the console.
     */
    void displayBuyers() {
        if (buyers.size() == 0) {
            Utils.println("No buyers registered yet.");
        } else {
            Utils.println("List of Buyers:");
            for (Buyer buyer : buyers) {
                assert buyer != null;
                Utils.println("    " + buyer.description());
            }
        }
    }

    /**
     * Deletes bid based on user inputted Bid ID.
     */
    public void deleteBid() {
        if(bids.getAllBids().size() == 0)
            Utils.println("No bids placed yet.");
        else {
            Scanner deleteScanner = new Scanner(System.in);
            Utils.print("Enter ID of bid to be deleted: ");
            int bidId = deleteScanner.nextInt();
            assert bidId > 1000 && bidId < 9999;
            bids.removeBid(bidId);
            Utils.println("Bid " + bidId + " has been deleted successfully.");
        }
    }

    /**
     * Displays the Highest or Lowest bid.
     *
     * @param bidSize - String that specifies whether Highest or Lowest should be displayed.
     * @throws BidException - Exception caused by incorrect bid size.
     */
    public void displayBid(String bidSize) throws BidException {
        if(bids.getAllBids().size() == 0)
            Utils.println("No bids placed yet.");
        else {
            Scanner bidDisplayScanner = new Scanner(System.in);
            Utils.print("Enter the ID of the vehicle that you want the " + bidSize + " bid for: ");
            int vId = bidDisplayScanner.nextInt();
            ArrayList<Double> priceList = new ArrayList<>();
            for (Bid i : bids.getVehicleBids(vId).getBids().values()) {
                priceList.add(i.getPrice());
            }
            double targetPrice;
            if (bidSize.equals("Highest")) {
                targetPrice = Collections.max(priceList);
            } else if (bidSize.equals("Lowest")) {
                targetPrice = Collections.min(priceList);
            } else {
                throw new BidException("Exception: Desired Bid size (max/min) not set correctly");
            }
            assert targetPrice > 0;
            Utils.println(bids.getVehicleBids(vId).getBidByPrice(targetPrice).description() + " is the " + bidSize + " bid.");
        }
    }

    /**
     * Sells vehicle by removing from fleet and placing in soldVehicles.
     */
    public void sellVehicle() {
        if(vehicles.size() == 0)
            Utils.println("No vehicles in AutoShowroom yet.");
        else {
            Scanner sellScanner = new Scanner(System.in);
            Utils.print("Enter ID of vehicle to be sold: ");
            int vId = sellScanner.nextInt();
            Vehicle soldVehicle = null;
            for (Vehicle i : vehicles) {
                if (i.getvId() == vId) {
                    soldVehicle = i;
                }
            }
            assert soldVehicle != null;
            vehicles.remove(soldVehicle);
            soldVehicles.add(soldVehicle);
            Utils.println("Vehicle " + vId + " has been sold successfully.");
        }
    }

    /**
     * Displays a brief description of each sold vehicle.
     */
    public void displaySoldVehicles() {
        if(soldVehicles.size() == 0)
            Utils.println("No vehicles sold yet.");
        else {
            Utils.println("List of sold vehicles:");
            for (Vehicle i : soldVehicles)
                Utils.println(i.description());
        }
    }
}
