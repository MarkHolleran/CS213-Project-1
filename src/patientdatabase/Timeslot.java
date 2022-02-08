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
        return "";
    }
    @Override
    public int compareTo(Timeslot slot){
        int dateDifference = this.date.year.compareTo(slot.date.year);
        if (dateDifference != 0) {
            return dateDifference;
        }

        dateDifference = this.date.month.compareTo(slot.date.month);
        if (dateDifference != 0) {
            return dateDifference;
        }

        dateDifference = this.date.day.compareTo(slot.date.day);
        if (dateDifference != 0) {
            return dateDifference;
        }

        int hourDifference = this.time.hour.compareTo(slot.time.hour);
        if (hourDifference != 0) {
            return hourDifference;
        }

        int minDifference = this.time.minute.compareTo(slot.time.minute);
        return minDifference;
    }


}
