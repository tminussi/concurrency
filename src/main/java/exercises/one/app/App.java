package exercises.one.app;

import exercises.one.threads.ExtendsThread;
import exercises.one.threads.ImplementsRunnable;

public class App {

    public static void main(String[] args) {
        ExtendsThread threadOne = new ExtendsThread();
        threadOne.start();

        ExtendsThread threadTwo = new ExtendsThread();
        threadTwo.start();

        Thread t1 = new Thread(new ImplementsRunnable());
        Thread t2 = new Thread(new ImplementsRunnable());

        t1.start();
        t2.start();
    }
}
