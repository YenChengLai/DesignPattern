package creational;

public class Singleton {

    public static void main(String[] args) {
        // Test eager type Singleton
        SingletonEager eager = SingletonEager.getInstance();
        SingletonEager eager1 = SingletonEager.getInstance();

        System.out.println(eager == eager1); // should return true

        // Test lazy type Singleton
        SingletonLazy lazy = SingletonLazy.getInstance();
        SingletonLazy lazy1 = SingletonLazy.getInstance();

        System.out.println(lazy == lazy1); // should return true
    }
}

// Eager Initialization: create instance in the beginning
class SingletonEager {
    // Creating the instance while declaring the class
    private static SingletonEager instance = new SingletonEager();

    // Use a private constructor to prevent the instance being created with "new" keyword
    private SingletonEager() {

    }

    // provide a way to get instance
    public static SingletonEager getInstance() {
        return instance;
    }
}

// Lazy Initialization: create instance when first called
class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            return new SingletonLazy();
        }
        return instance;
    }
}

class SingletonSyncMethod {

    private static SingletonSyncMethod instance;

    private SingletonSyncMethod() {

    }

    // We add synchronized keyword to ensure there's only one instance in multi-thread environment
    public static synchronized SingletonSyncMethod getInstance() {
        if (instance == null) {
            return new SingletonSyncMethod();
        }
        return instance;
    }
}

class SingletonSync {

    // we use "volatile" to ensure changes to the variable are immediately visible to all threads
    // and helps to avoid any caching issues that might arise.
    private static volatile SingletonSync instance;

    private SingletonSync() {

    }

    // Compared with synchronized the whole method, here we allow every thread to call this method in a
    // multi-thread env. However, we only use synchronized keyword when initiate the class. This is the
    // Double-checked locking technique
    public static SingletonSync getInstance() {
        if (instance == null) {
            synchronized (SingletonSync.class) {
                if (instance == null) {
                    instance = new SingletonSync();
                }
            }
        }
        return instance;
    }
}
