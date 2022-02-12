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



        public Boolean locationValid(String inputLocation){
            String inputLocationToUpper = inputLocation.toUpperCase();
            for (Location location : Location.values()){
                if (location.name().toString().equals(inputLocation)){
                    return true;
                }
            }
            return false;

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

                            //make schedule right when kiosk boots
                            //if add appt then do it inside case

                            //check if dob is valid
                            //appointment date
                            //appointment time
                            //appointment location

                            Time newAppointmentTime = new Time (appointmentTime);
                            Date newAppointmentDate = new Date(appointmentDate);
                            Date dateOfBirth = new Date(dob);

                            //have to do this one at some point
                            Patient newPatient = new Patient(fName,lName,dob);
                            Appointment newAppointment = new Appointment();

                            if (newAppointmentDate.isValid() == true && newAppointmentTime.isValid() == true){
                                //both inputs required for timeslot are valid then we make timeslot object

                                Timeslot newAppointmentTimeslot = new Timeslot(newAppointmentDate,newAppointmentTime);


                            }else if (newAppointmentDate.isValid() == true && newAppointmentTime.isValid() == false){

                                System.out.println("Appointment Time is Invalid!");

                            }else if (newAppointmentDate.isValid() == false && newAppointmentTime.isValid() == true){


                                System.out.println("Appointment Date is Invalid!");

                            }else {

                                System.out.println("Appointment Date & time are Invalid!");
                            }

                            if (locationValid(appointmentLocation) == true){
                                //location input for creating a new appointment is valid


                            }

                            if (new.isValid() == true && dateOfBirth.isValid() == true ){
                                //if appointment date is valid then continue





                            }else {

                                System.out.println("Invalid Date!");
                            }

                        } catch (Exception e){

                            System.out.println("Invalid Command!");
                        }


                    }else {

                        System.out.println("Insufficient input for command");
                    }


                //book an appt and add appt to schedule
                    //schedule contains list of appts
                    //EX: B 8/31/1978 Jane Doe 7/19/2022 9:15 middlesex

                        break;

                case "B": commandInput = "B";

                    System.out.println("command B chosen");
                    //book an appt
                    //EX: C 8/31/1978 Jane Doe 7/19/2022 9:15 middlesex
                    break;

                case "C": commandInput = "C";

                System.out.println("command C chosen");
                //cancel appt and remove specified appt from schedule
                    //EX: C 8/31/1978 Jane Doe 7/19/2022 9:15 middlesex
                    break;

                case "CP": commandInput = "CP";

                    System.out.println("command CP chosen");

                    //cancel all appts of a given patient & remove all appts for this appt from the shedule

                    //EX: CP 8/31/1978 Jane Doe
                    break;

                case "P": commandInput = "P";

                    System.out.println("command P chosen");
                    schedule.print();
                    break;

                case "PZ": commandInput = "PZ";
                    System.out.println("command PZ chosen");
                    schedule.printByZip();
                    break;

                case "PP": commandInput = "PP";

                    System.out.println("command PP chosen");
                    schedule.printByPatient();
                    break;

                    //stops program execution and display 'kiosk session ended'
                case "Q": commandInput = "Q";

                    System.out.println("command Q chosen");

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
