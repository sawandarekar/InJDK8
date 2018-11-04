package jdk8.InterfaceFeatures;

/**
 * A functional interface is an interface that has exactly one abstract method.
 *
 * It represents a function that accepts one argument and returns a result.
 */
@FunctionalInterface
interface Functional_Interface {
    void say(String s);
}

public class Functional_Interface_Example {
    public static void main(String[] args) {
	Functional_Interface functionalInterface = (msg) -> {
	    System.out.println("Message:" + msg);
	};
	functionalInterface.say("hello..functional...");
    }
}
