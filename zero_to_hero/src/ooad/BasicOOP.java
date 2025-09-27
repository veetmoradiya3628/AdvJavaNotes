package ooad;

class Car {
    int carId;
    String carName;
    String brand;

    public Car() {
    }

    public Car(int carId, String carName, String brand) {
        this.carId = carId;
        this.carName = carName;
        this.brand = brand;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

public class BasicOOP {
    public static void main(String[] args) {
        Car c1 = new Car(1, "Volvo", "Volvo");
        Car c2 = new Car(2, "Audi A4", "Audi");
        Car c3 = new Car(3, "Verna", "Hyundai");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
