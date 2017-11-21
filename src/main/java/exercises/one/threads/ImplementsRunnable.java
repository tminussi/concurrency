package exercises.one.threads;

public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("Executing thread from... " + this.getClass().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
