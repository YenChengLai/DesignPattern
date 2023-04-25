package behavioral;

public class Strategy {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Addition());
        System.out.println(calculator.performOperation(3, 5)); // Output: 8

        calculator.setOperation(new Subtraction());
        System.out.println(calculator.performOperation(10, 4)); // Output: 6

        calculator.setOperation(new Multiplication());
        System.out.println(calculator.performOperation(6, 7)); // Output: 42

        calculator.setOperation(new Division());
        System.out.println(calculator.performOperation(15, 3)); // Output: 5
    }
}

// The context class
class Calculator {
    private Operation operation;

    // we set up the exact algorithm we want when initiating the object
    public Calculator(Operation operation) {
        this.operation = operation;
    }

    // if we ever need to change algorithm, we can use the setter class to change execution object
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int performOperation(int a, int b) {
        return this.operation.execute(a, b);
    }
}

// using an interface to define necessary behaviors (functions)
interface Operation {
    int execute(int a, int b);
}

// define different behaviors with new classes implementing the interface
class Addition implements Operation {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Operation {

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}


class Multiplication implements Operation {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public int execute(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}