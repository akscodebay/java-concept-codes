public class Employee2 {
    private String name;
    private double salary;
    private String date;

    public Employee2(String name, double salary, String date) {
        super();
        this.name = name;
        this.salary = salary;
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Employee2 [name=" + name + ", salary=" + salary + ", date=" + date + "]";
    }



}