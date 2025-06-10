class SumTaskWithSync implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private static long totalSum = 0;
    private static final Object lock = new Object();

    public SumTaskWithSync(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }

        synchronized (lock) {
            totalSum += partialSum;
        }
    }

    public static long getTotalSum() {
        return totalSum;
    }

    public static void resetTotalSum() {
        totalSum = 0;
    }
}