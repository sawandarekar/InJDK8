package jdk8.InterfaceFeatures;

public class MarutiCar implements DefaultMethod_CNGEngine_Interface, DefaultMethod_PetrolEngine_Interface {

    @Override
    public void start() {
        System.out.println("Start engine");
    }

    /**
     * default engine type method defined in both interfaces. so that why complier
     * asked to override it. default method is in single then it dont ask to
     * override
     */
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
