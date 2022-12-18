public class _Month {
    private String label;
    private int totalDays;
    private int monthIndex;

    _Month(){

    }
    _Month(int month, Boolean isLeapYear){

        int index = month - 1;
        String[] months = { "January","February","March","April","May","June","July","August","September","October","November","December" } ;
        int[] days = { 31,28,31,30,31,30,31,31,30,31,30,31 };

        monthIndex = index;
        label = months[index];
        totalDays = days[index];
        if( (index == 1) && (isLeapYear) ){
            totalDays = 29;
        }

    }

    public String getLabel(){
        return label;
    }

    public int getTotalDays(){
        return totalDays;
    }

    public int getMonthIndex(){
        return monthIndex;
    }
}
