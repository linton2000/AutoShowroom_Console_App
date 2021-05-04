package Bootcamp06.fit2099.exceptions;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 * @see Exception
 */
public class VehicleException extends Exception{

    /**
     * Public constructor which calls the parent class Exception's constructor.
     *
     * @param message - The message returned by Exception.getMessage().
     */
    public VehicleException(String message) {
        super(message);
    }
}
