
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q20260227_new {

    static final String FILENAME = "question/20260227.txt";

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME))) {

            // 入力ファイルが空の場合に対応
            if (!sc.hasNextLine()) {
                System.out.println(0);
                return;
            }

            String line = sc.nextLine();
            System.out.println(countEnglishLetters(line)); // ロジック部分をメソッド化

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // 英字（A〜Z, a〜z）のみカウント
    public static int countEnglishLetters(String s) {
        int total = 0;
        for (char c : s.toCharArray()) {
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
                // if (Character.isLetter(c) && c < 128) でもOK
                // isAlphabeticはギリシャ文字・キリル文字なども数えてしまう
                total++;
            }
        }
        return total;
    }
}
