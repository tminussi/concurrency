package exercises.two;

public class Processor extends Thread {

    public boolean running = true;

    @Override
    public void run() {
        while(running) {
            System.out.println("Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        System.out.println("Shutting down");
        this.running = false;
    }
}
