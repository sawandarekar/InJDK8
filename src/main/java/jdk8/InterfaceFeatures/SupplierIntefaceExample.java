package jdk8.InterfaceFeatures;

import java.util.function.Supplier;

/**
 * takes nothing but return something.
 *
 */
public class SupplierIntefaceExample {

    public static void main(String[] args) {
	Supplier<Person> supplier = () -> {
	    return new Person("Ramesh", 30);
	};

	Person p = supplier.get();
	System.out.println("Person Detail:\n" + p.getName() + ", " + p.getAge());
    }

}
