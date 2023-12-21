import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainApplication {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Mangesh", "Aher", 26, 'M')
                ,new Person("Vandana", "Aher", 60, 'F'),
                new Person("Anant", "Aher", 47, 'M'),
                new Person("Ujjwala", "Aher", 45, 'F'));
        Predicate<Character> checkMale = sex -> 'M' == sex;
        Function<Person, String> func = person -> checkMale.test(person.getSex()) ?
                "Mr " + person.getFirstName() + person.getLastName() : "Ms "
                + person.getFirstName() + person.getLastName();
        Consumer<String> printlnConsumer = System.out ::println;

        personList.stream().map(func).forEach(printlnConsumer);
    }
}
