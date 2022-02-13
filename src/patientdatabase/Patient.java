package patientdatabase;

//implement comparableinterface and implement the compareTo() method

//cannot changeor add instance variables and cannot use System.out statments in this class

//has date of birth here
public class Patient implements Comparable<Patient>{
    private String fname;
    private String lname;
    private Date dob;

    public Patient (String fname,String lname,String dob) {

        this.fname = fname;
        this.lname = lname;
        String dateOfBirthString = dob;
        Date dateofbirth = new Date(dateOfBirthString);
        this.dob = dateofbirth;

        //having dateofbirth as a string object as well as a date object for compareto method later

    }

    public String getFname(){

        return fname;
    }

    public String getLname(){

        return lname;
    }

    public Date getDob(){


        return dob;
    }

    @Override
    public String toString(){

        return getFname() + " " + getLname() + ", DOB: " + getDob().toString() + ",";

    }
    @Override
    public int compareTo(Patient patient){

        //comparing two patients

        String fName = this.fname;
        String lName = this.lname;
        Date dob = this.dob;

        String fNameCompare = patient.fname;
        String lNameCompare = patient.lname;
        Date dobCompare = patient.dob;

        if (fName.equals(fNameCompare) == true && lname.equals(lNameCompare) == true && dob.compareTo(dobCompare) == 0){

            //patients are the same..share fname lname and dob

            return 0;

        }else {

            return -1;
        }

    }



    public static void main (String[] args){

        Patient newpatient = new Patient("Mark","Holleran","4/21/1999");
        Patient newpatientcompare = new Patient("Mark","Holleran","4/21/1998");

        System.out.println(newpatient.toString());
        System.out.println(newpatient.compareTo(newpatientcompare));




    }
}
