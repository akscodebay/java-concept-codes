import java.util.*;

public class Maps {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Emma");
        names.add("Adele");
        names.add("Aria");
        names.add("Ally");
        System.out.println(names.get(0));

        // Creating a Set
        Set<String> veg = new HashSet<String>();
        veg.add("Ginger");
        veg.add("Garlic");
        veg.add("Onion");
        veg.add("Ginger");
        veg.forEach((i) -> System.out.println(i));

        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("apple", 1);
        linkedHashMap.put("banana", 2);
        linkedHashMap.put("orange", 3);
        linkedHashMap.put("apple", 4);
        System.out.println(linkedHashMap.get("apple"));
        linkedHashMap.forEach((i,j) -> System.out.println(i+"->"+j));
        System.out.println("-----------------------------");

        // Creating a HashMap
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("orange", 3);
        hashMap.put("apple", 4);
        hashMap.forEach((i,j) -> System.out.println(i+"->"+j));

        Map<Map<String, Integer>, Integer> hashMap1 = new HashMap<>();
        hashMap1.put(hashMap, 0);
    }
}
