package patientdatabase;

import java.util.Calendar;

/**
 * Class that stores date from String input
 *
 * String is broken down into MM DD YYYY components
 * and stored in a Date object.
 * @author Mark Holleran, Abhitej Bokka
 */

public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    public static final int DAYS_IN_APRIL = 30;
    public static final int DAYS_IN_JUNE = 30;
    public static final int DAYS_IN_SEPTEMBER = 30;
    public static final int DAYS_IN_NOVEMBER = 30;

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    public static final int MIN_YEAR = 1;
    public static final int MAX_YEAR = 2022;

    public static final int MAX_MONTH = 12;
    public static final int MIN_MONTH = 1;
    public static final int DAYS_IN_FEBRUARY_LEAP = 29;
    public static final int DAYS_IN_FEBRUARY_NONLEAP = 28;
    public static final int MIN_DAY = 1;
    public static final int MAX_DAYS_FOR_APRIL_JUNE_SEPTEMBER_NOVEMBER = 30;
    public static final int MAX_DAYS_FOR_MAY_DECEMBER_OCTOBER_JULY_AUGUST_MARCH_JANUARY = 31;

    /**
     * Creates a Date object with today's date
     * Using Java's Calendar Library an instance of
     * today's date is created.
     */
    public Date() {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MONTH, 1); //One is added because Java's Calendar Library Makes January Month 0

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * Creates a Date object given a String input
     * MM DD & YYYY are chosen by using the .indexOf Parameter
     * in the Java String class to split the String by "/"
     *
     * @param date String in the form of MM/DD/YYYY
     */
    public Date(String date) { //take mm/dd/yyy and create date object

        String dateFromInput = date;

        this.month = Integer.parseInt(dateFromInput.substring(0, dateFromInput.indexOf("/")));
        this.day = Integer.parseInt(dateFromInput.substring(dateFromInput.indexOf("/")+1,dateFromInput.lastIndexOf("/")));
        this.year = Integer.parseInt(dateFromInput.substring(dateFromInput.lastIndexOf("/")+1,dateFromInput.length()));

    }

    /**
     * Returns Day from Date object
     *
     * @return Integer value representing Day
     */
    public int getDay(){

        return this.day;

    }

    /**
     * Returns Year from Date object
     *
     * @return Integer value representing Year
     */
    public int getYear(){

        return this.year;

    }

    /**
     * Returns Month from Date object
     *
     * @return Integer value representing Month
     */
    public int getMonth(){

        return this.month;

    }

    /**
     * Returns Date object as a String
     *
     * @return String representation of Date object
     */
    public String toString(){

        return getMonth()+"/"+getDay()+"/"+getYear();

    }

    /**
     * Checks Date object for correctness
     * Month, Day, and Year are checked
     * to see if the date is correct or not.
     * Accounts for Months that have either 30 or 31
     * days in a Month as well as if it's a Leap year.
     *
     * @return True or False based on Date validity
     */
    public boolean isValid() {

        boolean monthValid = false;
        boolean yearValid = false;
        boolean dayValid = false;

        Date currentYear = new Date();

        if (year < MIN_YEAR || year > MAX_YEAR) {

            yearValid = false;

        } else {

            yearValid = true;

        }

        if (month > MAX_MONTH || month < MIN_MONTH) {     //if month is not 1-12 return falase

            monthValid = false;

        } else {

            monthValid = true;

        }
        if (month == MAY || month == DECEMBER || month == OCTOBER || month == MARCH || month == AUGUST || month == JULY || month == JANUARY) {

            if (day > MAX_DAYS_FOR_MAY_DECEMBER_OCTOBER_JULY_AUGUST_MARCH_JANUARY || day < MIN_DAY) {

                dayValid = false;

            } else {

                dayValid = true;

            }

        } else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) {

            if (day > MAX_DAYS_FOR_APRIL_JUNE_SEPTEMBER_NOVEMBER || day < MIN_DAY) {

                dayValid = false;

            } else {

                dayValid = true;

            }

        } else if (month == FEBRUARY) {

            if (leapYearChecker() == false && day <= DAYS_IN_FEBRUARY_NONLEAP && day >= MIN_DAY) {

                dayValid = true;

            } else if (leapYearChecker() == true && day <= DAYS_IN_FEBRUARY_LEAP && day >= MIN_DAY) {

                dayValid = true;

            } else {

                dayValid = false;

            }

        }

        if (monthValid == true && yearValid == true && dayValid == true) {

            return true;

        } else {

            return false;
        }
    }

    /**
     * Checks if the year is a leap year or not.
     * Only ran when the Month is February
     * to determine if February should have 28 or 29
     * days in a Month.
     *
     * @return True or false if Year is a leap year
     */
    private boolean leapYearChecker() {

        int isYearValid = year;

        if (isYearValid % 4 == 0) {

            if (isYearValid % 100 == 0) {

                if (isYearValid % 400 == 0) {

                    return true;

                } else {

                    return false;
                }

            } else {

                return true;
            }
        } else {

            return false;
        }
    }

    /**
     *Compares a Date object with another Date object
     * Compares Month, Day, and Year of both Date objects
     * Returns 1 if Date object's date is greater
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
    public int compareTo(Date date) {

        int day = this.day;
        int month = this.month;
        int year = this.year;

        int dayCompare = date.day;
        int monthCompare = date.month;
        int yearCompare = date.year;

        if (year > yearCompare) {

            return 1;

        } else if (year == yearCompare) {

            if (month > monthCompare) {

                return 1;

            } else if (month == monthCompare) {

                if (day > dayCompare) {

                    return 1;

                } else if (day < dayCompare) {

                    return -1;

                } else if (day == dayCompare) {

                    return 0;
                }
            } else if (month < monthCompare) {

                return -1;
            }

            return -1;

        } else if (year < yearCompare) {

            return -1;

        }

        return 0;

    }

    /**
     * Testbed Main for the testing of the isValid() method in this class
     *
     * @param args Command line arguments
     */
    public static void main (String[]args){

        //Test 1: Month is > 12
        System.out.println("test 1");
        Date test1 = new Date("13/13/2022");
        if (test1.isValid()) System.out.println("test 1 failed");
        else System.out.println("test 2 passed");

        //Test 2: Month is < 1
        System.out.println("test 2");
        Date test2 = new Date("0/13/2022");
        if (test2.isValid()) System.out.println("test 2 failed");
        else System.out.println("test 2 passed");

        //Test 3: Day is over max day for a month with a max of 31 days
        System.out.println("test 3");
        Date test3 = new Date("12/32/2022");
        if (test3.isValid()) System.out.println("test 3 failed");
        else System.out.println("test 3 passed");

        //Test 4: Day is over max day for a month with a max of 30 days  (september )
        System.out.println("test 4");
        Date test4 = new Date("4/31/2022");
        if (test4.isValid()) System.out.println("test 4 failed");
        else System.out.println("test 4 passed");

        //Test 5: day is less than 1
        System.out.println("test 5");
        Date test5 = new Date("5/0/2022");
        if (test5.isValid()) System.out.println("test 5 failed");
        else System.out.println("test 5 passed");

        //Test 6: year is above max year (2022)
        System.out.println("test 6");
        Date test6 = new Date("4/12/2024");
        if (test6.isValid()) System.out.println("test 6 failed");
        else System.out.println("test 6 passed");

        //Test 7: No input for date (default constructor for today's date)
        System.out.println("test 7");
        Date test7 = new Date();
        if (!test7.isValid()) System.out.println("test 7 failed");
        else System.out.println("test 7 passed");

        //Test 8: 29 days for february on a leapyear
        System.out.println("test 8");
        Date test8 = new Date("2/29/2020");
        if (!test8.isValid()) System.out.println("test 8 failed");
        else System.out.println("test 11 passed");

        //Test 9: 28 days in february when non leapyear
        System.out.println("test 9");
        Date test9 = new Date("2/29/2021");
        if (test9.isValid()) System.out.println("test 9 failed");
        else System.out.println("test 9 passed");

    }
}





