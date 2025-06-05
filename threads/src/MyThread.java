import static java.lang.Thread.sleep;

public class MyThread implements Runnable {
    String text;
    int delay;

    public MyThread(String text, int delay) {
        this.text = text;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            if (delay > 0) {
                sleep(delay);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(text);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
