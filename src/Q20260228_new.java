import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 奇数のみの合計（Stream API）(改良版)
public class Q20260228_new {

    static final String FILENAME = "question/20260228.txt";

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME))) {

            int N = Integer.parseInt(sc.nextLine());

            List<Integer> numbers = stringToNumberList(sc.nextLine(), N);

            int total = numbers.stream()
                    .filter(i -> i % 2 != 0)
                    .mapToInt(Integer::intValue)
                    .sum();

            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    private static List<Integer> stringToNumberList(String line, int N) {
        // 空行の場合「空リストを返す」→「明確にエラー扱い」してもいい
        if (line.isBlank()) {
            return Collections.emptyList();
        }

        // Stream による分割
        return Arrays.stream(line.split(" "))
                .limit(N)
                .map(Integer::parseInt)
                .toList(); // Java 16+
        // .collect(Collectors.toList()); // Java 8

        // else にあった new ArrayList<Integer>().add(0) はすぐ捨てられるので全く意味がないし、
        // list は空のまま返るので動作と整合していない。不要なら削除でOK。

        // ＊＊Nと実際の個数が違う場合のチェック(信頼性を上げるなら)＊＊
        // if (stringArray.length < N) {
        // throw new IllegalArgumentException("Number count is less than N.");
        // }
    }
}