import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

// ＊＊問題3：Fibonacci チェッカー(改良版)
public class Q20260301_3_new {

    static final String FILENAME_Q3 = "question/20260301_Q3.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME_Q3))) {

            int target = Integer.parseInt(sc.nextLine());

            // Optional の map / orElse を使うとよりモダンな書き方になる
            String result = isFibonacci(target)
                    .map(b -> b ? "YES" : "NO") // true → YES, false → NO
                    .orElse("NO"); // Optional.empty() → NO

            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    private static Optional<Boolean> isFibonacci(int n) {
        if (n < 0)
            return Optional.empty();

        boolean isFib = isSquare(5 * n * n + 4) || isSquare(5 * n * n - 4);
        return Optional.of(isFib);
    }

    private static boolean isSquare(int x) {
        if (x < 0)
            return false;
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}