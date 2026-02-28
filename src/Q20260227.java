import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 文字数カウント
public class Q20260227 {
    static final String FILENAME = "question/20260227.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME))) {
            char[] line = sc.nextLine().toCharArray();

            int total = 0;

            for (char c : line) {
                if (Character.isAlphabetic(c))
                    total += 1;
            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }
}
