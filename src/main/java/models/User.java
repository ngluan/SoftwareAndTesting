package models;

public class User {
<<<<<<< HEAD
    int id;
    String name;
    int age;
=======
    private int id;
    private String name;
    private int age;
>>>>>>> 97e221e2c6630479256addcb31885b5c3f06417a

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int setId() {
        this.id = id;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
