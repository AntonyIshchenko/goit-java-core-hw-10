import com.google.gson.Gson;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = new Person("John", 30);

        // Серіалізація в JSON
        String json = gson.toJson(person);
        System.out.println("JSON: " + json);

        // Десеріалізація з JSON
        Person newPerson = gson.fromJson(json, Person.class);
        System.out.println("Name: " + newPerson.name + ", Age: " + newPerson.age);
    }
}