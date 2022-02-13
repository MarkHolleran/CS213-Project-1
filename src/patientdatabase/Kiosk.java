package patientdatabase;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class that provides a text based interface
 * that takes command line arguments from the client
 *
 * @author Mark Holleran, Abhitej Bokka
 */

public class Kiosk {

    public static final int BOOK_PATIENT_APPT_NUM_ARGUMENTS = 6 ;
    public static final int CANCEL_SINGLE_APPT_NUM_ARGUMENTS = 6;
    public static final int CANCEL_ALL_PATIENT_APPT_NUM_ARGUMENTS = 3 ;

    /**
     * Compares Location String input against all locations in Location enum class
     * If String input matches one of the Counties in the enum class return true
     * otherwise return false.
     *
     * @param inputLocation County of appointment as a String
     *
     * @return True or False based on Location validity
     */
    public static Boolean locationValid(String inputLocation){

        String inputLocationToUpper = inputLocation.toUpperCase();

        for (Location location : Location.values()){
            if (location.name().equals(inputLocation.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    /**
     *Compares Location String input against all locations in Location enum class
     * IF string input matches one of the Counties in the enum class return the Location
     * otherwise return null
     *
     * @param inputLocation County of Appointment as a String
     *
     * @return Location of Appointent if it exists, null otherwise
     */
    public static Location findLocation(String inputLocation){
        
        String inputLocationToUpper = inputLocation.toUpperCase();

        for (Location location : Location.values()){
            if (location.name().equals(inputLocation.toUpperCase())){
                return location;
            }
        }
        return null;
    }

    private void tryCommandB(StringTokenizer segmentedInput, Schedule schedule){
        if (segmentedInput.countTokens() == BOOK_PATIENT_APPT_NUM_ARGUMENTS) {
            try {
                executeCommandB(segmentedInput, schedule);
            } catch (Exception e) {
                System.out.println("Invalid Command!");
            }

        } else {
            System.out.println("Invalid Command!");
        }
    }

    private void tryCommandC(StringTokenizer segmentedInput, Schedule schedule){
        if (segmentedInput.countTokens() == CANCEL_SINGLE_APPT_NUM_ARGUMENTS) {
            try {
                executeCommandC(segmentedInput, schedule);
            } catch (Exception e) {
                System.out.println("Not cancelled, appointment does not exist.");
            }
        } else {
            System.out.println("Invalid Command!");
        }
    }

    private void tryCommandCP(StringTokenizer segmentedInput, Schedule schedule){
        if (segmentedInput.countTokens() == CANCEL_ALL_PATIENT_APPT_NUM_ARGUMENTS) {
            try {
                executeCommandCP(segmentedInput, schedule);
            } catch (Exception e) {
                System.out.println("Not cancelled, appointment does not exist.");
            }
        } else {
            System.out.println("Invalid Command!");
        }
    }


    private void executeCommandB(StringTokenizer segmentedInput, Schedule schedule){
        String dob = segmentedInput.nextToken();
        String fName = segmentedInput.nextToken();
        String lName = segmentedInput.nextToken();
        String appointmentDate = segmentedInput.nextToken();
        String appointmentTime = segmentedInput.nextToken();
        String appointmentLocation = segmentedInput.nextToken();

        Time newAppointmentTime = new Time(appointmentTime);
        Date newAppointmentDate = new Date(appointmentDate);
        Date dateOfBirth = new Date(dob);

        Patient newPatient = new Patient(fName, lName, dateOfBirth);
        Timeslot newSlot = new Timeslot(newAppointmentDate, newAppointmentTime);
        Location newLocation = findLocation(appointmentLocation);
        if (!locationValid(appointmentLocation)) {
            System.out.println("Invalid location!");
            return;
        }
        Appointment newAppointment = new Appointment(newPatient, newSlot, newLocation);

        String message = schedule.isValid(newAppointment);
        if (message.equals("true")) {
            System.out.println("Appointment booked and added to the schedule.");
            schedule.add(newAppointment);
        } else {
            System.out.println(message);
        }
    }

    private void executeCommandC(StringTokenizer segmentedInput, Schedule schedule){
        String dob = segmentedInput.nextToken();
        String fName = segmentedInput.nextToken();
        String lName = segmentedInput.nextToken();
        String appointmentDate = segmentedInput.nextToken();
        String appointmentTime = segmentedInput.nextToken();
        String appointmentLocation = segmentedInput.nextToken();

        Time newAppointmentTime = new Time(appointmentTime);
        Date newAppointmentDate = new Date(appointmentDate);
        Date dateOfBirth = new Date(dob);

        Patient newPatient = new Patient(fName, lName, dateOfBirth);
        Timeslot newSlot = new Timeslot(newAppointmentDate, newAppointmentTime);
        Location newLocation = findLocation(appointmentLocation);
        if (!locationValid(appointmentLocation)) {
            System.out.println("Invalid location!");
            return;
        }
        Appointment newAppointment = new Appointment(newPatient, newSlot, newLocation);

        if (schedule.findPatient(newPatient)) {

            if (schedule.findPatient(newPatient) && schedule.findApt(newAppointment)) {
                System.out.println("Appointment cancelled.");
                schedule.remove(newAppointment);
            } else {
                System.out.println("Not cancelled, appointment does not exist.");
            }

        } else {
            System.out.println("Not cancelled, appointment does not exist.");
        }
    }

    private void executeCommandCP(StringTokenizer segmentedInput, Schedule schedule){
        String dob = segmentedInput.nextToken();
        String fName = segmentedInput.nextToken();
        String lName = segmentedInput.nextToken();
        Date dateOfBirth = new Date(dob);
        Patient newPatient = new Patient(fName, lName, dateOfBirth);

        if (schedule.findPatient(newPatient)) {
            schedule.removeAll(newPatient);
            //All appointments for Jane Doe, DOB: 8/31/1978 have been cancelled.
            System.out.println("All appointments for " + newPatient.getFname() + " "
                    + newPatient.getLname() + ", DOB: " + newPatient.getDob().toString()
                    + " have been cancelled.");
        } else {
            System.out.println("Not cancelled, appointment does not exist.");
        }
    }

    private void executeCommandP(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments in the schedule*");
        schedule.print();
        System.out.println("*end of schedule*");
        System.out.println();
    }

    private void executeCommandPZ(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments by zip and time slot.");
        schedule.printByZip();
    }

    private void executeCommandPP(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments by patient.");
        schedule.printByPatient();
    }

    private void parseCommands(StringTokenizer segmentedInput, Schedule schedule){
        switch (segmentedInput.nextToken()) {
            case "B":
                tryCommandB(segmentedInput, schedule);
                break;
            case "C":
                tryCommandC(segmentedInput, schedule);
                break;
            case "CP":
                tryCommandCP(segmentedInput, schedule);
                break;
            case "P":
                executeCommandP(schedule);
                break;
            case "PZ":
                executeCommandPZ(schedule);
                break;
            case "PP":
                executeCommandPP(schedule);
                break;
            case "Q":
                break;
            default:
                System.out.println("Invalid Command!");
                break;
        }
    }


    
    /**
     * Runs command line text based interface
     *
     * Allows for Appointment scheduling, Cancellation of an Appointment or multiple,
     * print all scheduled Appointments, print all scheduled Appointments ordered by Zipcode,
     * print all scheduled Appointments by Patient name, and quit command.
     */
    public void run() {

        Scanner input = new Scanner(System.in);
        Schedule schedule = new Schedule();
        System.out.println("Kiosk running. Ready to process transactions.");
        String commandInput = input.nextLine();

        while (!("Q").equals(commandInput)){
            if(!("").equals(commandInput)) {
                StringTokenizer segmentedInput = new StringTokenizer(commandInput, " ");
                parseCommands(segmentedInput, schedule);
            }
            commandInput = input.nextLine();
        }
        System.out.println("Kiosk session ended.");
        System.exit(0);
    }

}
