package patientdatabase;


/**
 * Class that stores fname, lname from String input,
 * and a Date object  into a Patient object
 * @author Mark Holleran,
 */
public class Patient implements Comparable<Patient>{

    private String fname;
    private String lname;
    private Date dob;

    public Patient (String fname,String lname,Date dob) {

        this.fname = fname;
        this.lname = lname;
        //String dateOfBirthString = dob;
        //Date dateofbirth = new Date(dateOfBirthString);
        //this.dob = dateofbirth;
        this.dob = dob;

    }

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
