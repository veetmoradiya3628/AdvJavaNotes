package functionalprogramming;

@FunctionalInterface
public interface DistanceCalculator {
    double calculateDistance(City city1, City city2);

//    below can be multiple methods
    default void someDefaultMethod(){}
    static void someStaticMethod(){}
}
