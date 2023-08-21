public class PersonBuilder {
    //...
    private String name;
    private String surname;
    private int age = Integer.MIN_VALUE;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Каждый человек в России обязан иметь имя и фамилию");
        }
        return new Person(name, surname, age, address);
    }
}