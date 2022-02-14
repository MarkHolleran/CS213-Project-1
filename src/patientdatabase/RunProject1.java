package patientdatabase;

/**
 * Class that calls the run() function of Kiosk which runs the command line interface
 * and allows for user interaction within the commands of kiosk
 *
 * @author Mark Holleran, Abhitej Bokka
 */
public class RunProject1 {

    /**
     * Performs the kiosk().run() command
     *
     * @param args Runs the kiosk run
     */
    public static void main(String[] args) {

        new Kiosk().run();
    }
}


