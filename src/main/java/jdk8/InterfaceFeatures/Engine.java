package jdk8.InterfaceFeatures;

public interface Engine {

    public void start();

    public default void engineName() {
        System.out.println("Parent engine");
    }

    public default void engineNameData() {
	System.out.println("Parent engine");
    }
}
