public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double countField() {
        double width = getWidth();
        double height = getHeight();

        return width * height;
    }

    public double countDiagonal() {
        double width = getWidth();
        double height = getHeight();

        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    private double getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    private double getHeight() {
        return Math.abs(topLeft.getY() - bottomRight.getY());
    }
}
