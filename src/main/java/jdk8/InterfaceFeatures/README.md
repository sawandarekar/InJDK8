http://www.javaguides.net/2018/07/java-8-functional-interfaces.html


    A functional interface is an interface that has exactly one abstract method.
    Since default methods have an implementation, they are not abstract so a functional interface can have any number of them.
    If an interface declares an abstract method with the signature of one of the methods of java.lang.Object, it doesn't count toward the functional interface method count.
    A functional interface is valid when it inherits a method that is equivalent but not identical to another.
    An empty interface is not considered a functional interface.
    A functional interface is valid even if the @FunctionalInterface annotation would be omitted.
    Functional interfaces are the basis of lambda expressions.

