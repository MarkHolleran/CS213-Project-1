package patientdatabase;

/**
 * Enum class that stores the County, City, and Zipcode as Location
 *
 * County is stored as a Location object while the City and Zipcode are stored as Strings
 * within Location
 * @author Mark Holleran, Abhitej Bokka
 */

public enum Location {

    SOMERSET ("Bridgewater", "08807"),
    MIDDLESEX ("Piscataway", "08854"),
    MERCER ("Princeton", "08542"),
    MORRIS ("Morristown", "07960"),
    UNION ("Union", "07083");

    private final String city;
    private final String zipcode;

    /**
     *Creates a Location with the input of two Strings, one for city and the other for zipcode
     *
     * @param city String that stores city name
     * @param zipcode String that stores zipcode
     */
    Location (String city, String zipcode){

        this.city = city;
        this.zipcode = zipcode;

    }

    /**
     * Returns the String containing the city name of a Location
     *
     * @return String containing city name
     */
    public String getCity(){

        return city;

    }

    /**
     * Returns the String containing the zipcode of a Location
     *
     * @return String containing zipcode
     */
    public String getZipcode(){

        return zipcode;

    }

    /**
     * Returns a Location's county, city, and zipcode as a String
     *
     * @return String containing the city, zipcode, and county of a Location
     */
    @Override
    public String toString(){

        return " " + this.city + " " + this.zipcode + ", " + this.name();

    }

}
