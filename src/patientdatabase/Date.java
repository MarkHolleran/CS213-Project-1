package patientdatabase;

import java.util.Calendar;

//must implement the constructors & methods listed
//implement the Comparable Interface and implement the compareTo() method

//cannot change or add instance variable and CANNOT use System.out statments except in the testbed main()


public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

//not sure if allowed to put these here

    public static final int DAYS_IN_APRIL = 30;
    public static final int DAYS_IN_JUNE = 30;
    public static final int DAYS_IN_SEPTEMBER = 30;
    public static final int DAYS_IN_NOVEMBER = 30;

    public static final int JANUARY = 1;
    public static final int FEBUARY = 2;
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
    public static final int DAYS_IN_FEBUARY_LEAP = 29;
    public static final int DAYS_IN_FEBUARY_NONLEAP = 28;
    public static final int MIN_DAY = 1;
    public static final int MAX_DAYS_FOR_APRIL_JUNE_SEPTEMBER_NOVEMBER = 30;
    public static final int MAX_DAYS_FOR_MAY_DECEMBER_OCTOBER_JULY_AUGUST_MARCH_JANUARY = 31;

    public int getDay(){

        return day;
    }
    public int getYear(){

        return year;
    }
    public int getMonth(){

        return month;
    }
    public String toString(){

        return getMonth()+"/"+getDay()+"/"+getYear();
    }


    public Date(String data) { //take mm/dd/yyy and create date object

        String dateFromInput = data;

        this.month = Integer.parseInt(dateFromInput.substring(0, dateFromInput.indexOf("/")));
        this.day = Integer.parseInt(dateFromInput.substring(dateFromInput.indexOf("/")+1,dateFromInput.lastIndexOf("/")));
        this.year = Integer.parseInt(dateFromInput.substring(dateFromInput.lastIndexOf("/")+1,dateFromInput.length()));

    }

    public Date() {//creating a date object with today's date

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MONTH, 1);
        // added 1 because java thinks april is 3rd month of the year

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);

    }

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

        if (month > MAX_MONTH || month < MIN_YEAR) {     //if month is not 1-12 return falase

            monthValid = false;

        } else {

            monthValid = true;

        }
        if (month == MAY || month == DECEMBER || month == OCTOBER || month == MARCH || month == AUGUST || month == JULY) {                 //months that all are 31 days in length

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

        } else if (month == FEBUARY) {

            if (leapYearChecker() == false && day <= DAYS_IN_FEBUARY_NONLEAP && day >= MIN_DAY) {

                dayValid = true;

            } else if (leapYearChecker() == true && day <= DAYS_IN_FEBUARY_LEAP && day >= MIN_DAY) {

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

    //don't use magic numbers instead do like
    //public static final int EXAMPLE = 4;

    //must design test cases to thoroughly test the isValid() method
    //must write testbed main and implement the test cases

    //follow the instructions in the 'test design' section of the project formatting PDF
    //must write code to print out the test results to the console showing the test cases are passed or failed

    //please use "//" comments to identify the test case numbers in the testbed main

    @Override
    public int compareTo(Date date) {
        //return -1 1 or 0 based on date
        int day = this.day;
        int month = this.month;
        int year = this.year;

        int dayCompare = date.day;
        int monthCompare = date.month;
        int yearCompare = date.year;

        if (year > yearCompare) {
            //if year is greater than parameter year
            return 1;

        } else if (year == yearCompare) {
            //same year so check months
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
        //not sure what to put here so i just returned 0
    }


    public static void main (String[]args){

        Date datetest = new Date();

        Date inputdate = new Date("12/31/1999");

        System.out.println("day "+inputdate.day);
        System.out.println("month "+ inputdate.month);
        System.out.println("year "+inputdate.year);

        System.out.println(datetest.compareTo(inputdate));

    }
}





