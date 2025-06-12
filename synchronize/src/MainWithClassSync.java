import java.util.Arrays;

public class MainWithClassSync {
    public static void main(String[] args) throws InterruptedException {
        int size = 1_000_000_000;
        int[] array = new int[size];
        Arrays.fill(array, 1);

        int[] threadCounts = {1, 2, 4, 8, 16};

        for (int threadCount : threadCounts) {
            System.out.println("Liczba wątków: " + threadCount);

            SumTaskWithSync.resetTotalSum();

            long startTime = System.currentTimeMillis();

            calculateSumWithClassSync(array, threadCount);

            long endTime = System.currentTimeMillis();

            System.out.println("Suma: " + SumTaskWithSync.getTotalSum());
            System.out.println("Czas wykonania: " + (endTime - startTime) + " ms");
            System.out.println();
        }
    }

    public static void calculateSumWithClassSync(int[] array, int threadCount) throws InterruptedException {
        int size = array.length;
        Thread[] threads = new Thread[threadCount];

        int segmentSize = size / threadCount;

        for (int i = 0; i < threadCount; i++) {
            int start = i * segmentSize;
            int end = (i == threadCount - 1) ? size : start + segmentSize;

            threads[i] = new Thread(new SumTaskWithSync(array, start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}