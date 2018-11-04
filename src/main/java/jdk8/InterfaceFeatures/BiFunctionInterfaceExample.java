package jdk8.InterfaceFeatures;

import java.util.function.BiFunction;

/**
 * 
 * It represents a function that accepts two arguments and returns a result.
 */
public class BiFunctionInterfaceExample {
    public static void main(String[] args) {
	BiFunction<Person, Person, Integer> biFunction = (p1, p2) -> {
	    return p1.getAge() + p2.getAge();
	};

	int totalAge = biFunction.apply(new Person("Ramesh", 10), new Person("ram", 10));
	System.out.println(totalAge);
    }
}
