import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// ＊＊問題5：日付データ集計(改良版)
public class Q20260301_5_new {

    static final String FILENAME_Q5 = "question/20260301_Q5.txt";
    static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        try (var sc = new Scanner(new File(FILENAME_Q5))) {

            int N = Integer.parseInt(sc.nextLine());

            List<LocalDate> dates =
                    sc.tokens()
                      .limit(N) //1回で済む
                      .map(s -> LocalDate.parse(s, DATE))
                      .collect(Collectors.toList());

            LocalDate min = dates.stream().min(LocalDate::compareTo).orElseThrow();
            LocalDate max = dates.stream().max(LocalDate::compareTo).orElseThrow();

            System.out.println(ChronoUnit.DAYS.between(min, max));

        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }
}