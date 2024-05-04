import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class Fxrate {

    private String dateTime;
    private String currency;

    public Fxrate(String dateTime, String currency) {
        super();
        this.dateTime = dateTime;
        this.currency = currency;
    }



    public String getDateTime() {
        return dateTime;
    }



    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }



    public String getCurrency() {
        return currency;
    }



    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "fxrate [dateTime=" + dateTime + ", currency=" + currency + "]";
    }



    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
                .withZone(TimeZone.getTimeZone("UTC").toZoneId());

        Fxrate fr1 = new Fxrate("2022-08-09T04:00:00Z", "INR");
        Fxrate fr2 = new Fxrate("2022-08-07T04:00:00Z", "INR");
        Fxrate fr3 = new Fxrate("2022-08-08T04:00:00Z", "INR");
        Fxrate fr4 = new Fxrate("2022-08-07T04:00:10Z", "INR");
        Fxrate fr5 = new Fxrate("2022-08-07T04:00:10Z", null);

        List<Fxrate> list = new ArrayList<>();
        list.add(fr1);
        list.add(fr2);
        list.add(fr3);
        list.add(fr4);
        list.add(fr5);

        list.sort(Comparator.comparing(Fxrate::getDateTime, Comparator.reverseOrder()));

        list.stream().forEach(i->i.setDateTime(formatter.format(Instant.parse(i.getDateTime()))));

        for (Fxrate fxrate : list) {
            System.out.println(fxrate.getDateTime());
        }
        String time="2022-08-09";

        System.out.println(time.substring(0, 10).equals(list.get(0).getDateTime().substring(0, 10)));

        System.out.println(fr5.getCurrency() == null);

    }

} 