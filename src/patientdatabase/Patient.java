package patientdatabase;

//implement comparableinterface and implement the compareTo() method

//cannot changeor add instance variables and cannot use System.out statments in this class

public class Patient implements Comparable<Patient>{
    private String fname;
    private String lname;
    private Date dob;

    @Override
    public String toString(){}
    @Override
    public int compareTo(Patient patient){}
}
