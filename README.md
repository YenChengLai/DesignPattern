# Design Patterns in Java

### Creational Pattern
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