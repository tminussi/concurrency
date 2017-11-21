package exercises.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Worker {

    private List<Integer> integers = new ArrayList<>();
    private List<Integer> integers2 = new ArrayList<>();
    private Random random = new Random();

    private Object MUTEX_ONE = new Object();
    private Object MUTEX_TWO = new Object();

    private void stageOne() {
        synchronized (MUTEX_ONE) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            integers.add(random.nextInt(1000));
        }
    }

    private synchronized void stageTwo() {
        synchronized (MUTEX_TWO) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integers2.add(random.nextInt(1000));
        }
    }


    private void process() {

        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
    public void execute() {
        Thread thread = new Thread(this::process);
        thread.start();
        Thread thread2 = new Thread(this::process);
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}