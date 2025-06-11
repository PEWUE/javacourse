import java.util.Random;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private final Resource queue;
    private final int itemsToConsume;
    private final int consumerId;

    private final Random random = new Random();

    public Consumer(Resource queue, int itemsToConsume, int consumerId) {
        this.queue = queue;
        this.itemsToConsume = itemsToConsume;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        for (int i = 0; i < itemsToConsume; i++) {
            try {
                Integer value = queue.consume();
                System.out.println("Konsument " + consumerId + " skonsumował: " + value);
                sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
