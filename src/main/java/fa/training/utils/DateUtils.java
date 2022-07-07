package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //// TODO: 7/2/2022 this convert SQL date to Util Date
    public static java.util.Date convertSQLToUtilDate(java.sql.Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        return new java.util.Date(sqlDate.getTime());
    }
    //// TODO: 7/2/2022 this convert Utils Date to SQL date
    public static java.sql.Date convertUtilToSQLDate(java.util.Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new java.sql.Date(utilDate.getTime());
    }
    //// TODO: 7/2/2022 this convert String to Util date with format MM/dd/YYYY

    /**
     * @String date - formart MM/dd/yyyy
     * @return
     */
    public static java.util.Date convertStringToUtilDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try{
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    //// TODO: 7/2/2022 this convert Util Date to String with format MM/dd/YYYY
    public static String convertUtilDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    //// TODO: 7/2/2022 this convert LocalDate to Util.Date
    public static Date convertToDateViaSqlDate(java.time.LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }


    //// TODO: 7/2/2022 this convert LocalDateTime to Util date
    public static Date convertToDateViaInstant(java.time.LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}

