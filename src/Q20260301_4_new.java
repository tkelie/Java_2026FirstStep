import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q20260301_4_new {

    static final String FILENAME_Q4 = "question/20260301_Q4.txt";

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME_Q4))) {

            // 正順
            String target = sc.nextLine();

            // 逆順
            String desc = listToString(stringToArray(target).reversed());

            // 比較
            System.out.println(desc.equals(target) ? "YES" : "NO");

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    private static List<Character> stringToArray(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    // List<Character> → "level" のような文字列へ
    private static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }
    /*
     * 実行イメージ
     * target = "level"
     * → stringToArray → ['l','e','v','e','l']
     * → reversed() → ['l','e','v','e','l']
     * → listToString → "level"
     * → "level".equals("level") → YES
     */
}