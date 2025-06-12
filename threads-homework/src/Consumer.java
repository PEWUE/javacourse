import java.util.Random;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private final Resource queue;

    private final Random random = new Random();

    public Consumer(Resource queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Integer value = queue.consume();
            System.out.println("Konsument " + Thread.currentThread().getName() + " skonsumował: " + value);
            sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
