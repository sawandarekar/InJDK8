package jdk8.StreamApi;

import java.util.ArrayList;
import java.util.List;

public class PerformanceComparisonMain {

    public static void main(String[] args) {

        long currentTime = System.currentTimeMillis();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            data.add(i);
        }
        // Stream results
        // Final Sum:117612733
        // Time taken to complete:6 minutes

        // Parallel Stream results
        // Final Sum:117612733
        // Time taken to complete:1 minutes

        long sum = data.stream().parallel()
            .map(i -> (int)Math.sqrt(i))
            .map(PerformanceComparisonMain::performComputation)
            // .map(number -> performComputation(number))
            .reduce(0, Integer::sum);

        System.out.println("Final Sum:" + sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to complete:" + (endTime - currentTime) / (1000 * 60) + " minutes");

    }

    public static int performComputation(int number) {
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            int div = number / i;
            sum += div;

        }
        System.out.println("Sum:" + sum);
        return sum;
    }
}
