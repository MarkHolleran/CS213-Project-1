package patientdatabase;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class that provides a text based interface
 * that takes command line arguments from the client.
 * Kiosk handles user input to accordingly deal with Appointments
 * and the commands they are associated with.
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
     * @return Location of Appointment if it exists, null otherwise
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

    /**
     * Attempts to insert an Appointment and will print error message if unable to.
     * If the command follows the proper formatting,
     * the command will move forward to executeCommandB().
     *
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
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

    /**
     * Attempts to delete an Appointment and will print error message if unable to.
     * If the command follows the proper formatting,
     * the command will move forward to executeCommandC().
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
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

    /**
     * Attempts to delete all Appointments of a Patient
     * and will print error message if unable to.
     * If the command follows the proper formatting,
     * the command will move forward to executeCommandCP().
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
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

    /**
     * Creates Patient given the separated strings and the location.
     *
     * @param dob String representing Date of Birth of Patient
     * @param fName String representing Patient's first name
     * @param lName String representing Patient's last name
     * @param appointmentDate String containing date of appointment
     * @param appointmentTime String containing time of appointment
     * @param newLocation Location of Appointment
     */
    private Appointment createAppointment(String dob, String fName, String lName, String appointmentDate,
                                          String appointmentTime, Location newLocation){
        Time newAppointmentTime = new Time(appointmentTime);
        Date newAppointmentDate = new Date(appointmentDate);
        Date dateOfBirth = new Date(dob);

        Patient newPatient = new Patient(fName, lName, dateOfBirth);
        Timeslot newSlot = new Timeslot(newAppointmentDate, newAppointmentTime);

        Appointment newAppointment = new Appointment(newPatient, newSlot, newLocation);

        return newAppointment;
    }

    /**
     * Inserts an Appointment into an instance of Schedule unless
     * sent a message by isValid() in Schedule.
     *
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
    private void executeCommandB(StringTokenizer segmentedInput, Schedule schedule){
        String dob = segmentedInput.nextToken();
        String fName = segmentedInput.nextToken();
        String lName = segmentedInput.nextToken();
        String appointmentDate = segmentedInput.nextToken();
        String appointmentTime = segmentedInput.nextToken();
        String appointmentLocation = segmentedInput.nextToken();

        Location newLocation = findLocation(appointmentLocation);
        if (!locationValid(appointmentLocation)) {
            System.out.println("Invalid location!");
            return;
        }

        Date dateOfBirth = new Date(dob);
        Appointment newAppointment = createAppointment(dob, fName, lName, appointmentDate,
                appointmentTime, newLocation);

        String message = schedule.isValid(newAppointment);
        if (message.equals("true")) {
            System.out.println("Appointment booked and added to the schedule.");
            schedule.add(newAppointment);
        } else {
            System.out.println(message);
        }
    }

    /**
     * Deletes an Appointment from an instance of Schedule unless
     * not found in Schedule's array of Appointments.
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
    private void executeCommandC(StringTokenizer segmentedInput, Schedule schedule){
        String dob = segmentedInput.nextToken();
        String fName = segmentedInput.nextToken();
        String lName = segmentedInput.nextToken();
        String appointmentDate = segmentedInput.nextToken();
        String appointmentTime = segmentedInput.nextToken();
        String appointmentLocation = segmentedInput.nextToken();

        Location newLocation = findLocation(appointmentLocation);
        if (!locationValid(appointmentLocation)) {
            System.out.println("Invalid location!");
            return;
        }

        Date dateOfBirth = new Date(dob);
        Patient newPatient = new Patient(fName, lName, dateOfBirth);
        Appointment newAppointment = createAppointment(dob, fName, lName, appointmentDate,
                appointmentTime, newLocation);

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

    /**
     * Deletes all Appointment from an instance of Schedule unless
     * not found in Schedule's array of Appointments.
     *
     * @param segmentedInput User Input contained as Tokens
     * @param schedule Instance of schedule
     */
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
    /**
     * Prints schedule of Appointments
     *
     * @param schedule Instance of schedule
     */
    private void executeCommandP(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments in the schedule*");
        schedule.print();
        System.out.println("*end of schedule*");
        System.out.println();
    }

    /**
     * Prints schedule of Appointments ordered by Zipcode.
     * Once organized by zipcodes, the appointments are sorted by earliest timeslot.
     *
     * @param schedule Instance of schedule
     */
    private void executeCommandPZ(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments by zip and time slot.");
        schedule.printByZip();
    }

    /**
     * Prints schedule of Appointments ordered by Patient.
     * Sorts by last name of patient, followed by first name,
     * and finally their date of birth.
     * These appointments are then sorted by earliest timeslot.
     *
     * @param schedule Instance of schedule
     */
    private void executeCommandPP(Schedule schedule){
        System.out.println();
        System.out.println("*list of appointments by patient.");
        schedule.printByPatient();
    }

    /**
     * Takes in user input to call the corresponding command.
     * Used by run() to handle valid commands
     *
     * @param segmentedInput Token containing command type
     * @param schedule Instance of schedule
     */
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