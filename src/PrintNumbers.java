import com.interfaces.IDummy;
import com.interfaces.IDummy2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintNumbers extends Employee implements IDummy, IDummy2 {
    public PrintNumbers(String name, double salary, String date) {
        super(name, salary, date);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(9);
        list.add(6);
        list.add(7);
        Set<Integer> set = new HashSet<>();

        for(Integer i: list) {
            set.add(i);
        }

        System.out.println(set.toString());

        System.out.println(list.stream().distinct().toList());
    }

    @Override
    public String name() {
        return IDummy.super.name();
    }
} 