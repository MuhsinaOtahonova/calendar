import java.time.*;

public class _Date {
    private int year;
    private _Month month;
    private int day;
    _Date(){
        LocalDate currentdate = LocalDate.now();
        year = currentdate.getYear();
        month = new _Month(currentdate.getMonthValue(), isLeapYear());
        day = currentdate.getDayOfMonth();
    }

    public void setDate(LocalDate date){
        year = date.getYear();
        month = new _Month(date.getMonthValue(), isLeapYear());
        day = date.getDayOfMonth();
    }
    public void setMonth(int monthIndex){
        month = new _Month(monthIndex + 1, isLeapYear());
    }

    public void setYear(int yearValue){
        year = yearValue;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Boolean isLeapYear(){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int getMonthStartDayIndex(){
        LocalDate newDate = LocalDate.of(year, month.getMonthIndex() + 1, day);
        LocalDate monthBegin = newDate.withDayOfMonth(1);
        int index = monthBegin.getDayOfWeek().getValue();
        if(index == 7) index = 0;
        return index;
    }
    public int getYear(){
        return year;
    }

    public _Month getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }
}
