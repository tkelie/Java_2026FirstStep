import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// ＊＊問題5：日付データ集計
public class Q20260301_5 {

    static final String FILENAME_Q5 = "question/20260301_Q5.txt";
    static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME_Q5))) {

            int N5 = Integer.parseInt(sc.nextLine()); // 要素数

            List<LocalDate> list = readLogs(sc);
            if (list.size() < N5) {
                throw new IllegalArgumentException("格納された要素の数が指定より少ないです。");
            }

            // もっとも過去の日付
            LocalDate minDate = list.stream().limit(N5).min(Comparator.naturalOrder()).orElse(LocalDate.now());

            // もっとも新しい日付
            LocalDate maxDate = list.stream().limit(N5).max(Comparator.naturalOrder()).orElse(LocalDate.now());

            System.out.println(ChronoUnit.DAYS.between(minDate, maxDate));

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    // List格納
    private static List<LocalDate> readLogs(Scanner sc) {
        List<LocalDate> list = new ArrayList<>();

        while (sc.hasNext()) {
            list.add(LocalDate.parse(sc.next(), DATE));
        }

        return list;
    }

}