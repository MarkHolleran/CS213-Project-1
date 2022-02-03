package patientdatabase;


//must implement the constructors & methods listed
//implement the Comparable Interface and implement the compareTo() method

//cannot change or add instance variable and CANNOT use System.out statments except in the testbed main()


public class Date {

private int year;
private int month;
private int day;

pulic Date(String data){

}

public Date(){}

    public boolean isValid(){}
    //checks if a date is a valid calendar date

    //take into account: January, March,May, July, August, October, December each have 31 days
    //April, June, September, and November each have 30 days
    //Februaryhas 28 days in a non leap year and 29 days in a leap year

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
    public int compareTo(Date date){}



}
