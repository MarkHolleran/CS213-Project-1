package patientdatabase;

public class Schedule {

    //container class that implements an array based linear data structure

    //to hold the list of vaccination appointments

    //new appointments are added at the end of the list

    //an instance of the schedule class is a growable container w an initial capacity of 4
    //automatically increases capacity by 4 when its full but size does not decrease

    //cannot use java library class Arraylist or WE GEt A ZERO :O

    //cannot change or add instance variables

    //cannot change signatures of the methods

    //Cannot use System.out in this class except in the print() method

    //Must use IN PLACE sorting algo to implement the sorting by writing the code yourself
    //cannot use Arrays.sort etc

    //Can add additional methods but they have to take no parameters
    //OR a single parameter which takes an instance of appointment class such as (Appointment appt)


    private Appointment  [] appointments;
    private int numAppts;

    private int find(Appointment apt){}

    //searches an appointment in the list and returns the index if found or returns -1 if not found
    //must define a constant indentifier "NOT_FOUND" for the value -1
    private void grow() {}
    private boolean add(Appointment appt){}
    public boolean remove(Appointment appt){}

    //deletes an appointment from the schedule
    //maintains relative order of the appointments in the list after deletion

    //
    public void print(){}
    public void printByZip() {}
    public void printByPatient() {}





}
