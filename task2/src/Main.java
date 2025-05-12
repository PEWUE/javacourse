import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj x:");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("Podaj y:");
        int y = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[x][y];
        System.out.println(matrix.length);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0 || i == x - 1 || j == y - 1) {
                    matrix[i][j] = "*";
                } else {
                    matrix[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}