package basics;

import java.util.Arrays;
import java.util.List;

class GenericDemo <T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class GenericDemo1 <T, E> {
    private T t;
    private E e;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "GenericDemo1{" +
                "t=" + t +
                ", e=" + e +
                '}';
    }
}

public class GenericsTest {
    private static <E> void printArray(E[] arr){
        for(E element: arr){
            System.out.print("Element : " + element + ",");
        }
        System.out.println();
    }

    private static <T extends Comparable<T>> T maxValue(T x, T y, T z){
        T max = x;
        if (y.compareTo(max) > 0){
            max = y;
        }
        if(z.compareTo(max) > 0){
            max = z;
        }
        return max;
    }

    public static void printOnlyIntegerClassorSuperClass(
            List<? super Integer> list)
    {
        System.out.println(list);
    }
    private static void printlist(List<?> list)
    {

        System.out.println(list);
    }
    public static void main(String[] args) {
        String[] arr1 = {"One", "Two", "Three"};
        printArray(arr1);
        Integer[] arr2 = {1, 2, 3};
        printArray(arr2);

        System.out.println("Max value of 1, 2, 3 : "+ maxValue(1, 2, 3));
        System.out.println("Max value of 1.2, 2.3, 3.1 : "+ maxValue(1.2, 2.1, 3.1));
        System.out.println("Max value of veet, dhruvi, dummy : "+ maxValue("veet", "dhruvi", "dummy"));

        GenericDemo<String> g1 = new GenericDemo<>();
        g1.setT("Veet");
        System.out.println(g1.getT());

        GenericDemo<Double> g2 = new GenericDemo<>();
        g2.setT(5.4);
        System.out.println(g2.getT());

        GenericDemo1<String, Integer> gd1 = new GenericDemo1<>();
        gd1.setT("Veet");
        gd1.setE(1);
        System.out.println(gd1);

        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
        printOnlyIntegerClassorSuperClass(list1);

        List<Number> list2 = Arrays.asList(4, 5, 6, 7);
        printOnlyIntegerClassorSuperClass(list2);

        List<Double> lst2 = Arrays.asList(1.1, 2.2, 3.3);

        printlist(list1);

        printlist(lst2);
    }
}
