package patientdatabase;

/**
 * Class that stores Date and Time objects into a Timeslot object
 *
 * Timeslot object consists of a Date object and a Time object.
 * The Date Object consists of year, month, and day
 * and the Time object consists of hour, and minute
 * @author Mark Holleran, Abhitej Bokka
 */

public class Timeslot implements Comparable<Timeslot>{

    private Date date;
    private Time time;

    /**
     * Creates a Timeslot object containing a Date and Time object
     *
     * @param date Date object
     * @param time Time object
     */
    public Timeslot (Date date, Time time){

        this.date = date;
        this.time = time;
    }

    /**
     * Returns the Date from a Timeslot object
     *
     * @return Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns the Time from a Timeslot object
     *
     * @return Time object
     */
    public Time getTime() {
        return time;
    }

    /**
     * Returns Date and Time objects within a Timeslot object as a String
     *
     * @return String containing month, day, and year from Date object
     * along with hour and minute from Time object all within a Timeslot object
     */
    @Override
    public String toString() {

        if(time.getMinute() == 0){

            return " Appointment detail: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ", "
                    + time.getHour() + ":0" + time.getMinute() + "," ;

        }else{

            return " Appointment detail: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ", "
                    + time.getHour() + ":" + time.getMinute() + "," ;

        }
    }

    /**
     * Returns an Integer value based on the values
     * of the comparison between two Timeslot objects
     *
     * @param slot Timeslot Object
     *
     * @return returns 0 if both Timeslot objects are equal,
     * otherwise returns the difference them
     */
    @Override
    public int compareTo(Timeslot slot){

        int dateDifference = Integer.compare(this.date.getYear(), slot.date.getYear());

        if (dateDifference != 0) {

            return dateDifference;
        }

        dateDifference = Integer.compare(this.date.getMonth(), slot.date.getMonth());

        if (dateDifference != 0) {

            return dateDifference;
        }

        dateDifference = Integer.compare(this.date.getDay(), slot.date.getDay());

        if (dateDifference != 0) {

            return dateDifference;
        }

        int hourDifference = Integer.compare(this.time.getHour(), slot.time.getHour());

        if (hourDifference != 0) {

            return hourDifference;
        }

        int minDifference = Integer.compare(this.time.getMinute(), slot.time.getMinute());

        return minDifference;

    }


    /**
     * Testbed Main for the testing of the compareTo() method in this class
     *
     * @param args Command line arguments
     */
    public static void main(String[] args){

        //Test 1:
        System.out.println("test 1");
        Time testtime1 = new Time("12:30");
        Date testdate1 = new Date("4/20/2020");
        Timeslot testslot = new Timeslot(testdate1,testtime1);

        /*
        if (test12.isValid()) System.out.println("test 1 failed");
        else System.out.println("test 1 passed");
        */
        //Test 2:
        //Test 3:
        //Test 4:
        //Test 5:
        //Test 6:
        //Test 7:
        //Test 8:
        //Test 9:
        //Test 10:
        //Test 11:

    }

}
