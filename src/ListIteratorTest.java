import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aks");
        list.add("aks2g");
        list.add("aks3g");
        list.add("aks4g");
        list.add("aks5g");
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.remove();
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("aks");
        list2.add("aks2g");
        list2.add("aks3g");

        list.addAll(list2);
        System.out.println(list);
    }

} 