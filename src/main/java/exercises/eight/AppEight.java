package exercises.eight;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppEight {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> submit = executor.submit(() -> new Random().nextInt());

        executor.shutdown();
        System.out.println(submit.get());
    }
}
