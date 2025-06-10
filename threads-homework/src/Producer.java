import java.util.Random;

public class Producer implements Runnable {
    private final Resource queue;
    private final int totalItems;
    private final Random random = new Random();

    public Producer(Resource queue, int totalItems) {
        this.queue = queue;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalItems; i++) {
            try {
//                Thread.sleep(random.nextInt(2000));
                queue.produce(i);
                System.out.println("Producent wyprodukował: " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
