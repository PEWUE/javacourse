public class Main {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("Nie można dzielić przez 0");
            }
            return a / b;
        };

        try {
            testMathOperation(19, 6, add);
            testMathOperation(6, 10, subtract);
            testMathOperation(5, 4, multiply);
            testMathOperation(111, 37, divide);
            testMathOperation(6, 0, divide);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void testMathOperation(int x, int y, MathOperation operation) {
        int result = operation.calculate(x, y);
        System.out.println("Wynik działania: " + result);
    }
}
