package creational;

public class Factory {

    public static void main(String[] args) {
        Animal dog = AnimalFactory.getInstance("DOG", 4);
        Animal bird = AnimalFactory.getInstance("BIRD", 2);

        System.out.println(dog);
        System.out.println(bird);
    }
}

abstract class Animal {

    public abstract int getFeetCount();

    // override toString method to print out feet counts
    public String toString() {
        return "Feet count: " + getFeetCount();
    }
}

class Dog extends Animal {
    int feet;

    public Dog(int feet) {
        this.feet = feet;
    }

    @Override
    public int getFeetCount() {
        return this.feet;
    }
}

class Bird extends Animal {
    int feet;

    public Bird(int feet) {
        this.feet = feet;
    }

    @Override
    public int getFeetCount() {
        return this.feet;
    }
}

// We create a factory class to generate instances
class AnimalFactory {

    public static Animal getInstance(String type, int feet) {
        if ("dog".equals(type.toLowerCase())) {
            return new Dog(feet);
        } else if ("bird".equals(type.toLowerCase())) {
            return new Bird(feet);
        } else {
            throw new IllegalArgumentException("Unexpected animal type");
        }
    }
}
