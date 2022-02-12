package patientdatabase;

public class Appointment {

    private Patient patient;
    private Timeslot slot;
    private Location location;

    @Override
    public boolean equals(Object obj) {
        Appointment app = (Appointment) obj;
        if (this.slot.compareTo(app.slot) == 0 && this.patient.compareTo(app.patient) == 0
                && this.location.compareTo(app.location) == 0) {
            return false;
        }
        return true;
    }

    public Patient getPatient(){
        return patient;
    }

    public Timeslot getSlot(){
        return slot;
    }

    public Location getLocation(){
        return location;
    }

    public String toString(){
        return patient.toString() + slot.toString() + location.toString();
    }

    //cannot change or add instance variables for this class
    //cannot read from console or use system.out statements for this class

    //toString() method returns texual representation of an appointment in the format of

    //Jane Doe, DOB: 1/19/2000, Appointment detail: 12/1/2022, 9:45, Union 07083, UNION

    //equals() method returns true if patient, timeslot, and location are equal for the two appointments

    //cannot change signatures of the twoString() and equals() method
    //also dont remove the @Override tags
}
