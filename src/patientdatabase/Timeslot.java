package patientdatabase;

//implement the comparable interface and implement hte compareTo() method

//cannot change or add instance variables and cannot use System.out statements unless in testbedmain

//must design tets caess to thoroughly test the compareTo() method
//write a testbed main and implement the test caases
//follow the pdf
//use // comments to identify the test case numbers in the testbed main

public class Timeslot implements Comparable<Timeslot>{
    private Date date;
    private Time time;

    @Override
    public String toString() {}
    @Override
    public int compareTo(Timeslot slot){}


}
