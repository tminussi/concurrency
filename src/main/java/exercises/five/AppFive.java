package exercises.five;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppFive {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Processor(i));
        }
        System.out.println("all tasks have successfully been submitted");
        executor.shutdown();

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all tasks have successfully been completed");
    }
}
