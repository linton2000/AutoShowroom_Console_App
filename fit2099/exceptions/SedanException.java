package Bootcamp06.fit2099.exceptions;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see VehicleException
 */
public class SedanException extends VehicleException{

    /**
     * Public constructor which calls the parent class VehicleException's constructor.
     *
     * @param message - The message returned by Exception.getMessage().
     */
    public SedanException(String message) {
        super(message);
    }
}
