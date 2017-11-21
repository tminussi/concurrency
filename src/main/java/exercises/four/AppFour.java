package exercises.four;

public class AppFour {

    public static void main(String[] args) {
        Worker worker = new Worker();
        long before = System.currentTimeMillis();

        worker.execute();
        long after = System.currentTimeMillis();

        System.out.println("Time taken: " + (after - before));

    }
}
