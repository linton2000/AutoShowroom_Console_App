package Bootcamp06.fit2099.buyers;

import Bootcamp06.fit2099.Utils;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 */
public class Buyer {
    /**
     * An int variable for the ID of the buyer.
     */
    private int buyerId;
    /**
     * A String variable for the buyer's given name.
     */
    private String givenName;
    /**
     * A String variable for the buyer's family name.
     */
    private String familyName;

    /**
     * A public constructor with 1 parameter.
     *
     * @param buyerId - The ID of the buyer.
     */
    private Buyer(int buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * A public constructor with 3 parameters.
     *
     * @param buyerId - The ID of the buyer.
     * @param givenName - The Given Name of the buyer.
     * @param familyName - The Family Name of the buyer.
     */
    private Buyer(int buyerId, String givenName, String familyName) {
        this.buyerId = buyerId;
        this.givenName = givenName;
        this.familyName = familyName;
    }

    /**
     * A static factory method that validates inputs and returns a newly constructed Buyer instance.
     *
     * @param givenName - The Given Name of the buyer.
     * @param familyName - The Family Name of the buyer.
     * @return newBuyer if valid input or null if invalid.
     */
    public static Buyer getInstance(String givenName, String familyName){
        Buyer newBuyer = new Buyer(Utils.nextID(1000, 9999));
        if(newBuyer.setFamilyName(familyName) && newBuyer.setGivenName(givenName))
        {
            return newBuyer;
        } else{
            return null;
        }
    }

    /**
     * Validates and then sets the given name of the buyer.
     *
     * @param givenName - Input given name of the buyer.
     * @return isValid - Boolean variable which returns true for valid given name input.
     */
    public boolean setGivenName(String givenName) {
        boolean isValid = false;
        if(givenName.length() >= 2 && givenName.length() <= 15){
            isValid = true;
            this.givenName = givenName;
        }
        return isValid;
    }

    /**
     * Validates and then sets the family name of the buyer.
     *
     * @param familyName - Input family name of the buyer.
     * @return isValid - Boolean variable which returns true for valid family name input.
     */
    public boolean setFamilyName(String familyName) {
        boolean isValid = false;
        if(familyName.length() >= 2 && familyName.length() <= 15){
            isValid = true;
            this.familyName = familyName;
        }
        return isValid;
    }

    /**
     * Outputs a brief description of the buyer.
     *
     * @return givenName, familyName and buyerId all concatenated together.
     */
    public String description() {
        return givenName + " " + familyName + " [ID: " + buyerId + "]";
    }
}
