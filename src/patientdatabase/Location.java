package patientdatabase;

//must use enum class to define the 5 locations avaliable for vaccination appointments

//use the country names as the constant names and define the zip codes and city names as the properties accordingly
//see lecture note #2 for the syntax to define constants in the enum class

public enum Location {

    SOMERSET ("Bridgewater", "08807"),
    MIDDLESEX ("Piscataway", "08854"),
    MERCER ("Princeton", "08542"),
    MORRIS ("Morristown", "07960"),
    UNION ("Union", "07083");

    private final String city;
    private final String zipcode;

    Location (String city, String zipcode){
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity(){
        return city;
    }

    public String getZipcode(){
        return zipcode;
    }

    @Override
    public String toString(){
        return " " + this.city + " " + this.zipcode + ", " + this.name();
    }



}
