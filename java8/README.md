# Java 8 Features

## Functional Interface and Lambda

Any interface having just one abstract method can be termed as functional 
interface. 

```java
public interface FInterface{
    public String concat(String first, String second);
}
```

Here we have one interface with a single abstract method, whenever this 
interface is passed to any method externally, we can consider that the 
abstract method implementation has to be used inside that method. This 
implementation can be written using _lambda expression_

```java
FInterface finterface = (first, second) -> first + second;
```
So whenever we are writing lambda expression, we are writing the implementation 
of abstract method inside Functional interface, where the input and output are
of the type specified in method.

## Functional Interfaces in Java 8

In _java.util.function_ package, inbuilt Functional interfaces are defined.
Some of them are :-

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```
Function interface is with abstract method having single input and output </br>
Consumer interface is with abstract method having single input and no output </br>
Predicate interface is with abstract method having single input and boolean output </br>
Supplier interface is with abstract method having no input and Type output </br>
BiConsumer interface is with abstract method having two inputs and no output </br>

Examples :-

```java
Predicate<Character> checkMale = sex -> 'M' == sex;

Function<Person, String> func = person -> checkMale.test(person.getSex()) ?
                "Mr " + person.getFirstName() + person.getLastName() : "Ms "
                + person.getFirstName() + person.getLastName();

Consumer<String> printlnConsumer = System.out ::println;

Supplier<Double> supplier = () -> Math.random();

BiConsumer<Integer, Integer> biConsumer = (a,b) -> functionCall(a-1, b+1);

Comparator<Person> personNameComparator = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
```

## Stream API