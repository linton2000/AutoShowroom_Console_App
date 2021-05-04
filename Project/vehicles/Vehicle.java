package Bootcamp06.fit2099.vehicles;

import Bootcamp06.fit2099.Utils;
import Bootcamp06.fit2099.exceptions.VehicleException;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 */
abstract public class Vehicle {
    /**
     * A String variable for the make of the vehicle.
     */
    private String make;
    /**
     * A String variable for the model of the vehicle.
     */
    private String model;
    /**
     * An int variable for the ID of the vehicle.
     */
    private int vId;

    /**
     * This constructor uses a random vId and validates inputs.
     *
     * @param newMake - The make of the vehicle in String type.
     * @param newModel - The model of the vehicle in String type.
     * @throws VehicleException - An Exception subclass.
     */
    public Vehicle(String newMake, String newModel) throws VehicleException {
        if (setMake(newMake) && setModel(newModel)) {
            make = newMake;
            model = newModel;
            vId = Utils.nextID(10000, 99999);
        } else throw new VehicleException("Exception: Incorrect Make OR Model");
    }

    /**
     * This constructor uses a user inputted vId and validates inputs.
     *
     * @param make - The make of the vehicle in String type.
     * @param model - The model of the vehicle in String type.
     * @param vId - The ID of the vehicle in int type.
     * @throws VehicleException - An Exception subclass.
     */
    public Vehicle(String make, String model, int vId) throws VehicleException {
        if (setMake(make) && setModel(model)) {
            this.make = make;
            this.model = model;
            assert vId > 10000 && vId < 99999;
            this.vId = vId;
        } else throw new VehicleException("Exception: Incorrect Make OR Model");
    }

    /**
     * Vehicle ID getter
     * @return vId - Vehicle's ID
     */
    public int getvId() {
        return vId;
    }

    /**
     * Vehicle's make setter which also validates the make input value.
     *
     * @param make - Input make of the vehicle.
     * @return isValid - Boolean variable which returns true for valid make input.
     */
    public boolean setMake(String make) {
        boolean isValid = false;
        if(make.length() >= 3 && make.length() <= 15){
            isValid = true;
            this.make = make;
        }
        return isValid;
    }

    /**
     * Vehicle's model setter which also validates the model input value.
     *
     * @param model - Input model of the vehicle.
     * @return isValid - Boolean variable which returns true for valid model input.
     */
    public boolean setModel(String model) {
        boolean isValid = false;
        if(model.length() >= 3 && model.length() <= 15){
            isValid = true;
            this.model = model;
        }
        return isValid;
    }

    /**
     * Outputs a brief description of the vehicle.
     *
     * @return make, model and vId concatenated together.
     */
    public String description() {
        return make + " " + model + " [ID: " + vId + "]";
    }
}
