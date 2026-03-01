import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// ＊＊問題2：反転配列の表示(改良版)
public class Q20260301_2_new {

    static final String FILENAME_Q2 = "question/20260301_Q2.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME_Q2))) {

            int N = Integer.parseInt(sc.nextLine());
            List<Integer> list = stringToNumberList(sc.nextLine(), N);

            // 入力順の逆順 → reverse
            Collections.reverse(list);

            // 出力整形
            String result = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    private static List<Integer> stringToNumberList(String line, int N) {
        if (line.isBlank()) {
            return List.of();
        }

        return Arrays.stream(line.split(" "))
                .limit(N)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}