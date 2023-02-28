package part2A.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Вывод даты и времени получения и сдачи задания
 */
public class Task {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM y HH:mm");

    public Task (int day, int month, int year, int hours, int minutes){
        calendar.set(year,month,day,hours,minutes);
    }
//
    public String toString(){
        return simpleDateFormat.format(calendar.getTime());
    }
}
