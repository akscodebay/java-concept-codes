import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    private static void permutation(List<String> result, boolean[] used, char[] chars, StringBuilder path) {
        if(path.length() == chars.length) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]){
                continue;
            }

            if(i>0 && chars[i]==chars[i-1] && !used[i-1]) continue;

            used[i] = true;
            path.append(chars[i]);
            permutation(result, used, chars, path);
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String word = "AbC3";
        boolean[] used = new boolean[word.length()];
        List<String> result = new ArrayList<>();
        permutation(result, used, word.toCharArray(), new StringBuilder());
        result = result.stream().filter(i->Character.isDigit(i.charAt(0))).collect(Collectors.toList());
        Collections.sort(result);
        result.forEach(System.out::println);
    }
}
