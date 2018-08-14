package jdk8.ConcurrencyApiImporvements;

/**
 * java supports Threds since 1.0<br/>
 * 
 * The Concurrency API was first introduced with the release of Java 5 and then
 * progressively enhanced with every new Java release
 * 
 * @author darekar
 *
 */
public class ConcurrecyDemo {
    public static void main(String[] args) {

	normalThreadExample();
    }

    private static void normalThreadExample() {
	Runnable task = () -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Running Thread:" + threadName);
	};

	task.run(); // This does not start new thread

	Thread thread = new Thread(task);
	thread.start(); // This call start new thread

	System.out.println("Done!");
    }
}
