package patientdatabase;

import java.util.StringTokenizer;

//must implement the comparable interface
//implement the compareTo() method

//cannot change or add instance variables and cannot use System.out statements
public class Time implements Comparable<Time>{

    private int hour;
    private int minute;

    public Time(int hour, int minute){

        this.hour = hour;
        this.minute = minute;

    }

    public Time(String inputTime){

        String newTime = inputTime;

        StringTokenizer segmentedTime = new StringTokenizer(inputTime,":");

        this.hour = Integer.parseInt(segmentedTime.nextToken());
        this.minute = Integer.parseUnsignedInt((segmentedTime.nextToken()));

    }

    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }

    public boolean isValid(){
        if (hour < 9 || hour > 16 || minute % 15 != 0 || minute < 0 || minute > 45){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        if(minute == 0){
            return hour + ":0" + minute;
        }else{
            return hour + ":" + minute;
        }

    }
    @Override
    public int compareTo(Time time){
        int hourDifference = Integer.compare(this.hour, time.hour);
        if (hourDifference != 0) {
            return hourDifference;
        }

        int minDifference = Integer.compare(this.minute, time.minute);
        return minDifference;
    }

}
