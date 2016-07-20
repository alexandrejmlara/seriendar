package com.seriendar.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre Lara on 19/07/2016.
 */
public class CalendarUtil {

    public static List<DayOfWeek> getDaysOfWeekArray(Date refDate, int firstDayOfWeek){
        Date[] days = getDaysOfWeek(refDate, firstDayOfWeek);
        List<DayOfWeek> daysOfWeekList = new ArrayList<DayOfWeek>();

        for (Date day : days) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            int thisDay = cal.get(Calendar.DAY_OF_MONTH);
            int thisMonth = cal.get(Calendar.MONTH) + 1;
            int thisYear = cal.get(Calendar.YEAR);
            DayOfWeek dayToSave = new DayOfWeek(thisDay, thisMonth, thisYear);
            daysOfWeekList.add(dayToSave);
        }

        return daysOfWeekList;
    }

    private static Date[] getDaysOfWeek(Date refDate, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(refDate);
        calendar.set(java.util.Calendar.DAY_OF_WEEK, firstDayOfWeek);
        Date[] daysOfWeek = new Date[7];
        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = calendar.getTime();
            calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
        }
        return daysOfWeek;
    }
}
