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

        //Test 1: The method will return 0 if the TimeSlots are the same
        System.out.println("test 1");
        Time testtime1a = new Time("12:30");
        Date testdate1a = new Date("4/20/2020");
        Timeslot testslot1a = new Timeslot(testdate1a,testtime1a);
        Time testtime1b = new Time("12:30");
        Date testdate1b = new Date("4/20/2020");
        Timeslot testslot1b = new Timeslot(testdate1b,testtime1b);

        if(testslot1a.compareTo(testslot1b) == 0) System.out.println("test 1 passed");
        else System.out.println("test 1 failed");

        //Test 2: First time slot with an earlier hour than second time slot.
        System.out.println("test 2");
        Time testtime2a = new Time("12:30");
        Date testdate2a = new Date("4/20/2020");
        Timeslot testslot2a = new Timeslot(testdate2a,testtime2a);
        Time testtime2b = new Time("15:30");
        Date testdate2b = new Date("4/20/2020");
        Timeslot testslot2b = new Timeslot(testdate2b,testtime2b);

        if(testslot2a.compareTo(testslot2b) == -1) System.out.println("test 2 passed");
        else System.out.println("test 2 failed");

        //Test 3: First time slot with a later hour than second time slot will return 1
        System.out.println("test 3");
        Time testtime3a = new Time("17:30");
        Date testdate3a = new Date("4/20/2020");
        Timeslot testslot3a = new Timeslot(testdate3a,testtime3a);
        Time testtime3b = new Time("15:30");
        Date testdate3b = new Date("4/20/2020");
        Timeslot testslot3b = new Timeslot(testdate3b,testtime3b);

        if(testslot3a.compareTo(testslot3b) == 1) System.out.println("test 3 passed");
        else System.out.println("test 3 failed");

        //Test 4: First time slot with an earlier date than second time slot but with same time will return -1
        System.out.println("test 4");
        Time testtime4a = new Time("17:30");
        Date testdate4a = new Date("3/20/2020");
        Timeslot testslot4a = new Timeslot(testdate4a,testtime4a);
        Time testtime4b = new Time("17:30");
        Date testdate4b = new Date("4/20/2020");
        Timeslot testslot4b = new Timeslot(testdate4b,testtime4b);

        if(testslot4a.compareTo(testslot4b) == -1) System.out.println("test 4 passed");
        else System.out.println("test 4 failed");

        //Test 5: First time slot with an later date than second time slot but with same time will return 1
        System.out.println("test 5");
        Time testtime5a = new Time("17:30");
        Date testdate5a = new Date("5/20/2020");
        Timeslot testslot5a = new Timeslot(testdate5a,testtime5a);
        Time testtime5b = new Time("17:30");
        Date testdate5b = new Date("4/20/2020");
        Timeslot testslot5b = new Timeslot(testdate5b,testtime5b);

        if(testslot5a.compareTo(testslot5b) == 1) System.out.println("test 5 passed");
        else System.out.println("test 5 failed");

        //Test 6: First time slot with an earlier date than second time slot but later time will return -1
        System.out.println("test 6");
        Time testtime6a = new Time("17:30");
        Date testdate6a = new Date("3/20/2020");
        Timeslot testslot6a = new Timeslot(testdate6a,testtime6a);
        Time testtime6b = new Time("15:30");
        Date testdate6b = new Date("4/20/2020");
        Timeslot testslot6b = new Timeslot(testdate6b,testtime6b);

        if(testslot6a.compareTo(testslot6b) == -1) System.out.println("test 6 passed");
        else System.out.println("test 6 failed");

        //Test 7: First time slot with an later date than second time slot but earlier time will return 1
        System.out.println("test 7");
        Time testtime7a = new Time("15:30");
        Date testdate7a = new Date("4/20/2020");
        Timeslot testslot7a = new Timeslot(testdate7a,testtime7a);
        Time testtime7b = new Time("17:30");
        Date testdate7b = new Date("3/20/2020");
        Timeslot testslot7b = new Timeslot(testdate7b,testtime7b);

        if(testslot7a.compareTo(testslot7b) == 1) System.out.println("test 7 passed");
        else System.out.println("test 7 failed");

        //Test 8: First time slot with an later date than second time slot but earlier time will return 1
        System.out.println("test 8");
        Time testtime8a = new Time("17:30");
        Date testdate8a = new Date("2/29/2020");
        Timeslot testslot8a = new Timeslot(testdate8a,testtime8a);
        Time testtime8b = new Time("17:30");
        Date testdate8b = new Date("2/20/2020");
        Timeslot testslot8b = new Timeslot(testdate8b,testtime8b);

        if(testslot8a.compareTo(testslot8b) == 1) System.out.println("test 8 passed");
        else System.out.println("test 8 failed");

        //Test 9: First time slot with an later date than second time slot but earlier time will return 1
        System.out.println("test 9");
        Time testtime9a = new Time("16:30");
        Date testdate9a = new Date("2/28/2022");
        Timeslot testslot9a = new Timeslot(testdate9a,testtime9a);
        Time testtime9b = new Time("17:30");
        Date testdate9b = new Date("12/31/2020");
        Timeslot testslot9b = new Timeslot(testdate9b,testtime9b);

        if(testslot9a.compareTo(testslot9b) == 1) System.out.println("test 9 passed");
        else System.out.println("test 9 failed");

    }

}
