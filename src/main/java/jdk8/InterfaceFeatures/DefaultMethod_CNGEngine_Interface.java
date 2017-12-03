package jdk8.InterfaceFeatures;

public interface DefaultMethod_CNGEngine_Interface extends Engine {

    public default void engineType() {
        System.out.println("CNG engine");
    }
}
