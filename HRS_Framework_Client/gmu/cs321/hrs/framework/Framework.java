package gmu.cs321.hrs.framework;
/**
 * Hotel Reservation System Framework for CS 321
 * This class is used for supporting the client side inputs with static values representing hotel operations
 * 1. Version 1.0 with all framework backbone and functional server to store reservation and customer objects
 * 2. Version 2.0 with data encapsulation
 * 3. Version 3.0 removed persistent data storage and methods for reservations and customers
 * @author CS 321 TA (O'Saben, Erich Kristian, Han Tsung Liu)
 * @version 3.0, 30 Mar 2017
 */
import java.io.FileNotFoundException;
public class Framework {
	/** number of single rooms */
    public static final int NUM_SINGLE_ROOMS = 5;
    /** number of double rooms */
    public static final int NUM_DOUBLE_ROOMS = 5;
    /** number of days */
    public static final int NUM_DAYS = 31;
    /** single room rate per day */
    public static final int SINGLE_RATE = 80;
    /** double room rate per day */
    public static final int DOUBLE_RATE = 100;
    /** the room is reserved */
    public static final int STATUS_RESERVED = 1;
    /** the room has been checked in */
    public static final int STATUS_CHECKED_IN = 2;
    /** the room has been checked out */
    public static final int STATUS_CHECKED_OUT = 3;
    /** the room has not been checked in */
    public static final int STATUS_NO_SHOW = 4;
    /** the room is marked as must pay */
    public static final int STATUS_MUST_PAY = 5;
    /** parser object for input files to run framework */
    private static Parser parser;
    /**
     * initialize the framework to parse the given filename
     * @param filename String to read the contents of the file
     * @throws FileNotFoundException if filename is not a valid file
     */
    public static void init(String filename) throws FileNotFoundException {
        parser = new Parser(filename); // initialize the framework by receiving a file from parser
        // throws exception if file not found
    }
    /**
     * reads the parser to determine whether there's next instruction
     * @return true if there is one or more lines of instructions in the file, else returns false
     */
    public static boolean hasNextInstruction() {
        return parser.hasNextInstruction(); // see if parser has anymore instruction
    }
    /**
     * reads the parser to retrieve all lines in file for the next instruction
     * @return all lines for the next instructions in a collection using a string array 
     */
    public static String[] nextInstruction() {
        return parser.getNextInstruction(); // gets the next instruction from parser
    }
}
