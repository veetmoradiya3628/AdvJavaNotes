package basics;

import java.time.Month;

enum Priority {
    HIGH,
    LOW,
    MEDIUM
}

public class EnumTests {
    public static void main(String[] args) {
        Priority priority = Priority.HIGH;
        switch (priority){
            case LOW -> System.out.println("Low Priority");
            case HIGH -> System.out.println("High Priority");
            case MEDIUM -> System.out.println("Medium priority");
            default -> System.out.println("Invalid priority");
        }

        Priority[] values = Priority.values();
        for(Priority p : values){
            System.out.println(p + " => " + p.ordinal());
        }
        
        Month[] months = Month.values();
        for (Month m: months){
            System.out.println(m + " " + m.ordinal());
        }

    }
}
