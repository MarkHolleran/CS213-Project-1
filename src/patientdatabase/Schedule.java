package patientdatabase;

public class Schedule {

    public static final int NOT_FOUND = -1;
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

    //searches an appointment in the list and returns the index if found or returns -1 if not found
    //must define a constant indentifier "NOT_FOUND" for the value -1
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

    public String isValid(Appointment appt){
        Date currentDate = new Date();
        /*
        if (!appt.getPatient().getDob().isValid()){
            return "Invalid date of birth!";
        }else
        */
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
        //7 still needs to be implemented with location
        for(int i = 0; i < numAppts; i++){
            if(appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == 0 &&
                appointments[i].getPatient().compareTo(appt.getPatient()) == 0){
                return "Same patient cannot book an appointment with the same date.";
            }
        }
        return "true";
    }


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



    //deletes an appointment from the schedule
    //maintains relative order of the appointments in the list after deletion

    //
    public void print(){
        for(int i = 0; i < numAppts; i++){
            System.out.println(this.appointments[i].toString());
        }
    }
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
    public void printByPatient() {
        int n = numAppts;
        for (int i = 1; i < n; ++i) {
            Appointment key = appointments[i];
            int j = i - 1;

            while (j >= 0 && appointments[j].getPatient().getLname().compareTo(key.getPatient().getLname()) > 0 ){
                //arr[j] > key;
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




