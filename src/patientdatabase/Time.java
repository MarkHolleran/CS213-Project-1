package patientdatabase;

//must implement the comparable interface
//implement the compareTo() method

//cannot change or add instance variables and cannot use System.out stamentes
public class Time implements Comparable<Time>{

    private int hour;
    private int minute;

    public boolean isValid(){}

    @Override
    public String toString(){}
    @Override
    public int compareTo(Time time){}

}
