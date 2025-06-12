import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int MAX_QUEUE_SIZE = 5;
        final int TOTAL_ITEMS = 26;
        final int NUM_CONSUMERS = 5;
        final int NUM_PRODUCERS = 2;

        Resource queue = new Resource(MAX_QUEUE_SIZE);

        try (ExecutorService prodExecutorService = Executors.newFixedThreadPool(NUM_PRODUCERS);
             ExecutorService consExecutorService = Executors.newFixedThreadPool(NUM_CONSUMERS)) {

            for (int i = 0; i < TOTAL_ITEMS; i++) {
                Producer producer = new Producer(queue);
                Consumer consumer = new Consumer(queue);
                prodExecutorService.submit(producer);
                consExecutorService.submit(consumer);
            }
        }
        System.out.println("Koniec");
    }
}