public class Main {
    public static void main(String[] args) {
        final int MAX_QUEUE_SIZE = 5;
        final int TOTAL_ITEMS = 61;
        final int NUM_CONSUMERS = 3;
        final int ITEMS_PER_CONSUMER = TOTAL_ITEMS / NUM_CONSUMERS;
        final int ITEMS_LAST_CONSUMER = ITEMS_PER_CONSUMER + TOTAL_ITEMS % NUM_CONSUMERS;

        Resource queue = new Resource(MAX_QUEUE_SIZE);

        Producer producer = new Producer(queue, TOTAL_ITEMS);
        Thread prodThread = new Thread(producer);
        prodThread.start();

        Thread[] consThreads = new Thread[NUM_CONSUMERS];
        for (int i = 0; i < NUM_CONSUMERS - 1; i++) {
            Consumer consumer = new Consumer(queue, ITEMS_PER_CONSUMER, i + 1);
            consThreads[i] = new Thread(consumer);
            consThreads[i].start();
        }
        Consumer consumer = new Consumer(queue, ITEMS_LAST_CONSUMER, consThreads.length);
        consThreads[consThreads.length - 1] = new Thread(consumer);
        consThreads[consThreads.length - 1].start();

        try {
            prodThread.join();
            for (Thread consThread : consThreads) {
                consThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Koniec");
    }
}