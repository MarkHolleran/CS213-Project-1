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

    public Timeslot (Date date, Time time){

        this.date = date;
        this.time = time;

    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {

        if(time.getMinute() == 0){
            return " Appointment detail: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ", "
                    + time.getHour() + ":0" + time.getMinute() + "," ;
        }else{
            return " Appointment detail: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + ", "
                    + time.getHour() + ":" + time.getMinute() + "," ;
        }

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

        dateDifference = Integer.compare(this.date.getDay(), slot.date.getDay());
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


    //TEST BED MAIN
    //used for testing the compareto method in the timeslot class
    //this shit be 10 points too
    public static void main(String[] args){


        //Test 1: 28 days in february when non leapyear
        System.out.println("test 12");
        Date test12 = new Date("2/29/2021");
        if (test12.isValid()) System.out.println("test 12 failed");
        else System.out.println("test 12 passed");

        //Test 2:
        //Test 3:
        //Test 4:
        //Test 5:
        //Test 6:
        //Test 7:
        //Test 8:
        //Test 9:
        //Test 10:
        //Test 11:







    }
}
