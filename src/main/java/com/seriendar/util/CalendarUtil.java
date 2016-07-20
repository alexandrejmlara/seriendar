package com.seriendar.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Controla ações relacionadas ao calendário de séries.
 *
 * Obtem a lista de dias da semana baseando-se no dia que é
 * passado como parâmetro em seu método.
 *
 */
public class CalendarUtil {

    /**
     * Recupera um lista de objetos {@link DayOfWeek} contendo os dias da semana, iniciando-se no Domingo.
     *
     * @param refDate Dia de referência
     * @param firstDayOfWeek Primeiro dia da semana a ser considerado
     * @return Lista contendo os dias da semana da data de referência
     */
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

    /**
     * Utilizado internamente para obter um array de dias da semana
     *
     * @param refDate Dia de referência
     * @param firstDayOfWeek Primeiro dia da semana a ser considerado
     * @return Array contendo os dias da semana da data de referência
     */
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
