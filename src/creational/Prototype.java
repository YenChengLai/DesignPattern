package creational;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) {
        // Creating an initial user object
        User user1 = new User("Alice", "alice@example.com");
        user1.addFriend("Bob");
        user1.addFriend("Carol");

        System.out.println("User1: " + user1);

        // Cloning the user object
        User user2 = user1.clone();
        user2.setName("Jack");
        user2.setEmail("jack@example.com");
        user2.addFriend("David");

        // Deep copy: changing the fields in the new object didn't affect the old one
        System.out.println("User2: " + user2);
    }
}

class User implements Cloneable {

    private String name;
    private String email;
    private List<String> friends;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.friends = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addFriend(String friend) {
        friends.add(friend);
    }

    @Override
    public User clone() {
        User newUser = new User(this.name, this.email);
        newUser.friends = new ArrayList<>(this.friends);
        return newUser;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', friends=" + friends + '}';
    }
}