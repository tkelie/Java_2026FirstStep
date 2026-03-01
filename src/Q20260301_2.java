import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// ＊＊問題2：反転配列の表示
public class Q20260301_2 {

    static final String FILENAME_Q2 = "question/20260301_Q2.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME_Q2))) {

            int N2 = Integer.parseInt(sc.nextLine()); // 要素数

            List<Integer> list2 = stringToNumberList(sc.nextLine(), N2).stream()
                    .sorted(Comparator.reverseOrder())  //＊＊間違い＊＊：入力の逆順ではなく降順ソートになっている
                    .toList();

            // 1行の出力に整形
            String line2 = "";
            for (int i = 1; i < N2; i++) {
                line2 = line2 + list2.get(i - 1) + " ";
            }
            System.out.println(line2 + list2.get(N2 - 1));

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // 整数の羅列をListに変換
    private static List<Integer> stringToNumberList(String line, int N) {
        if (line.isBlank()) {
            return Collections.emptyList();
        }

        // Stream による分割
        return Arrays.stream(line.split(" "))
                .limit(N)
                .map(Integer::parseInt)
                .toList();
    }
}