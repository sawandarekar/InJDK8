package jdk8.InterfaceFeatures;

public class MarutiCar implements DefaultMethod_CNGEngine_Interface, DefaultMethod_PetrolEngine_Interface {

    @Override
    public void start() {
        System.out.println("Start engine");
    }

    @Override
    public void engineType() {
        DefaultMethod_CNGEngine_Interface.super.engineType();
        DefaultMethod_PetrolEngine_Interface.super.engineType();
    }

    public static void main(String[] args) {
        MarutiCar car = new MarutiCar();
        car.start();
        car.engineName();
        car.engineType();
    }
}
