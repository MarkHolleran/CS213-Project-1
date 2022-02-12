package patientdatabase;

import java.util.Scanner;

public class Kiosk {

    public void run() {

        Scanner input = new Scanner(System.in);

        Schedule schedule = new Schedule();

        System.out.println("Kiosk running. Ready to process transactions.");

        String commandInput = input.nextLine().toUpperCase();
        //idk if we should make it upperCase

        while (!commandInput.equals("Q")){

            switch (commandInput){

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

            commandInput = input.nextLine().toUpperCase();

        }

        System.out.println("Kiosk session ended");

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
