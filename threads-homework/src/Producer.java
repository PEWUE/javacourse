import java.util.Random;
public class Producer implements Runnable {
    private static int itemsCounter = 0;

    private final Resource queue;
    private final int itemsToProduce;
    private final int producerId;

    private final Random random = new Random();

    public Producer(Resource queue, int itemsToProduce, int producerId) {
        this.queue = queue;
        this.itemsToProduce = itemsToProduce;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        for (int i = 1; i <= itemsToProduce; i++) {
            try {
                Thread.sleep(random.nextInt(2000));
                queue.produce(itemsCounter);
                System.out.println("Producent " + producerId + " wyprodukował: " + itemsCounter);
                itemsCounter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
