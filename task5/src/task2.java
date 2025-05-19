public class task2 {
    public static void main(String[] args) {
        Point topLeft = new Point(1,5);
        Point bottomRight = new Point(4,2);

        Rectangle rectangle = new Rectangle(topLeft,bottomRight);

        System.out.println("Pole: " + rectangle.countField());
        System.out.println("Przekątna : " + rectangle.countDiagonal());
    }
}
