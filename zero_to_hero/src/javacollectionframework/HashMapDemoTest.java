package javacollectionframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class HashMapDemoTest {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("John", 25);
        hashMap.put("Rakesh", 12);
        hashMap.put("Imran", 34);

        System.out.println(hashMap);
        System.out.println(hashMap.get("John"));
        System.out.println(hashMap.getOrDefault("John", 0));
        System.out.println(hashMap.getOrDefault("Johny", 0));

        System.out.println(hashMap.containsKey("Feet"));
        System.out.println(hashMap.size());

        HashMap<Employee, Integer> empMap = new HashMap<>();

        Employee emp1 = new Employee(101, "Alice");
        Employee emp2 = new Employee(102, "Bob");
        Employee emp3 = new Employee(103, "Charlie");
        Employee emp4 = new Employee(101, "Alice");

        empMap.put(emp1, Math.abs(new Random().nextInt() * 100));
        empMap.put(emp2, Math.abs(new Random().nextInt() * 100));
        empMap.put(emp3, Math.abs(new Random().nextInt() * 100));
        System.out.println(empMap);

        empMap.put(emp4, Math.abs(new Random().nextInt() * 100));
        System.out.println(empMap);

        for(Map.Entry<Employee, Integer> entry: empMap.entrySet())
            System.out.println(entry.getKey() + " "  + entry.getValue() + " " + entry.getKey().hashCode());
    }
}
