import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class TimeStampCheck {

    public static void main(String[] args) throws ParseException {
        String timestamp = "2022-08-02T04:00:00.001Z";
        System.out.println(Timestamp.from((Instant.parse("2022-08-02T04:00:00Z"))));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(df.format(Date.from(Instant.parse("2022-08-02T04:00:00.001Z"))));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
                .withZone(TimeZone.getTimeZone("UTC").toZoneId());
        System.out.println(Instant.parse("2022-08-02T05:00:00.000000000Z"));
        System.out.println(formatter.format(Instant.parse("2022-08-02T16:00:00.000000000Z")));
        System.out.println(formatter.format(Instant.now()));
        LocalDate date = LocalDate.of(2022, 9, 1).minusMonths(1).minusDays(1).plusDays(2);
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(date.toString());
        System.out.println(localDate);
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").parse("02-08-2022"));
        System.out.println(formatter.format(Instant.parse("2022-08-02"+"T16:00:00.000Z")));
        System.out.println(java.sql.Date.valueOf("22-Nov-17"));
    }

} 