import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 奇数のみの合計（Stream API）
public class Q20260228 {

    static final String FILENAME = "question/20260228.txt";

    public static void main(String[] args) {

        try (var sc = new Scanner(new File(FILENAME))) {

            int N = Integer.parseInt(sc.nextLine());

            int total = stringToNumberList(sc.nextLine(), N)
                    .stream()
                    .filter(i -> i % 2 != 0) // 奇数判定
                    .mapToInt(i -> i)
                    .sum();

            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // 2行目を数字のListに整形する
    private static List<Integer> stringToNumberList(String line, int N) {
        List<Integer> list = new ArrayList<Integer>();

        if (!line.isEmpty()) {
            String[] stringArray = line.split(" ");

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(stringArray[i]));
            }
            return list;
        } else {
            new ArrayList<Integer>().add(0);
            return list;
        }
    }
}