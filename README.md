# Design Patterns in Java

### Creational Patterns
1. Singleton
  - purpose: to ensure there's only one instance generated
  - type:
    - Single Thread Model
      - Eager Instantiation
      - Lazy Instantiation
    - Multi-thread Model
      - Method Synchronized
      - Double-checked Locking
  - common use cases:
    - resource management
      - database connection
      - configuration management
      - system logging
    - statement control
      - session management
      - cache management
2. Factory
  - purpose: provide a common interface for creating objects, while encapsulating the object creation process
  - common use cases:
    - dependency injections
    - Creation of objects with complex initialization logic
    - Creation of objects in a multithreaded environment
  - benefit: using factory can encapsulate the object creating process, which makes it easier to maintain, especially in large and complex project code base
3. Builder
  - purpose: to simplify the creation process for a complex object (too many parameters in the constructor)
  - common use cases:
    - creating complex objects
    - encapsulating the construction logic of an object
    - generating different representations of an object based on pass-in parameters
  - benefits:
    - separation of concerns
    - readability and maintainability
    - flexibility in creation process
4. Prototype
  - purpose: to create new object efficiently by duplicate an existing one
  - common use cases:
    - creating new instance with similar status
    - when the object creating process is expensive (like reading resources)
    - when you need to decouple the object creation process from the class hierarchy
  - benefits:
    - improve object creation performance
    - simplify object creation process
    - support runtime object creation
    
### Behavioral Patterns
1. Strategy
   - purpose: allow the context object to choose appropriate algorithm at runtime and encapsulate each algorithm in different classes
   - common use cases:
     - when there are multiple ways to perform a task, and it needed to switch frequently.
     - when you want to decouple the algorithms from the class
   - benefit:
     - decoupling and make the code more flexible
     - separation of concerns by encapsulate behaviors in different classes
     - don't need to change the context class when adding new algorithms
   - note: it's very similar to the polymorphism idea
