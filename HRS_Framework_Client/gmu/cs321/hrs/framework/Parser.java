package gmu.cs321.hrs.framework;
/**
 * Hotel Reservation System Parser for CS 321
 * This class is used for supporting the client side inputs with static values representing hotel operations
 * 1. Version 1.0 with supporting functions for reading in file instructions by collections
 * @author CS 321 TA (O'Saben, Erich Kristian, Han Tsung Liu)
 * @version 1.0, 30 Mar 2017
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
public class Parser {
	/** filename read in from the constructor */
    private String filename;
    /** scanner object for reading in the file */
    private Scanner scan;
    /** next instruction read in from file
     * 1 = Make a Reservation 
     * 2 = Check In
     * 3 = Check Out
     * 4 = Print Management Report
     * 5 = Day Change (move to next day)
     * 6 = 6pm Alarm (automatic cancellation for non-guaranteed)
     */
    private Integer nextInstruction;
    /**
     * constructor
     * @param filename String to read the contents of the file
     * @throws FileNotFoundException if filename is not a valid file
     */
    public Parser(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.scan = new Scanner(new FileReader(filename));
        nextInstruction = -1;
        //prime the parser with the next line of input
        if (scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            if (nextLine.startsWith("@")) {
                nextInstruction = Integer.parseInt(nextLine.substring(1));
            }
        }
    }
    /**
     * reads the file to determine whether there's next instruction
     * @return true if the input file contains another instruction and false otherwise
     */
    public boolean hasNextInstruction() {
        if (nextInstruction == -1) {
            return false;
        }
        return true;
    }
    /**
     * reads the parser to retrieve all lines in file for the next instruction
     * @return all lines for the next instructions in a collection using a string array 
     */
    public String[] getNextInstruction() {
        if (!hasNextInstruction()) {
            return null;
        }
        //list for storing this instruction's data
        ArrayList<String> data = new ArrayList<String>();
        //add the instruction number to the data
        data.add(nextInstruction.toString());
        while (true) {
            if (scan.hasNextLine()) {
                String nextLine = scan.nextLine().trim();
                //if this line is only whitespace, skip it
                if (nextLine.isEmpty()) {
                    continue;
                }
                //finished gathering data
                if (nextLine.startsWith("@")) {
                    nextInstruction = Integer.parseInt(nextLine.substring(1));
                    return data.toArray(new String[data.size()]);
                }
                //add data
                else {
                    data.add(nextLine);
                }
            }
            else {
                nextInstruction = -1;
                return data.toArray(new String[data.size()]);
            }
        }
    }
}
