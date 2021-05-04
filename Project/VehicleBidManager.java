package Bootcamp06.fit2099;

import Bootcamp06.fit2099.bids.Bid;
import Bootcamp06.fit2099.bids.BidManager;
import Bootcamp06.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see BidManager
 * @see Vehicle
 */
public class VehicleBidManager {
    /**
     * Hashmap containing both vehicles and bidmanagers.
     */
    private HashMap<Vehicle, BidManager> vehicleBidMap;

    /**
     * Default constructor that initializes vehicleBidMap.
     */
    public VehicleBidManager(){
        vehicleBidMap = new HashMap<>();
    }

    /**
     * Adds vehicle as a key to vehicleBidMap along with an empty BidManager as the value.
     *
     * @param newVehicle - Vehicle instance to be added.
     */
    public void addVehicle(Vehicle newVehicle){
        BidManager newBidManager = new BidManager();
        vehicleBidMap.put(newVehicle, newBidManager);
    }

    /**
     * Adds bid to the corresponding vehicle key and bid manager value.
     *
     * @param vId - Vehicle ID
     * @param buyerId - Buyer ID
     * @param bidPrice - Bid Price
     * @param date - Date of Bid
     */
    public void addBid(int vId, int buyerId, double bidPrice, String date){
        BidManager bids = this.getVehicleBids(vId);
        bids.addBid(buyerId, bidPrice, date);
    }

    /**
     * Retrieves bids of a specified vehicle (by ID) or null if empty.
     *
     * @param vId - Vehicle's ID
     * @return BidManger instance or null if empty.
     */
    public BidManager getVehicleBids(int vId){
        for(Vehicle v: vehicleBidMap.keySet())
            if(v.getvId() == vId)
                return vehicleBidMap.get(v);
        return null;
    }

    /**
     * Retrieves all the bids stored in all the vehicles of vehicleBidMap.
     *
     * @return All Bids stored.
     */
    public ArrayList<Bid> getAllBids(){
        ArrayList<Bid> allBids = new ArrayList<>();
        for(BidManager bids: vehicleBidMap.values()){
            allBids.addAll(bids.getBids().values());
        }
        return allBids;
    }

    /**
     * Removes bid from vehicleBidMap by Bid ID.
     *
     * @param bidId - Bid ID.
     */
    public void removeBid(int bidId){
        for(BidManager bids: vehicleBidMap.values()){
            for(Bid b: bids.getBids().values()){
                if(b.getId() == bidId) bids.removeBid(bidId);
            }
        }
    }
}
