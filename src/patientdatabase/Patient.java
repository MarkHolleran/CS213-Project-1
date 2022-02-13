package patientdatabase;

/**
 * Class that stores fname, lname from String input,
 * and a Date object  into a Patient object
 * @author Mark Holleran, Abhitej Bokka
 */
public class Patient implements Comparable<Patient>{

    private String fname;
    private String lname;
    private Date dob;

    /**
     * Creates a Patient object based on String input
     * for First and Last name and Date of birth
     * as a Date object
     *
     * @param fname First name of patient as String
     * @param lname Last name of patient as String
     * @param dob Date of birth of patient as Date object
     */
    public Patient (String fname,String lname,Date dob) {

        this.fname = fname;
        this.lname = lname;
        this.dob = dob;

    }

    /**
     * Returns lName as String from a patient object
     *
     * @return String value of fName
     */
    public String getFname(){

        return this.fname;

    }

    /**
     * Returns fName as String from a Patient object
     *
     * @return String value of lName
     */
    public String getLname(){

        return this.lname;

    }

    /**
     * Returns Date object from a Patient object
     *
     * @return Date object of Patient object
     */
    public Date getDob(){


        return this.dob;

    }

    /**
     * Converts Patient object to a String
     * by returning fName, lName, and dob
     * separated by a space as a String
     *
     * @return String representation of Patient object
     */
    @Override
    public String toString(){

        return getFname() + " " + getLname() + ", DOB: " + getDob().toString() + ",";

    }

    /**
     * Compares a Patient object with another Patient object
     * Compares fName, lName, and dob of both Patient objects
     * Returns 0 if Patient objects are the same and -1 otherwise
     *
     * @param patient Patient object for comparison with anoher Patient object
     *
     * @return -1 or 0 based on result of comparison
     */
    @Override
    public int compareTo(Patient patient){

        String fName = this.fname;
        String lName = this.lname;
        Date dob = this.dob;

        String fNameCompare = patient.fname;
        String lNameCompare = patient.lname;
        Date dobCompare = patient.dob;

        if (fName.equals(fNameCompare) == true && lname.equals(lNameCompare) == true && dob.compareTo(dobCompare) == 0){

            return 0;

        }else {

            return -1;
        }

    }

}
