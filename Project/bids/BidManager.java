package Bootcamp06.fit2099.bids;

import Bootcamp06.fit2099.Utils;
import Bootcamp06.fit2099.exceptions.BidException;

import java.util.HashMap;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see Bid
 */
public class BidManager {
    /**
     * A HashMap of Bid instances keyed by Buyer IDs.
     */
    private HashMap<Integer, Bid> bids;

    /**
     * A default constructor which instantiates a new bids HashMap.
     */
    public BidManager() {
        bids = new HashMap<>();
    }

    /**
     * A bids HashMap getter.
     * @return bids - A HashMap variable containing Bid instances.
     */
    public HashMap<Integer, Bid> getBids() {
        return bids;
    }

    /**
     * Adds a new Bid instance to the bids HashMap field.
     *
     * @param buyerId - The ID of the buyer, which has to be unique.
     * @param bidPrice - The price of the Bid.
     * @param date - The Bid's date.
     */
    public void addBid(int buyerId, double bidPrice, String date){
        int bidId = Utils.nextID(1000, 9999);
        try {
            Bid newBid = new Bid(bidId, date, bidPrice);
            bids.put(buyerId, newBid);
        } catch (BidException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns description of bid creation to the user.
     *
     * @param buyerId - Buyer ID
     * @param vehicleId - Vehicle ID
     * @return Bid description
     */
    public String description(int buyerId, int vehicleId){
        Bid thisBid = bids.get(buyerId);
        return "\nThe bid for $" + thisBid.getPrice() + " placed on vehicle " + vehicleId
                + " for the date " + thisBid.getDate() + " has been added.";
    }

    /**
     * Removes bid from bids Hashmap based on Bid ID.
     *
     * @param bidId - Bid ID.
     */
    public void removeBid(int bidId) {
        bids.values().removeIf(i -> i.getId() == bidId);
    }

    /**
     * Retrieves bid based on the input price.
     *
     * @param price - Bid price.
     * @return Bid instance or null if no price match found.
     */
    public Bid getBidByPrice(double price) {
        Bid output = null;
        for (Bid i : bids.values()) {
            if (i.getPrice() == price) {
                output = i;
            }
        }
        return output;
    }
}
