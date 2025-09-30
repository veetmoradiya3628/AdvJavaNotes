package javacollectionframework;

import java.util.*;

class Student implements Comparable<Student>{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class NameCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class ComparableComparatorTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 2, 5, 3, 8));
        list1.sort(Comparator.naturalOrder());
        System.out.println(list1);

        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");

        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);

        list2.sort(Comparator.comparingInt(String::length));
        System.out.println(list2);

        List<Student> ls = new ArrayList<>();
        ls.add(new Student(3, "Alex"));
        ls.add(new Student(2, "Charlie"));
        ls.add(new Student(1, "Bob"));
        Collections.sort(ls);
        System.out.println(ls);

        ls.sort(new NameCompare());
        System.out.println(ls);
    }
}