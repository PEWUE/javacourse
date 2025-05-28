import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Long> memo = new ArrayList<>();
    public static void main(String[] args) {
        memo.add(0L);
        memo.add(1L);

        System.out.println(fibonacci(111));
    }

    private static long fibonacci(int n) {
        if (n < memo.size()) {
            return memo.get(n);
        }

        long result = fibonacci(n-1) + fibonacci(n-2);
        memo.add(result);

        return result;
    }
}
