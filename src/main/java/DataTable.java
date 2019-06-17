import java.util.*;

public class DataTable {
    final int year = 2019;
    final int month = 5;
    final int day = 3;

    public Integer getRowDate() {
        int rowValue = 0;
        Map<Date, Integer> map = new HashMap();

        Calendar calendar = new GregorianCalendar(year, month, day);

        for (int i = 1; i < 1620; i += 18) {
            Date date = calendar.getTime();

            map.put(date, i);
            calendar.add(Calendar.DAY_OF_MONTH, +1);
        }

        Set<Map.Entry<Date, Integer>> set = map.entrySet();

        Iterator iterator = set.iterator();

        Calendar calendarDay = Calendar.getInstance();
        calendarDay.set(calendarDay.get(Calendar.YEAR)
                , calendarDay.get(Calendar.MONTH)
                , calendarDay.get(Calendar.DAY_OF_MONTH)
                , 00, 00, 00);
        calendarDay.set(Calendar.MILLISECOND, 0);

        while (iterator.hasNext()) {
            Map.Entry<Date, Integer> entry = (Map.Entry<Date, Integer>) iterator.next();
            Date dayCurrent = calendarDay.getTime();

            if (entry.getKey().equals(dayCurrent)) {
                rowValue = entry.getValue();
            }
        }

        return rowValue;
    }

    public Integer getRowTime(Integer rowDate) {
        Calendar calendar = Calendar.getInstance();
        int timeHour = calendar.get(Calendar.HOUR_OF_DAY);
        int rowTime = 0;
        int rowTable = 3;

        for (int i = 8; i < 22; i++) {
            if (timeHour == i) {
                rowTime = rowDate + rowTable;
            }
            rowTable++;
        }

        return rowTime;
    }
}
