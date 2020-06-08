package jdk8.StreamApi;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * https://blogs.oracle.com/javamagazine/quiz-yourself-using-core-functional-interfaces-consumer-advanced
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream.of(1)
            .peek(((Consumer<Integer>)i -> { i = i + 1;}).andThen(i2 -> {i2 = i2=2;}))
            .forEach(System.out::println);
    }
}
