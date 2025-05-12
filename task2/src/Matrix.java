public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int number = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = number++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + matrix[i][j] + " ");
            }
            System.out.println("|");

            System.out.println("+---+---+---+");
        }
    }
}
