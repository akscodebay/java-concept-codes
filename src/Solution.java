import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Solution {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "three", "five", "six", "seven");
        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(i->i, i->i,
                        (oldVal, newVal)->oldVal));
        System.out.println(map);
    }
}