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
    public static final int CANCEL_SINGLE_APPT_NUM_ARGUMENTS = 3;
    public static final int CANCEL_ALL_PATIENT_APPT_NUM_ARGUMENTS = 7 ;



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
                    System.out.println("command B chosen");
                    if (segmentedInput.countTokens() == BOOK_PATIENT_APPT_NUM_ARGUMENTS){
                        try {
                            String dob = segmentedInput.nextToken();
                            String fName = segmentedInput.nextToken();
                            String lName = segmentedInput.nextToken();
                            String appointmentDate = segmentedInput.nextToken();
                            String appointmentTime = segmentedInput.nextToken();
                            String appointmentLocation = segmentedInput.nextToken();

                            Time newAppointmentTime = new Time (appointmentTime);
                            Date newAppointmentDate = new Date(appointmentDate);
                            Date dateOfBirth = new Date(dob);

                            //have to do this one at some point
                            Patient newPatient = new Patient(fName,lName,dob);
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
                    schedule.remove(appt);
                    break;
                case "CP": commandInput = "CP";
                    //make this method dummy
                    //cancel all appts of a given patient & remove all appts for this appt from the shedule
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








    //this class is the user interface class to process the transactions entered through the console
    //and output the results to the console

    //An instance of Kiosk class can process single transactions as well as a batch of transactions

    //displays the results to the console whenever one or more transactions have been entered

    //when project starts running it shall display "Kiosk running. Ready to process transactions."
    //next it will read andprocess tranactions continuously until the "Q" command is read
    //before hte project stops running display "Kiosk session ended."

    //must define a public void run() method that includes a while loop to continuously read command lines (transactions from the console)
    //must keep this method under 35 lines for readability
    //can define nessessary instance variables and private methods for handling the commands
    }
