package exercises.six;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppSix {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Processor(latch));
        }

        latch.await();

        System.out.println("Completed");
    }
}
