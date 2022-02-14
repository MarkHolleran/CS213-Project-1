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
     * @param hour int for hours
     * @param minute int for minutes
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
     * @param inputTime String in the form of HH:MM
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
     * @return true or false based on Time validity
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
     * to compensate for format.
     *
     * @return String representation of Time object
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
     * Compares a Time object with another Time object
     * Compares Hour and then the time of the Time object
     * and inputted Time object.
     * Returns 1 if the Time object is greater than the
     * inputted time object.
     * Returns -1 if the Time object is less than the
     * inputted time object.
     * Returns 0 if the both the Time objects are equal.
     *
     * @param time Time object for comparison with another Time object
     *
     * @return -1 0 or 1 based on result of comparison
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
