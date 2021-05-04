package Bootcamp06.fit2099;

import java.util.Random;

/**
 * @author Linton Charles (lcha0052@student.monash.edu)
 * @version 1.0
 */
public class Utils {

    /**
     * Generates a random ID between two values.
     *
     * @param low - An integer representing minimum ID value.
     * @param high - Maximum ID integer value.
     * @return The randomly generated ID.
     */
    public static int nextID(int low, int high) {
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }

    public static void print(String message){
        System.out.print("\n" + message);
    }

    public static void println(String message){
        System.out.println("\n" + message);
    }
}
