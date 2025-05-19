public class Main {
    public static void main(String[] args) {
        int[] numbers = {15, 35, 35, 60, 100};

        double average = calculateAverage(numbers);
        System.out.println(average);

    }

    private static double calculateAverage(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }
}