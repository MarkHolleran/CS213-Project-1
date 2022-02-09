package patientdatabase;

//implement the comparable interface and implement hte compareTo() method

//cannot change or add instance variables and cannot use System.out statements unless in testbedmain

//must design tets caess to thoroughly test the compareTo() method
//write a testbed main and implement the test caases
//follow the pdf
//use // comments to identify the test case numbers in the testbed main

public class Timeslot implements Comparable<Timeslot>{
    private Date date;
    private Time time;

    @Override
    public String toString() {
        return " Appointment detail: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ", "
                + time.getHour() + ":" + time.getMinute() + "," ;
    }
    @Override
    public int compareTo(Timeslot slot){
        int dateDifference = Integer.compare(this.date.getYear(), slot.date.getYear());
        if (dateDifference != 0) {
            return dateDifference;
        }

        dateDifference = Integer.compare(this.date.getMonth(), slot.date.getMonth());
        if (dateDifference != 0) {
            return dateDifference;
        }

        dateDifference = Integer.compare(this.date.getYear(), slot.date.getYear());
        if (dateDifference != 0) {
            return dateDifference;
        }

        int hourDifference = Integer.compare(this.time.getHour(), slot.time.getHour());
        if (hourDifference != 0) {
            return hourDifference;
        }

        int minDifference = Integer.compare(this.time.getMinute(), slot.time.getMinute());
        return minDifference;
    }


}
