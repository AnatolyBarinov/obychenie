import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //1. Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        System.out.println("1. Number of minors: " +
                persons.stream()
                        .filter(person -> person.getAge() < 18)
                        .count());

        //2. Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        System.out.println("2. List of names of conscripts:");
        persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(person -> person.getFamily())
                .forEach(System.out::println);

        /*
        3. Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием
        в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        */
        System.out.println("3. List of able-bodied people with higher education:");
        persons.stream()
                .filter(person -> person.getSex() == Sex.WOMAN
                        ? person.getAge() >= 18 && person.getAge() < 60
                        : person.getAge() >= 18 && person.getAge() < 65)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted((person1, person2) -> person1.getFamily().compareTo(person2.getFamily()))
                .map(person -> person.getFamily() + " "
                        + person.getName() + ", "
                        + person.getAge() + ", "
                        + person.getEducation())
                .forEach(System.out::println);
    }
}