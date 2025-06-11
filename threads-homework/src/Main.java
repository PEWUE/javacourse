import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int MAX_QUEUE_SIZE = 5;
        final int TOTAL_ITEMS = 26;
        final int NUM_CONSUMERS = 5;
        final int NUM_PRODUCERS = 2;
        final int ITEMS_PER_CONSUMER = TOTAL_ITEMS / NUM_CONSUMERS;
        final int ITEMS_PER_PRODUCER = TOTAL_ITEMS / NUM_PRODUCERS;
        final int ITEMS_LAST_CONSUMER = ITEMS_PER_CONSUMER + TOTAL_ITEMS % NUM_CONSUMERS;
        final int ITEMS_LAST_PRODUCER = ITEMS_PER_PRODUCER + TOTAL_ITEMS % NUM_PRODUCERS;

        Resource queue = new Resource(MAX_QUEUE_SIZE);

        try (ExecutorService prodExecutorService = Executors.newFixedThreadPool(NUM_PRODUCERS);
             ExecutorService consExecutorService = Executors.newFixedThreadPool(NUM_CONSUMERS)) {

            Thread[] prodThreads = new Thread[NUM_PRODUCERS];
            for (int i = 0; i < NUM_PRODUCERS - 1; i++) {
                Producer producer = new Producer(queue, ITEMS_PER_PRODUCER, i + 1);
                prodExecutorService.submit(producer);
            }
            Producer producer = new Producer(queue, ITEMS_LAST_PRODUCER, prodThreads.length);
            consExecutorService.submit(producer);

            Thread[] consThreads = new Thread[NUM_CONSUMERS];
            for (int i = 0; i < NUM_CONSUMERS - 1; i++) {
                Consumer consumer = new Consumer(queue, ITEMS_PER_CONSUMER, i + 1);
                consExecutorService.submit(consumer);
            }
            Consumer consumer = new Consumer(queue, ITEMS_LAST_CONSUMER, consThreads.length);
            consExecutorService.submit(consumer);
        }

        System.out.println("Koniec");
    }
}