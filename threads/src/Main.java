public class Main {
    public static void main(String[] args) {
        Thread threadPing = new Thread(new MyThread("ping", 0));
        Thread threadPong = new Thread(new MyThread("pong", 500));
        threadPing.start();
        threadPong.start();
    }
}