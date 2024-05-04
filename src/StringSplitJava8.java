import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringSplitJava8 {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("aks", "limit");
        map.put("bks", "limit1");
        map.put("cks", "limit2");


        String str = "bks";
        String pks = "";

        " ,US, ,,,,".split(",", -1);

        pks = String.join(",", Arrays.stream(str.split(",")).map(i->map.get(i)).toList());

        System.out.println(pks);

    }

} 