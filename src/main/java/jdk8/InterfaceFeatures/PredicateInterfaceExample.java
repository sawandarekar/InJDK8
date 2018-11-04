package jdk8.InterfaceFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate is one such function accepting a single argument to evaluate to a
 * boolean result
 *
 */
public class PredicateInterfaceExample {

    public static void main(String[] args) {
	Predicate<Person> predicate = (person) -> person.getAge() > 18;
	Person p1 = new Person("Ramesh", 20);
	Person p2 = new Person("Nilam", 10);
	boolean isEligibleVoting = predicate.test(p1);
	System.out.println(p1.getName() + ": Is eligible for voting:" + isEligibleVoting);
	boolean isEligibleVoting2 = predicate.test(p2);
	System.out.println(p1.getName() + ": Is eligible for voting:" + isEligibleVoting2);
	List<Person> list = new ArrayList<>();
	list.add(p1);
	list.add(p2);
	list.stream().filter(predicate).collect(Collectors.toList()).forEach(p -> {
	    System.out.println(p1.getName() + ": Is eligible for voting:" + isEligibleVoting);
	});
    }
}
