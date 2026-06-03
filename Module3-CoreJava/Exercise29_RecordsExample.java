import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise29_RecordsExample {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> people = Arrays.asList(p1, p2, p3);
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("Adults: " + adults);
    }
}