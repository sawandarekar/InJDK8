package jdk8.InterfaceFeatures;

public interface DefaultMethod_PetrolEngine_Interface extends Engine {

    public default void engineType() {
        System.out.println("Petrol engine");
    }
}
