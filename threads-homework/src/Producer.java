import java.util.Random;

public class Producer implements Runnable {
    private static int itemsCounter = 0;

    private final Resource queue;

    private final Random random = new Random();

    public Producer(Resource queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(1500));
            queue.produce(itemsCounter);
            System.out.println("Producent " + Thread.currentThread().getName() + " wyprodukował: " + itemsCounter);
            itemsCounter++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
