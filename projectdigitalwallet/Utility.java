package projectdigitalwallet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class Utility {

    public static Date LocalDateTimeToDate(LocalDateTime ldt) {
        return Date.from(ldt.toInstant(ZoneOffset.UTC));
    }

    public static Date LocalDateToDate(LocalDate ld) {
        ZoneId zd = ZoneId.systemDefault();
        return Date.from(ld.atStartOfDay(zd).toInstant());
    }

    public static Date GetCurrentDate() {
        return LocalDateTimeToDate(LocalDateTime.now());
    }
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

    public static String GetCurrentDateAsString() {
        return sf.format(LocalDateTimeToDate(LocalDateTime.now()));
    }
}
