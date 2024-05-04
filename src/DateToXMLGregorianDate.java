import java.sql.Date;
import java.time.Instant;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateToXMLGregorianDate {

    public static void main(String[] args) {
        java.util.Date date2 = Date.from(Instant.now());
        System.out.println(date2.toString());
        XMLGregorianCalendar xmlDate = null;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date2);

        try {
            xmlDate = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // current date time in XMLGregorian Calendar format 
        System.out.println("XMLGregorianCalendar Format :- "
                + xmlDate);

        System.out.println(xmlDate.toGregorianCalendar().getTime().toString());

    }

} 