package patientdatabase;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class that provides a text based interface
 * that takes command line arguments from the client
 *
 * @author Mark Holleran,
 */


public class Kiosk {

    public static final int BOOK_PATIENT_APPT_NUM_ARGUMENTS = 7 ;
    public static final int CANCEL_SINGLE_APPT_NUM_ARGUMENTS = 7;
    public static final int CANCEL_ALL_PATIENT_APPT_NUM_ARGUMENTS = 4 ;



    public static Boolean locationValid(String inputLocation){
        String inputLocationToUpper = inputLocation.toUpperCase();
        for (Location location : Location.values()){
            if (location.name().equals(inputLocation.toUpperCase())){
                return true;
            }
        }
        return false;
    }

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
     * Runs command line text based interface
     * allows input
     *
     */

    public void run() {

        Scanner input = new Scanner(System.in);

        Schedule schedule = new Schedule();

        System.out.println("Kiosk running. Ready to process transactions.");

        String commandInput = input.nextLine();

        Schedule listOfAppointments = new Schedule();

        while (!commandInput.equals("Q")){
            StringTokenizer segmentedInput = new StringTokenizer(commandInput," ");
            switch (segmentedInput.nextToken()){

                case "B":
                    if (segmentedInput.countTokens() == BOOK_PATIENT_APPT_NUM_ARGUMENTS){
                        try {
                            String dob = segmentedInput.nextToken();
                            String fName = segmentedInput.nextToken();
                            String lName = segmentedInput.nextToken();
                            String appointmentDate = segmentedInput.nextToken();
                            String appointmentTime = segmentedInput.nextToken();
                            String appointmentLocation = segmentedInput.nextToken();

                            Time newAppointmentTime = new Time(appointmentTime);
                            Date newAppointmentDate = new Date(appointmentDate);
                            Date dateOfBirth = new Date(dob);

                            //have to do this one at some point
                            Patient newPatient = new Patient(fName,lName,dateOfBirth);
                            Timeslot newSlot = new Timeslot(newAppointmentDate, newAppointmentTime);
                            Location newLocation = findLocation(appointmentLocation);
                            if (!locationValid(appointmentLocation)){
                                System.out.println("Invalid location!");
                                break;
                            }
                            Appointment newAppointment = new Appointment(newPatient, newSlot, newLocation);

                            String message = schedule.isValid(newAppointment);
                            if(message.equals("true")){
                                System.out.println("Appointment booked and added to the schedule.");
                                schedule.add(newAppointment);
                            }else{
                                System.out.println(message);
                            }

                        } catch (Exception e){
                            System.out.println("Invalid Command!");
                        }

                    }else {
                        System.out.println("Insufficient input for command");
                    }
                    break;
                case "C": commandInput = "C";
                    if (segmentedInput.countTokens() == CANCEL_SINGLE_APPT_NUM_ARGUMENTS){
                        try {
                            String dob = segmentedInput.nextToken();
                            String fName = segmentedInput.nextToken();
                            String lName = segmentedInput.nextToken();
                            String appointmentDate = segmentedInput.nextToken();
                            String appointmentTime = segmentedInput.nextToken();
                            String appointmentLocation = segmentedInput.nextToken();

                            Time newAppointmentTime = new Time(appointmentTime);
                            Date newAppointmentDate = new Date(appointmentDate);
                            Date dateOfBirth = new Date(dob);

                            //have to do this one at some point
                            Patient newPatient = new Patient(fName,lName,dateOfBirth);
                            Timeslot newSlot = new Timeslot(newAppointmentDate, newAppointmentTime);
                            Location newLocation = findLocation(appointmentLocation);
                            if (!locationValid(appointmentLocation)){
                                System.out.println("Invalid location!");
                                break;
                            }
                            Appointment newAppointment = new Appointment(newPatient, newSlot, newLocation);

                            if(!schedule.add(newAppointment)){
                                System.out.println("Appointment cancelled.");
                                schedule.remove(newAppointment);
                            }else{
                                System.out.println("Not cancelled, appointment does not exist.");
                            }

                        } catch (Exception e){
                            System.out.println("Not cancelled, appointment does not exist.");
                        }

                    }else {
                        System.out.println("Insufficient input for command");
                    }
                    break;
                case "CP": commandInput = "CP";

                    if (segmentedInput.countTokens() == CANCEL_ALL_PATIENT_APPT_NUM_ARGUMENTS){
                        try{
                            String dob = segmentedInput.nextToken();
                            String fName = segmentedInput.nextToken();
                            String lName = segmentedInput.nextToken();
                            Date dateOfBirth = new Date(dob);
                            Patient newPatient = new Patient(fName,lName,dateOfBirth);

                            if(schedule.findPatient(newPatient)){
                                schedule.removeAll(newPatient);
                            }else{
                                System.out.println("Not cancelled, appointment does not exist.");
                            }

                            break;
                        }catch (Exception e){
                            System.out.println("Not cancelled, appointment does not exist.");
                        }
                    }else{
                        System.out.println("Insufficient input for command");
                    }
                    break;
                case "P": commandInput = "P";
                    schedule.print();
                    break;
                case "PZ": commandInput = "PZ";
                    schedule.printByZip();
                    break;
                case "PP": commandInput = "PP";
                    schedule.printByPatient();
                    break;
                case "Q": commandInput = "Q";
                    break;
                default:
                    System.out.println("Invalid Command!");
                    break;
            }
            commandInput = input.nextLine();
        }

        System.out.println("Kiosk session ended.");

        System.exit(0);

    }

}
