package patientdatabase;

import java.util.Calendar;


//must implement the constructors & methods listed
//implement the Comparable Interface and implement the compareTo() method

//cannot change or add instance variable and CANNOT use System.out statments except in the testbed main()


public class Date implements Comparable<Date> {

private int year;
private int month;
private int day;

public Date(String data){ //take mm/dd/yyy and create date object

    String dateToBeCreated = data;

    //"12/12/2011"

    this.month = Integer.parseInt(dateToBeCreated.substring(0,2));
    this.day = Integer.parseInt(dateToBeCreated.substring(3,5));
    this.year = Integer.parseInt(dateToBeCreated.substring(6,10));

}

public Date()

{
    this.year = Calendar.YEAR;
    this.month = Calendar.MONTH;
    this.day = Calendar.DAY_OF_MONTH;

} //create an obj with todays date

    public boolean isValid() {

    boolean monthValid;

    boolean yearValid;

    return true;
    }

    private boolean leapYearChecker (Date date){

    int isYearValid = date.year;

        if (isYearValid % 4 == 0) {

            if (isYearValid % 100 == 0) {

                if (isYearValid % 400 == 0) {

                    return true;

                } else {

                    return false;
                }

            } else {

                if (isYearValid % 400 == 0) {

                    return true;

                } else {

                    return false;
                }

                //return true;


            }

        } else {

            return false;
        }



    }
    //checks if a date is a valid calendar date

    //take into account: January, March,May, July, August, October, December each have 31 days
    //April, June, September, and November each have 30 days
    //February has 28 days in a non leap year and 29 days in a leap year

    //don't use magic numbers instead do like
    //public static final int EXAMPLE = 4;

    //for determining if a leap year or not

    //1. if year is evenly divided by 4 go to 2.  otherwise go to .5
    //2. if year is evenly divided by 100 go to step 3.   otherwise go to 4.
    //3. if year is even divided by 400 go to 4.   otherwise go to .5
    //4. this year is a leap year
    //5. this is not a leap year

    //must design test cases to thoroughly test the isValid() method
    //must write testbed main and implement the test cases

    //follow the instructions in the 'test design' section of the project formatting PDF
    //must write code to print out the test results to the console showing the test cases are passed or failed

    //please use "//" comments to identify the test case numbers in the testbed main

    @Override
    public int compareTo(Date date){

    return 0;
    }

    public static void main(String[] args){


    Date datetest = new Date();

    System.out.println("should be current date" + datetest.year);
    
        System.out.println("should be current date" + Calendar.YEAR);
    System.out.println("the date we're trying to input is " + "12/12/2011" +datetest.toString());

    System.out.println("day is " + datetest.day);
    System.out.println("month is " + datetest.month);
    System.out.println("year is " + datetest.year);




    }



}


