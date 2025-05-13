public class Main {
    public static void main(String[] args) {
        System.out.print(" ");
        for (int col = 0; col < 8; col++) {
            char letter = (char) ('a' + col);
            System.out.print(" " + letter);
        }
        System.out.println();

        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " ");

            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(" #");
                }
            }

            System.out.println(" " + (8 - row));
        }

        System.out.print(" ");
        for (int col = 0; col < 8; col++) {
            char letter = (char) ('a' + col);
            System.out.print(" " + letter);
        }
        System.out.println();

    }

}