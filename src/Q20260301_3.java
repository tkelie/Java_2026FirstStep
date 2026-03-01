import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

// ＊＊問題3：Fibonacci チェッカー
public class Q20260301_3 {

    static final String FILENAME_Q3 = "question/20260301_Q3.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME_Q3))) {

            int N3 = Integer.parseInt(sc.nextLine()); // 検証対象の数値

            if (isFibonacci(N3).isPresent()) {
                if (isFibonacci(N3).get()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // フィボナッチ数の判定：Optional<boolean>を返す
    private static Optional<Boolean> isFibonacci(int N) {
        if (N < 0)
            return Optional.empty();

        // 5n^2 + 4 か 5n^2 - 4 が平方数ならtrue (再帰より速いはず)
        return Optional.of(isSquare(5 * N * N + 4) || isSquare(5 * N * N - 4));
    }

    // 平方数ならtrue
    private static boolean isSquare(int x) {
        if (x < 0)
            return false;
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}
