import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int queueCapacity;
    private final Lock lock = new ReentrantLock();
    private final Condition queueIsFull = lock.newCondition();
    private final Condition queueIsEmpty = lock.newCondition();

    public Resource(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public void produce(Integer value) throws InterruptedException {
        lock.lock();
        while (queue.size() >= queueCapacity) {
            queueIsFull.await();
        }
        queue.add(value);
        System.out.println("Dodano do kolejki : " + value + " | Ilość elementów w kolejce: " + queue.size());
        queueIsEmpty.signalAll();
        lock.unlock();
    }

    public Integer consume() throws InterruptedException {
        lock.lock();
        while (queue.isEmpty()) {
            queueIsEmpty.await();
        }
        int value = queue.poll();
        System.out.println("Pobrano z kolejki : " + value + " | Ilość elementów w kolejce: " + queue.size());
        queueIsFull.signalAll();
        lock.unlock();
        return value;
    }
}
