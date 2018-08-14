package jdk8.LambdaExpressions;

public class LambdaExpression {

    public static void main(String[] args) {
        System.out.println("All Arguments");
        for (String arg : args) {
            System.out.println(arg);
        }
        // final String c = () -> singleLineLammbda();
        // The target type of this expression must be a functional interface

        singleLineLammbda();
        multiLineLammbda();
        multiParameterLambda();

    }

    public static void singleLineLammbda() {
        System.out.println("singleLineLammbda");
        final LambdaFucntionInterface l = () -> System.out.println("In Single Line Lambda!!");

        l.data();
    }

    public static void multiLineLammbda() {
        System.out.println("multiLineLammbda");
        final LambdaFucntionInterface l = () -> {
            System.out.println("Multi Line Lambda!!");
            final int x = 10;
            System.out.println("X:" + x);
        };

        l.data();
    }

    private static void multiParameterLambda() {
        System.out.println("multiLineLammbda");
        final MultiParameterInterface m = (String a, String b) -> {
            System.out.println(a + ", " + b);
        };
        m.data("firstName", "LastName");

    }
}

@FunctionalInterface
interface LambdaFucntionInterface {

    void data();
}

@FunctionalInterface
interface MultiParameterInterface {

    void data(String s, String d);

}
