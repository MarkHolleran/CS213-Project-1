package patientdatabase;

import java.util.StringTokenizer;

/**
 * Class that stores time from String input
 *
 * String is broken down into HH MM components
 * and stored in a Time object.
 * @author Abhitej Bokka, Mark Holleran
 */
public class Time implements Comparable<Time>{

    private int hour;
    private int minute;

    /**
     * Creates a Time object given an input of two integers.
     *
     * @param
     */
    public Time(int hour, int minute){

        this.hour = hour;
        this.minute = minute;

    }

    /**
     * Creates a Time object given a String input.
     * Hour & Month are chosen by parsing the String Parameter
     * with String Tokenizer and splitting by ":"
     *
     * @param time String in the form of HH:MM
     */
    public Time(String inputTime){

        String newTime = inputTime;

        StringTokenizer segmentedTime = new StringTokenizer(inputTime,":");

        this.hour = Integer.parseInt(segmentedTime.nextToken());
        this.minute = Integer.parseUnsignedInt((segmentedTime.nextToken()));

    }

    /**
     * Returns Hour from Time object
     *
     * @return Integer value representing Hour
     */
    public int getHour(){
        return hour;
    }
    /**
     * Returns Minute from Time object
     *
     * @return Integer value representing Minute
     */
    public int getMinute(){
        return minute;
    }

    /**
     * Checks Time object to meet specifications of appointment time slots.
     * Hour and Minute are checked to see if they are in between the opening
     * for the clinic and are of 15 minute intervals
     *
     * @return True or False based on Time validity
     */
    public boolean isValid(){
        if (hour < 9 || hour > 16 || minute % 15 != 0 || minute < 0 || minute > 45){
            return false;
        }
        return true;
    }

    /**
     * Returns Time object as a String
     * If the minute is 0, it simply adds an extra 0
     * to compensate for format
     *
     * @return String representation of Date object
     */
    @Override
    public String toString(){
        if(minute == 0){
            return hour + ":0" + minute;
        }else{
            return hour + ":" + minute;
        }

    }

    /**
     *Compares a Time object with another Time object
     * Compares Hour and Minute of both Time objects
     * Returns 1 if Time object's time is greater
     * than the input Date's date,
     * Returns -1 if Date object's date is less
     * than the input Date's date, and
     * Returns 0 if Both the Date object's date
     * and the input Date's date are the same.
     *
     * @param date Date object for comparison with another Date object
     *
     * @return 1 -1 or 0 based on result of comparison
     */
    @Override
    public int compareTo(Time time){
        int hourDifference = Integer.compare(this.hour, time.hour);
        if (hourDifference != 0) {
            return hourDifference;
        }

        int minDifference = Integer.compare(this.minute, time.minute);
        return minDifference;
    }

}
