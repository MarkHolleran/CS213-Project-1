package patientdatabase;

/**
 * Class that stores Patient, Timeslot, and Location
 * information into an Appointment object.
 *
 * After Patient, Timeslot, and Location objects
 * are created they are bundled together into an Appointment
 * object to represent the information required for a valid appointment.
 *
 * @author Mark Holleran, Abhitej Bokka
 */

public class Appointment {

    private Patient patient;
    private Timeslot slot;
    private Location location;

    /**
     * Creates an Appointment object given Patient, Timeslot, and Location objects
     *
     * @param patient Patient object containing fName, lName, and dob
     * @param slot Slot object containing a Timeslot object that consists of a Date and Time object
     * @param location Contains the Location of appointment
     */
    public Appointment(Patient patient, Timeslot slot, Location location){

        this.patient = patient;
        this.slot = slot;
        this.location = location;

    }

    /**
     * Returns Patient information from Appointment object
     *
     * @return Patient object containing Patient information
     */
    public Patient getPatient(){

        return patient;

    }

    /**
     * Returns information about the Time and Date of appointment
     *
     * @return Timeslot object containing Date and Time objects
     */
    public Timeslot getSlot(){

        return slot;

    }


    /**
     * Returns the Location of Appointment
     *
     * @return Location containing County, Township, and Zipcode
     */
    public Location getLocation(){

        return location;

    }

    /**
     * Returns Appointment object as a String
     *
     * @return String representation of Appointment object
     */
    public String toString(){

        return patient.toString() + slot.toString() + location.toString();

    }

    /**
     *Compares an Appointment object with another Appointment object
     * Compares Appointment slot, Patient, and Location
     * returns true if Slot, Patient, and Location are the same
     * and false otherwise.
     *
     * @param obj Appointment object
     * @return True or false if two appointments are equal or not
     */
    @Override
    public boolean equals(Object obj) {

        Appointment app = (Appointment) obj;

        if (this.slot.compareTo(app.slot) == 0 && this.patient.compareTo(app.patient) == 0

                && this.location.compareTo(app.location) == 0) {

            return true;
        }

        return false;
    }

}
