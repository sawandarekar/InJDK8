package jdk8.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jdk8.InterfaceFeatures.Person;

public class FilteringCollectionUsingStream {
    List<Person> listPerson = new ArrayList<>();

    public static void main(String[] args) {
	Person p1 = new Person("name1", 10);
	Person p2 = new Person("name2", 20);
	Person p3 = new Person("name3", 30);
	Person p4 = new Person("name4", 40);
	Person p5 = new Person("name5", 50);
	Person p6 = new Person("name6", 60);
	Person p7 = new Person("name7", 70);

	FilteringCollectionUsingStream example = new FilteringCollectionUsingStream();
	example.listPerson.add(p1);
	example.listPerson.add(p2);
	example.listPerson.add(p3);
	example.listPerson.add(p4);
	example.listPerson.add(p5);
	example.listPerson.add(p6);
	example.listPerson.add(p7);

	example.withoutStream();
	example.withStream();
    }

    private void withoutStream() {
	System.out.println("without stream");
	List<Person> filteredPerson = new ArrayList<>();
	for (Person person : listPerson) {
	    if (person.getAge() >= 50) {
		filteredPerson.add(person);
	    }
	}
	for (Person person : filteredPerson) {
	    System.out.println("having age >= 50 :" + person.getName());
	}
    }

    private void withStream() {
	System.out.println("with stream");
	List<Person> filteredPerson = listPerson.stream().filter(p -> p.getAge() <= 40).collect(Collectors.toList());
	filteredPerson.forEach(p -> System.out.println("having age <= 40 :" + p.getName()));
    }

}
