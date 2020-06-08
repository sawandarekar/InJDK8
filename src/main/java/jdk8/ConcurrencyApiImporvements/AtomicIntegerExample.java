package jdk8.ConcurrencyApiImporvements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicIntegerExample {

    public static void main(String[] args) {
        AtomicInteger automicInt = new AtomicInteger();
        AtomicLong automicLong = new AtomicLong();
        for (int i = 0; i < 1000; i++) {
            Thread t = new AutomicIntegerUpdater(automicInt, automicLong);
            t.start();
        }
    }
}

class AutomicIntegerUpdater extends Thread {

    private final AtomicInteger automicInteger;
    private final AtomicLong automicLong;
    public AutomicIntegerUpdater(AtomicInteger a, AtomicLong automicLong) {
        this.automicInteger = a;
        this.automicLong = automicLong;
    }

    @Override
    public void run() {
        int intVal = this.automicInteger.addAndGet(2);
        long longVal = this.automicLong.addAndGet(3);
        System.out.println(AutomicIntegerUpdater.currentThread().getName() +": Intval:"+intVal+" longVal:"+longVal);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
