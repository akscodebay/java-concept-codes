import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Employee {

    private final String name;
    private final double salary;
    private final String date;

    public Employee(String name, double salary, String date) {
        super();
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDate() {
        return date;
    }



    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", date=" + date + "]";
    }

    public static void main(String[] args) throws ParseException {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("aks", 10201, "2022-08-01"));
        list.add(new Employee("Aks2", 10202, "2022-08-02"));
        list.add(new Employee("Aks3", 10203, "2022-08-03"));
        list.add(new Employee("Aks4", 10204, "2022-08-04"));
        list.add(new Employee("Aks6", 10204, "2022-08-06"));
        list.add(new Employee("Aks7", 10204, "2022-08-07"));
        System.out.println(list);
        list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).
                skip(4).limit(1).findFirst().ifPresentOrElse((i)->System.out.println(i),
                        () -> System.out.println("No Records available"));
        System.out.println(list.stream().max(Comparator.comparing(Employee::getSalary)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-30"));
        ListIterator<Employee> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            if(new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-01")
                    .before(new SimpleDateFormat("yyyy-MM-dd").parse(listIterator.next().date))) {
                listIterator.previous();
                break;
            }
        }
        if(!listIterator.hasPrevious()) {
            System.out.println("null");
        }
        else
            System.out.println(listIterator.previous());
    }

} 