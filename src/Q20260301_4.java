import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// ＊＊問題4：文字列の回文判定
public class Q20260301_4 {

    static final String FILENAME_Q4 = "question/20260301_Q4.txt";

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME_Q4))) {

            String string = sc.nextLine(); // 検証対象の文字列

            // 正順文字列
            String ascString = stringToArray(string).toString();

            // 逆順文字列
            String descString = stringToArray(string)
                    .reversed().toString();

            // switch式
            System.out.println(descString.equals(ascString) ? "YES" : "NO");

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // 文字列をListにして返す
    // 例：「level」->「[l, e, v, e, l]」に変換
    private static List<Character> stringToArray(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}