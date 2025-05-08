import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end = false;

        while (!end) {
            System.out.println("Wprowadź pierwszą liczbę:");
            double num1 = sc.nextDouble();
            System.out.println("Wprowadź znak operacji (+, -, *, /, %, ^):");
            char operation = sc.next().charAt(0);
            System.out.println("Wprowadź drugą liczbę:");
            double num2 = sc.nextDouble();

            double result = switch (operation) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.err.println("Błędne dane");
                        yield Double.NaN;
                    }
                    yield num1 / num2;
                }
                case '%' -> {
                    if (num1 == 0 || num2 == 0) {
                        System.err.println("Błędne dane");
                        yield Double.NaN;
                    }
                    yield num1 % num2;
                }
                case '^' -> Math.pow(num1, num2);
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            };

            if (!Double.isNaN(result)) {
                System.out.println("Wynik działania " + num1 + " " + operation + " " + num2 + " = " + result);
            }

            System.out.println("Czy chcesz wykonać kolejne działanie? (y/n)");

            char nextOperation = sc.next().charAt(0);

            end = nextOperation == 'n';

            String message = result % 2 == 0 ? "Ostatni wynik jest parzysty" : "Ostatni wynik jest nieparzysty";
            System.out.println(message);


        }

    }
}