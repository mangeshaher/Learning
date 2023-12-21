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
