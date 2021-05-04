package Bootcamp06.fit2099.vehicles;

import Bootcamp06.fit2099.exceptions.TruckException;
import Bootcamp06.fit2099.exceptions.VehicleException;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see Vehicle
 */
public class Truck extends Vehicle{
    /**
     * An int variable for the capacity of the Truck.
     */
    private int capacity;
    /**
     * An int variable for the number of wheels in the Truck.
     */
    private int wheels;

    /**
     * A public constructor with randomly generated Vehicle ID.
     *
     * @param newMake - A String variable for the make of the vehicle.
     * @param newModel - A String variable for the model of the vehicle.
     * @param capacity - An int variable for the capacity of the Truck.
     * @param wheels - An int variable for the number of wheels in the Truck.
     * @throws TruckException - A VehicleException subclass.
     * @throws VehicleException - An Exception subclass.
     */
    public Truck(String newMake, String newModel, int capacity, int wheels) throws TruckException, VehicleException {
        super(newMake, newModel);
        if (setWheels(wheels) && setCapacity(capacity)) {
            this.capacity = capacity;
            this.wheels = wheels;
        } else{
            throw new TruckException("Exception: Incorrect Wheels OR Capacity");
        }
    }

    /**
     * A public constructor with user inputted Vehicle ID.
     *
     * @param make - A String variable for the make of the vehicle.
     * @param model - A String variable for the model of the vehicle.
     * @param vId - User inputted Vehicle ID.
     * @param capacity - An int variable for the capacity of the Truck.
     * @param wheels - An int variable for the number of wheels in the Truck.
     * @throws TruckException - A VehicleException subclass.
     * @throws VehicleException - An Exception subclass.
     */
    public Truck(String make, String model, int vId, int capacity, int wheels) throws TruckException, VehicleException {
        super(make, model, vId);
        if (setWheels(wheels) && setCapacity(capacity)) {
            this.capacity = capacity;
            this.wheels = wheels;
        } else{
            throw new TruckException("Exception: Incorrect Wheels OR Capacity");
        }
    }

    /**
     * Truck's wheels setter which also validates the wheels input value.
     *
     * @param wheels - Input number of wheels of the Truck.
     * @return isValid - Boolean variable which returns true for valid number of wheels.
     */
    public boolean setWheels(int wheels) {
        boolean isValid = false;
        if(wheels >= 4 && wheels <= 16){
            isValid = true;
            this.wheels = wheels;
        }
        return isValid;
    }

    /**
     * Truck's capacity setter which also validates the capacity input value.
     *
     * @param capacity - Input capacity of the Truck.
     * @return isValid - Boolean variable which returns true for valid capacity.
     */
    public boolean setCapacity(int capacity) {
        boolean isValid = false;
        if(capacity >= 1 && capacity <= 15){
            isValid = true;
            this.capacity = capacity;
        }
        return isValid;
    }
}
