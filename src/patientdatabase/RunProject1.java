package patientdatabase;

/**
 * Class that calls the run() function of Kiosk which runs the command line interface
 * and allows for user interaction within the commands of kiosk
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class RunProject1 {

    //driver class for running project
    //main method will call run() method in the kiosk class


    public static void main(String[] args) {


        new Kiosk().run();


    }
}

//required to generate javadoc after properly commented code
//javadoc must include documentations for the constructors, private methods, and public methods of all java classes
//generate the javadoc in a single folder "doc" and include it in the zip file to be submitted to canvas
//double check after javadoc is generated to make sure descriptions are not empty


