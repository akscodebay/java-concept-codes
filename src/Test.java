import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String a = "0.343251241353144342";
        double d = 0.01202802d;
        BigDecimal bd = new BigDecimal(a);
        BigDecimal cd = new BigDecimal(a);
        System.out.println(bd);
        System.out.println(cd);
        System.out.println(bd.equals(cd));
        System.out.println("20 FEB 2022".equals(a));
        String x = "1.0";
        String y = "1";
        bd = new BigDecimal(x);
        cd = new BigDecimal(y);
        System.out.println(bd+" "+cd+" "+bd.equals(cd));


        String str = "2017-12-03";
        Date date = Date.valueOf(str);
        System.out.println("Date Value: "+date);
        List<Employee2> list = new ArrayList<>();
        Employee2 e = new Employee2("aks", 101, "7777");
        list.add(e);
        e.setName("srivastava");
        System.out.println(list.get(0));

        String str1 = "hello hai how are you";
        Map<Object, Long> charCount = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        charCount.forEach((k, v) -> System.out.println(k + ": " + v));

        List<Entry<Character, Long>> arr = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().filter((i)-> i.getValue()>1)
                .collect(Collectors.toList());

        arr.forEach(entry -> {
            if(entry.getValue()>1) {
                System.out.println(entry.getKey());
            }
        });

    }

} 
 
 