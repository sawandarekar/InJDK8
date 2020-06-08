package jdk8.StreamApi;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelStreamThreadCPUCount {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool PoolSize: " + ForkJoinPool.commonPool().getPoolSize());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        final long start = System.currentTimeMillis();
        IntStream s = IntStream.range(0, 1_00_000);
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.parallel().forEach(i -> {
            try { Thread.sleep(10); } catch (Exception ignore) {}
//            System.out.println(i+":"+Thread.currentThread().getName()+" "+ (System.currentTimeMillis() - start) + " ");
        });
        System.out.println("parallelStream time taken:"+(System.currentTimeMillis() - start)+" milli");
        ExecutorService ex = Executors.newFixedThreadPool(20);
        s = IntStream.range(0, 1_00_000);
        final long startE = System.currentTimeMillis();
        s.forEach(i->{
            Runnable t = ()->{
                try { Thread.sleep(10); } catch (Exception ignore) {}
                //System.out.println(i+":"+Thread.currentThread().getName()+" "+ (System.currentTimeMillis() - startE) + " ");
            };
            ex.submit(t);
        });
        ex.shutdown();
        ex.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("ExecutorService 20 threads time taken:"+(System.currentTimeMillis() - startE)+" milli");
    }
}
