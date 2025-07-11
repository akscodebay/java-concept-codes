import java.util.*;

public class StudentsComparatorExample {
    private String name;
    private Map<String, Integer> subjectList;

    public StudentsComparatorExample(String name, Map<String, Integer> subjectList) {
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Map<String, Integer> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }

    public static void main(String[] args) {
        Map<String, Integer> stuSubjectList1 = new HashMap<>();
        stuSubjectList1.put("Maths", 80);
        stuSubjectList1.put("English", 75);
        StudentsComparatorExample stu1 = new StudentsComparatorExample("aayush", stuSubjectList1);
        Map<String, Integer> stuSubjectList2 = new HashMap<>();
        stuSubjectList2.put("Maths", 79);
        stuSubjectList2.put("English", 70);
        StudentsComparatorExample stu2 = new StudentsComparatorExample("Aman", stuSubjectList2);
        List<StudentsComparatorExample> stulist = new ArrayList<>();
        stulist.add(stu1);
        stulist.add(stu2);
        stulist.sort(Comparator.comparing((StudentsComparatorExample student) -> student.getSubjectList().get("Maths")).reversed());
        System.out.println(stulist.getFirst());
    }
}

