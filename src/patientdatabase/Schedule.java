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
        for(int i = 0; i < numAppts-1; i++){
            if(appointments[i].equals(apt)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    //searches an appointment in the list and returns the index if found or returns -1 if not found
    //must define a constant indentifier "NOT_FOUND" for the value -1
    private void grow() {
        int resizedLength = appointments.length+4;
        Appointment[] resizedArray = new Appointment[resizedLength];
        for(int i = 0; i < numAppts-1; i++){
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

    private String isValid(Appointment appt){
        if (!appt.getSlot().getDate().isValid()){
            return "false";
        }
        //if(appt.getPatient().getDob())
        //need current/future date checker


        /*
5. An appointment with the same patient, timeslot and location is already in the schedule.
6. The specified timeslot (same date and time) at the specified location has already been taken.
7. The location with the county name is not a valid location.
8. The user is booking an appointment with the same patient and date but a different location with an existing
appointment.
         */
        //5
        if(find(appt) != NOT_FOUND){
            return "Same appointment exists in the schedule.";
        }
        //6
        for(int i = 0; i < numAppts-1; i++){
            if(appointments[i].getLocation().equals(appt.getLocation())
                && appointments[i].getSlot().compareTo(appt.getSlot()) == 0){
                return "Time slot has been taken at this location";
            }
        }
        //7 might have to be done in Kiosk itself lol
        /*
        if(appt.getLocation()){
            return false;
        }
        */
        //8
        for(int i = 0; i < numAppts-1; i++){
            if(appointments[i].getSlot().getDate().compareTo(appt.getSlot().getDate()) == 0 &&
                appointments[i].getPatient().compareTo(appt.getPatient()) == 0){
                return "Same patient cannot book an appointment with the same date.";
            }
        }
        return "true";
    }


        //date is not a valid calendar date
        //date of birth is today or future date
        //appt date is today or a da before today or a day beyond this year
        //time is not a 15 interval and outside of the range of appointment times of the day

        //1st appointment is at 9 and the last one is at 16:45






    public boolean isAppointmentDateValid(Appointment appt){

        //The appointment date is today or a date before today, (checked in 2nd part of if statement)
        // or a date beyond this year.   (checked in date.isvalid method)


        Date currentDate = new Date();

        if ((appt.getSlot().getDate().isValid() == true) && (appt.getSlot().getDate().getDay() > currentDate.getDay()) && (appt.getSlot().getDate().getMonth() >= currentDate.getMonth())){

            //if its a valid date and the appt day is Not today and the month is not in the future

            return true;

        }else {

            return false;
        }


    }
    public boolean isDateofBirthValid (Appointment appt){

        Date currentDate = new Date();

        if (appt.getSlot().getDate().isValid() == true && appt.getPatient().getDob().getDay() != currentDate.getDay() && appt.getPatient().getDob().getMonth() <= currentDate.getMonth()){

            //date of birth is today or future date
            //if it's a valid date and the DOB is not today and the DOB month is not in the future

            return true;

        }else {

            return false;
        }

    }

    public boolean isAppointmentTimeValid(Appointment appt){

        if (appt.getSlot().getTime().isValid() == true){

            return true;

        }else {

            return false;
        }

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

    public boolean removeAll(Appointment appt){

        for(int i = 0; i < numAppts-1; i++){
            if(appointments[i].getPatient().compareTo(appt.getPatient()) == 0){
                int deleteIndex = i;
                int lastElement = numAppts-1;
                for(int j = deleteIndex; j < lastElement; j++){
                    appointments[j] = appointments[j + 1];
                }
                appointments[lastElement] = null;
                numAppts--;
            }
        }
        return true;
    }



    //deletes an appointment from the schedule
    //maintains relative order of the appointments in the list after deletion

    //
    public void print(){
        for(int i = 0; i < numAppts-1; i++){
            System.out.println(appointments[i].toString());
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
    }

}




