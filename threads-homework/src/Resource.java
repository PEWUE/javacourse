import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int queueCapacity;

    public Resource(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public synchronized void produce(Integer value) throws InterruptedException {
        while (queue.size() == queueCapacity) {
            wait();
        }
        queue.add(value);
        System.out.println("Dodano do kolejki : " + value + " | Ilość elementów w kolejce: " + queue.size());
        notifyAll();
    }

    public synchronized Integer consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        System.out.println("Pobrano z kolejki : " + value + " | Ilość elementów w kolejce: " + queue.size());
        notifyAll();
        return value;
    }
}
