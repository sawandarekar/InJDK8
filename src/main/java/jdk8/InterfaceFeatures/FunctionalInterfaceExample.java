package jdk8.InterfaceFeatures;

import java.util.function.Function;

/**
 * A functional interface is an interface that has exactly one abstract method.
 *
 *
 */
public class FunctionalInterfaceExample {

    public static void main(String[] args) {
	// convert centigrade to fahrenheit
	Function<Integer, Double> centigradeToFahrenheitInt = x -> new Double(x * 9 / 5 + 32);

        // String to an integer
	Function<String, Integer> stringToInt = x -> Integer.valueOf(x);
        System.out.println(" String to Int: " + stringToInt.apply("4"));


	Function<Person, Person> function = entity -> {
	    return new Person(entity.getName(), entity.getAge());
        };
	Person personDTO = function.apply(new Person("ramesh", 20));
        System.out.println(personDTO.getName());
        System.out.println(personDTO.getAge());
    }

}
