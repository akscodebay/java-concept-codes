import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MapEntryTest {

    private static final Set<Map.Entry<String, String>> x;

    static {
        Set<Map.Entry<String, String>> set = new HashSet<>();
        set.add(new AbstractMap.SimpleEntry<>("Singapore","SNG"));
        set.add(new AbstractMap.SimpleEntry<>("Singapore","HBBK"));
        set.add(new AbstractMap.SimpleEntry<>("x","y"));
        set.add(new AbstractMap.SimpleEntry<>("v","m"));
        x = Collections.unmodifiableSet(set);
    }


    public static void main(String[] args) {

        for(Map.Entry<String, String> map: x) {
            System.out.println(map.getKey()+"  "+map.getValue());
        }
    }
}
