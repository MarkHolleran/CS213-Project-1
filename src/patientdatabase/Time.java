    package patientdatabase;

    //must implement the comparable interface
    //implement the compareTo() method

    //cannot change or add instance variables and cannot use System.out statements
    public class Time implements Comparable<Time>{

        //do i use this??
        public Time(int hour, int minute){

        }

        private int hour;
        private int minute;

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
            return hour + ":" + minute;
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
