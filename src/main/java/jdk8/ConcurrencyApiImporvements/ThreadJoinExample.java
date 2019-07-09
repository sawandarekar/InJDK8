package jdk8.ConcurrencyApiImporvements;

public class ThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        t1.start();
        try {
            t1.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();
        try {
            t1.join(1000);
            t2.join(1000);
            t3.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads are dead, exiting main thread");
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
}
