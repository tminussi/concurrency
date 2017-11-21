package exercises.seven;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AppSeven {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread consumer = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread producer = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.start();
        producer.start();

        System.out.println("Producer and Consumer have already started but will never finish. I am running anyways, so it means I am asyncrhonous");
    }

    private static void producer() throws InterruptedException {
        while(true) {
            queue.put(new Random(100).nextInt());
            System.out.println("Inserting new Element...Queue size is : " + queue.size());
        }
    }

    private static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            System.out.println(queue.take());
            System.out.println("Removing element...Queue size is : " + queue.size());
            System.out.println(queue);
        }
    }
}
