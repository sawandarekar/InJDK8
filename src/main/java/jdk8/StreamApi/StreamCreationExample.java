package jdk8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import jdk8.InterfaceFeatures.Person;

public class StreamCreationExample {
    List<Person> listPerson = new ArrayList<>();

    public static void main(String[] args) {
	Person p1 = new Person("name1", 10);
	Person p2 = new Person("name2", 20);
	Person p3 = new Person("name3", 30);
	Person p4 = new Person("name4", 40);
	Person p5 = new Person("name5", 50);
	Person p6 = new Person("name6", 60);
	Person p7 = new Person("name7", 70);

	StreamCreationExample example = new StreamCreationExample();
	example.listPerson.add(p1);
	example.listPerson.add(p2);
	example.listPerson.add(p3);
	example.listPerson.add(p4);
	example.listPerson.add(p5);
	example.listPerson.add(p6);
	example.listPerson.add(p7);

	example.createEmptyStream();
	example.createFromCollections();
	example.createFromArray();
	example.createFromStreamBuilder();
	example.createFromStreamGenerate();
	example.createFromStreamIterate();
	example.streamOfPrimitives();
    }

    private void streamOfPrimitives() {
	System.out.println("streamOfPrimitives");
	IntStream intStream = IntStream.range(1, 3);
	intStream.forEach(System.out::println);

	LongStream longStream = LongStream.rangeClosed(1, 3);
	longStream.forEach(System.out::println);

	Random random = new Random();
	DoubleStream doubleStream = random.doubles(3);
	doubleStream.forEach(System.out::println);
    }

    private void createFromStreamIterate() {
	System.out.println("createFromStreamIterate");
	Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 1).limit(5);
	streamIterated.forEach(System.out::println);
    }

    private void createEmptyStream() {
	System.out.println("createEmptyStream");
	Stream<String> empytyStream = Stream.empty();
	empytyStream.forEach(System.out::print);
    }

    private void createFromCollections() {
	System.out.println("createFromCollections");
	Collection<String> collection = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
	Stream<String> stream2 = collection.stream();
	stream2.forEach(System.out::println);

	List<String> list = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
	Stream<String> stream3 = list.stream();
	stream3.forEach(System.out::println);

	Set<String> set = new HashSet<>(list);
	Stream<String> stream4 = set.stream();
	stream4.forEach(System.out::println);
    }

    private void createFromArray() {
	System.out.println("createFromArray");
	// Array can also be a source of a Stream
	Stream<String> streamOfArray = Stream.of("a", "b", "c");
	streamOfArray.forEach(System.out::println);

	// creating from existing array or of a part of an array:
	String[] arr = new String[] { "a", "b", "c" };
	Stream<String> streamOfArrayFull = Arrays.stream(arr);
	streamOfArrayFull.forEach(System.out::println);

	Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
	streamOfArrayPart.forEach(System.out::println);
    }

    private void createFromStreamBuilder() {
	System.out.println("createFromStreamBuilder");
	Stream<String> stringStream = Stream.<String>builder().add("a").add("b").add("c").build();
	stringStream.forEach(System.out::println);
    }

    private void createFromStreamGenerate() {
	System.out.println("createFromStreamGenerate");
	Stream<String> stringStream = Stream.generate(() -> "element").limit(4);
	stringStream.forEach(System.out::println);
    }

}
