package patientdatabase;

/**
 * Class that stores Appointment objects within an array
 *
 *
 * @author Mark Holleran, Abhitej Bokka
 */

public class Schedule {

    public static final int NOT_FOUND = -1;

    private Appointment  [] appointments;
    private int numAppts;

    public Schedule() {

        this.appointments = new Appointment[4];

        this.numAppts = 0;

    }

    private int find(Appointment apt){

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].equals(apt)){

                return i;

            }

        }

        return NOT_FOUND;

    }

    public boolean findApt(Appointment apt){

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].equals(apt)){

                return true;

            }

        }

        return false;

    }

    public boolean findPatient(Patient patient){

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].getPatient().compareTo(patient) == 0){

                return true;

            }

        }

        return false;

    }

    private void grow() {

        int resizedLength = appointments.length+4;

        Appointment[] resizedArray = new Appointment[resizedLength];

        for(int i = 0; i < numAppts; i++){

            resizedArray[i] = appointments[i];

        }
        appointments = resizedArray;

    }

    public boolean add(Appointment appt){

        if(find(appt) != NOT_FOUND){

            return false;

        }

        if(numAppts >= appointments.length){

            grow();

        }
        appointments[numAppts] = appt;

        numAppts++;

        return true;

    }


    /**
     *
     * @param appt Appointment object 
     * @return
     */
    public String isValid(Appointment appt){

        Date currentDate = new Date();


        if (!appt.getPatient().getDob().isValid()){

            return "Invalid date of birth!";

        }else


            if (appt.getPatient().getDob().compareTo(currentDate) >= 0){

            return "Date of birth invalid -> it is a future date.";

        }else if (!appt.getSlot().getDate().isValid()) {

            return "Invalid appointment date!";

        }else if (appt.getSlot().getDate().compareTo(currentDate) <= 0){

            return "Appointment date invalid -> must be a future date.";

        }else if(!appt.getSlot().getTime().isValid()){

            return "Invalid appointment time! Must enter a time between 9:00 and 16:45 with a 15-minute interval.";

        }else if(find(appt) != NOT_FOUND){

            return "Same appointment exists in the schedule.";

        }

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].getLocation().equals(appt.getLocation())

                && appointments[i].getSlot().compareTo(appt.getSlot()) == 0){

                return "Time slot has been taken at this location.";

            }

        }

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == 0 &&

                appointments[i].getPatient().compareTo(appt.getPatient()) == 0){

                return "Same patient cannot book an appointment with the same date.";

            }

        }

        return "true";

    }

    /**
     * Removes an Appointment object from an array of Appointments
     *
     * @param appt Appointment object to be removed from array
     * @return True if Appointment object is delete, False if not found
     */
    public boolean remove(Appointment appt){

        if(numAppts == 0 || find(appt) == NOT_FOUND){

            return false;

        }

        int deleteIndex = find(appt);

        int lastElement = numAppts-1;

        for(int i = deleteIndex; i < lastElement; i++){

            appointments[i] = appointments[i + 1];

        }
        appointments[lastElement] = null;

        numAppts--;

        return true;
    }

    /**
     * Removes all Appointment object's from the array containing
     * the same patient Object.
     *
     * @param patient Patient object to be removed
     * @return True when all the Patient's appointments have been deleted
     */
    public boolean removeAll(Patient patient){

        for(int i = 0; i < numAppts; i++){

            if(appointments[i].getPatient().compareTo(patient) == 0){

                int deleteIndex = i;

                int lastElement = numAppts;

                for(int j = deleteIndex; j < lastElement; j++){

                    appointments[j] = appointments[j + 1];


                }

                appointments[lastElement] = null;
                numAppts--;
                i--;
            }
        }
        return true;
    }


    /**
     * Prints an Appointment's data to the commandline
     *
     * Using the toString() method the Appointment
     * is printed in the form of a String
     */
    public void print(){
        for(int i = 0; i < numAppts; i++){
            System.out.println(this.appointments[i].toString());
        }
    }
    //maintains relative order of the appointments in the list after deletion

    /**
     * Prints each Appointment object within an array of Appointment objects by zipcode
     *
     * Each Appointment object is printed to the command line in the order
     * of Zipcode by going through each occupied array index for
     * the number of inserted appointments
     */
    public void printByZip() {
        int n = numAppts;
        for (int i = 1; i < n; ++i) {
            Appointment key = appointments[i];
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(appointments[j].getLocation().getZipcode())
                    > Integer.parseInt(key.getLocation().getZipcode())){
                //arr[j] > key;
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }

            while (j >= 0 && Integer.parseInt(appointments[j].getLocation().getZipcode())
                    >= Integer.parseInt(key.getLocation().getZipcode())
                    && appointments[j].getSlot().compareTo(key.getSlot()) > 0){
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }

            appointments[j + 1] = key;
        }
        print();
        System.out.println("*end of list.");
        System.out.println();
    }

    /**
     * Prints each Appointment object within array of Appointment objects
     *
     * Each Appointment object is printed to the command line
     * by going through each occupied array index for the number of
     * inserted appointments
     */
    public void printByPatient() {
        int n = numAppts;
        for (int i = 1; i < n; ++i) {
            Appointment key = appointments[i];
            int j = i - 1;

            while (j >= 0 && appointments[j].getPatient().getLname().compareTo(key.getPatient().getLname()) > 0 ){
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }

            while (j >= 0 && appointments[j].getPatient().getLname().compareTo(key.getPatient().getLname()) >= 0
                    && appointments[j].getPatient().getFname().compareTo(key.getPatient().getFname()) > 0){
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }

            while (j >= 0 && appointments[j].getPatient().getLname().compareTo(key.getPatient().getLname()) >= 0
                    && appointments[j].getPatient().getFname().compareTo(key.getPatient().getFname()) >= 0
                    && appointments[j].getSlot().compareTo(key.getSlot()) > 0){
                appointments[j + 1] = appointments[j];
                j = j - 1;
            }
            appointments[j + 1] = key;
        }
        print();
        System.out.println("*end of list.");
        System.out.println();
    }

}




