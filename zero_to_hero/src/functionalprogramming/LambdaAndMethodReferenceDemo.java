package functionalprogramming;

public class LambdaAndMethodReferenceDemo {
    public static void main(String[] args) {
        OrderManagement orderManagement = new OrderManagement(new DefaultDistanceCalculator());

//        Lambda function
        orderManagement.setDistanceCalculator(new DistanceCalculator() {
            @Override
            public double calculateDistance(City city1, City city2) {
                return city1.getLatitude() - city2.getLatitude();
            }
        });

//        Lambda expression
        DistanceCalculator dCalculator1 = ((city1, city2) -> city1.getLongitude() - city2.getLatitude());
        DistanceCalculator dCalculator2 = ((city1, city2) -> {
           return city1.getLatitude() - city2.getLongitude();
        });
        orderManagement.setDistanceCalculator(dCalculator1);
        orderManagement.setDistanceCalculator(dCalculator2);

        System.out.println(orderManagement);

//        method reference
        orderManagement.setDistanceCalculator(GoogleDistanceCalculator::getDistanceBetweenCitiesStatic);
        GoogleDistanceCalculator gdc = new GoogleDistanceCalculator();
        orderManagement.setDistanceCalculator(gdc::getDistanceBetweenCities);
    }
}

class OrderManagement {
    private DistanceCalculator distanceCalculator;

    public OrderManagement(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}


class DefaultDistanceCalculator implements DistanceCalculator {

    @Override
    public double calculateDistance(City city1, City city2) {
        return 0;
    }
}

class GoogleDistanceCalculator {
    public double getDistanceBetweenCities(City c1, City c2) {
        return 1;
    }

    public static double getDistanceBetweenCitiesStatic(City c1, City c2) {
        return 1;
    }
}