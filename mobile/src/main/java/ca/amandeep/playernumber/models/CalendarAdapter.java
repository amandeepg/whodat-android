package ca.amandeep.playernumber.models;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarAdapter {
    @ToJson
    String toJson(Calendar calendar) {
        return calendar.toString();
    }

    @FromJson
    Calendar fromJson(String calendarStr) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        final Date date;
        try {
            date = sdf.parse(calendarStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}