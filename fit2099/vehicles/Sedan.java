package Bootcamp06.fit2099.vehicles;

import Bootcamp06.fit2099.exceptions.SedanException;
import Bootcamp06.fit2099.exceptions.VehicleException;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see Vehicle
 */
public class Sedan extends Vehicle{
    /**
     * An int variable for the number of seats in the Sedan.
     */
    private int seats;

    /**
     * A public constructor with randomly generated Vehicle ID.
     *
     * @param make - A String variable for the make of the vehicle.
     * @param model - A String variable for the model of the vehicle.
     * @param seats - An int variable for the number of seats in the Sedan.
     * @throws SedanException - A VehicleException subclass.
     * @throws VehicleException - An Exception subclass.
     */
    public Sedan(String make, String model, int seats) throws SedanException, VehicleException {
        super(make, model);
        if(setSeats(seats)) {
            this.seats = seats;
        } else {
            throw new SedanException("Exception: Incorrect Number of Seats");
        }
    }

    /**
     * A public constructor with user inputted Vehicle ID.
     *
     * @param make - A String variable for the make of the vehicle.
     * @param model - A String variable for the model of the vehicle.
     * @param seats - An int variable for the number of seats in the Sedan.
     * @param vId - User inputted Vehicle ID.
     * @throws SedanException - A VehicleException subclass.
     * @throws VehicleException - An Exception subclass.
     */
    public Sedan(String make, String model, int seats, int vId) throws SedanException, VehicleException {
        super(make, model, vId);
        if(setSeats(seats)) {
            this.seats = seats;
        } else {
            throw new SedanException("Exception: Incorrect Number of Seats");
        }
    }

    /**
     * Sedan's seats setter which also validates the seats input value.
     *
     * @param seats - Input number of seats of the Sedan.
     * @return isValid - Boolean variable which returns true for valid number of seats.
     */
    public boolean setSeats(int seats) {
        boolean isValid = false;
        if(seats >= 4 && seats <= 5){
            isValid = true;
            this.seats = seats;
        }
        return isValid;
    }
}
