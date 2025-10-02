package reflections;

import functionalprogramming.City;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAPIDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Class cityClass = new City().getClass();
        System.out.println("Get class name: " + cityClass.getName());

        Field[] fields = cityClass.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println(cityClass.getPackageName());
        System.out.println(cityClass.getSuperclass().getName());

        Class[] interfaces = cityClass.getInterfaces();
        Arrays.stream(interfaces).forEach(i -> System.out.println(i.getName()));

        Constructor defaultConstructors = cityClass.getConstructor();
        System.out.println(defaultConstructors);

        Method[] methods = cityClass.getMethods();
        System.out.println(Arrays.stream(methods).toList());
    }
}
