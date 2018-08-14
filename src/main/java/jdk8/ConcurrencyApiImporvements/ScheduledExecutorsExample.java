package jdk8.ConcurrencyApiImporvements;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * A ScheduledExecutorService is capable of scheduling tasks to run either
 * periodically or once after a certain amount of time has elapsed.
 * 
 * @author darekar
 *
 */
public class ScheduledExecutorsExample {
    public static void main(String[] args) throws InterruptedException {

	scheduledtTask();
	scheduleAtFixedRate();
	scheduleWithFixedDelay();

    }

    /**
     * 
     */
    private static void scheduleWithFixedDelay() {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> {
	    try {
		TimeUnit.SECONDS.sleep(2);
		System.out.println(Thread.currentThread().getName() + ": Scheduling: " + System.nanoTime());
	    } catch (InterruptedException e) {
		System.err.println("task interrupted");
	    }
	};

	executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * In order to schedule tasks to be executed periodically, executors provide the
     * two methods scheduleAtFixedRate() and scheduleWithFixedDelay()
     */
    private static void scheduleAtFixedRate() {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> System.out
		.println(Thread.currentThread().getName() + ": Scheduling: " + System.nanoTime());

	int initialDelay = 0;
	int period = 1;
	executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * This code sample schedules a task to run after an initial delay of three
     * seconds has passed:
     * 
     * @throws InterruptedException
     */
    private static void scheduledtTask() throws InterruptedException {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable task = () -> System.out
		.println(Thread.currentThread().getName() + ": Scheduling: " + System.nanoTime());
	ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

	TimeUnit.MILLISECONDS.sleep(1337);

	long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
	System.out.printf("Remaining Delay: %sms\n", remainingDelay);
    }


}
