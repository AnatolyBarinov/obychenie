import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age = Integer.MIN_VALUE;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != Integer.MIN_VALUE;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            throw new IllegalArgumentException("Возраст неизвестен");
        }
    }

    public PersonBuilder newChildBuilder(){
        return new PersonBuilder().setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age == Integer.MIN_VALUE ? 0 : age) +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}