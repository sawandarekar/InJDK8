package jdk8.ConcurrencyApiImporvements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyWithExecutors {

    public static void main(String[] args) {
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable runnable0 = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello 0:" + threadName);
        };
        executor.submit(runnable0);
        executor.submit(runnable0);
        executor.submit(runnable0);

        Thread t = new Thread(runnable0);
        t.setName("main-thread");
        executor.submit(t);
        executor.submit(t);
        executor.submit(t);


        Runnable runnable1 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello 1:" + threadName);
        };
        Runnable runnable2 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello 2:" + threadName);
        };

        executor.submit(runnable1);
        executor.submit(runnable2);
        executor.submit(runnable1);
        executor.submit(runnable2);

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

    }
}
