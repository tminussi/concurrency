package exercises.three;

public class AppThree {

    private int count = 0;

    public static void main(String[] args) {
        AppThree appThree = new AppThree();
        appThree.doWork();
    }

    public synchronized void increment() {
        this.count++;
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i ++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i ++) {
                increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Count should be zero. Count value: " + count);
    }
}
