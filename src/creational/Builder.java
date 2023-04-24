package creational;

public class Builder {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder("Toyota", "Camry").setYear(2022).setColor("Blue").setSunroof(true).build();

        Car car2 = new Car.CarBuilder("Honda", "Civic").setYear(2021).setColor("Red").build();

        System.out.println(car1);
        System.out.println(car2);
    }
}

class Car {
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private boolean sunroof;

    // private constructor to force objects being created through builder object
    private Car(CarBuilder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
    }

    // create a nested static class as the Builder class, we did this because:
    // 1. Encapsulation: helping the outer class object's parameters organized and encapsulated
    // 2. Access to outer class: static class can access to the outer class's parameters
    // 3. Independence: if announced static, the inner class is independent to the outer.
    //    In other word, we don't need to create an outer class object to use the inner one
    public static class CarBuilder {
        private String manufacturer;
        private String model;
        private int year;
        private String color;
        private boolean sunroof;

        // These two are the required parameters
        public CarBuilder(String manufacturer, String model) {
            this.manufacturer = manufacturer;
            this.model = model;
        }

        // provide setter methods for optional parameters
        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [manufacturer=" + manufacturer + ", model=" + model + ", year=" + year + ", color=" + color + ", sunroof=" + sunroof + "]";
    }
}

