package Bootcamp06.fit2099.bids;

import Bootcamp06.fit2099.buyers.Buyer;
import Bootcamp06.fit2099.exceptions.BidException;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see Buyer
 */
public class Bid {
    /**
     * An int variable for the ID of the bid.
     */
    private int bidId;
    /**
     * A instance of the Buyer class.
     */
    private Buyer buyer;
    /**
     * A double variable for the price of the bid.
     */
    private double price;
    /**
     * A String variable for the date of the bid.
     */
    private String date;

    /**
     * Public constructor without a Buyer input instance.
     *
     * @param bidId - An int variable for the ID of the bid.
     * @param date - A String variable for the date of the bid.
     * @param price -  A double variable for the price of the bid.
     * @throws BidException - An Exception subclass.
     */
    public Bid(int bidId, String date, double price) throws BidException {
        if(setDate(date) && setPrice(price)) {
            this.bidId = bidId;
            this.price = price;
            this.date = date;
        } else {
            throw new BidException("Exception: Incorrect Date or Price.");
        }
    }

    /**
     * Public constructor with a Buyer input instance.
     *
     * @param bidId - An int variable for the ID of the bid.
     * @param date - A String variable for the date of the bid.
     * @param price -  A double variable for the price of the bid.
     * @throws BidException - An Exception subclass.
     */
    public Bid(int bidId, String date, double price, Buyer buyer) throws BidException {
        if (setDate(date) && setPrice(price)) {
            this.bidId = bidId;
            this.price = price;
            this.date = date;
            this.buyer = buyer;
        } else {
            throw new BidException("Exception: Incorrect Date or Price.");
        }
    }
    /**
     * Bid Id getter.
     * @return bidId - Bid's ID.
     */
    public double getId() {
        return bidId;
    }

    /**
     * Bid price getter.
     * @return price - Bid price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Bid's price setter which also validates the price input value.
     *
     * @param price - Input price of the bid.
     * @return isValid - Boolean variable which returns true for valid price input.
     */
    public boolean setPrice(double price) {
        boolean isValid = false;
        if(price > 0) {
            isValid = true;
            this.price = price;
        }
        return isValid;
    }

    /**
     * Bid date getter.
     * @return date - Bid date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Bid's date setter which also validates the date input value.
     *
     * @param date - Input date of the bid.
     * @return isValid - Boolean variable which returns true for valid date input.
     */
    public boolean setDate(String date) {
        boolean isValid = false;
        String[] dateArray = date.split("/");
        if(dateArray.length == 3){
            int day = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            if(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1930 && year <= 2021) {
                isValid = true;
                this.date = date;
            }
        }
        return isValid;
    }

    /**
     * Outputs a brief description of the bid.
     *
     * @return bidId, price and date all concatenated together.
     */
    public String description() {
        return "Bid ID: " + bidId + " is a bid placed for $" + price + " on " + date;
    }
}
