import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// ログ解析・セッション時間・平均計算(改良版)
public class Q20260223_new {

    static final String FILENAME = "question/20260223.txt";
    static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm");

    // Log レコード
    record Log(LocalDate date, LocalTime time, Ope ope, String name) {
        LocalDateTime dateTime() {
            return LocalDateTime.of(date, time);
        }
    }

    // 操作
    enum Ope {
        LOGIN, LOGOUT;

        static Ope from(String s) {
            return switch (s) {
                case "LOGIN" -> LOGIN;
                case "LOGOUT" -> LOGOUT;
                default -> throw new IllegalArgumentException("unknown ope: " + s);
            };
        }
    }

    // セッション（1回の滞在時間）
    record Session(String name, long durationMinutes) { }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        // ---------------------------
        // 【問1】ユーザーごとの LOGIN 回数
        // ---------------------------

        logs.stream()
            .filter(l -> l.ope() == Ope.LOGIN)
            .collect(Collectors.groupingBy(Log::name, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println();

        // ---------------------------
        // ログの整列（名前 → 日付 → 時刻 → 操作）
        // ---------------------------

        var sortedLogs = logs.stream()
                .sorted(Comparator.comparing(Log::name)
                        .thenComparing(Log::date)
                        .thenComparing(Log::time)
                        .thenComparing(l -> l.ope() == Ope.LOGIN ? 0 : 1)) // LOGIN→LOGOUT の順番に
                .toList();

        // ---------------------------
        // セッション抽出
        // ---------------------------

        List<Session> sessions = extractSessions(sortedLogs);

        // ---------------------------
        // 【問2】総滞在時間が最大のユーザー
        // ---------------------------

        var longest = sessions.stream()
                .collect(Collectors.groupingBy(Session::name,
                        Collectors.summingLong(Session::durationMinutes)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(longest.getKey() + " " + longest.getValue());

        System.out.println();

        // ---------------------------
        // 【問3】平均セッション時間
        // ---------------------------

        var stats = sessions.stream()
                .collect(Collectors.summarizingLong(Session::durationMinutes));

        System.out.println("average " + (int) stats.getAverage()); // 小数切り捨て
    }


    // ================================
    // ログ読み込み
    // ================================
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                list.add(new Log(
                        LocalDate.parse(sc.next(), DATE),
                        LocalTime.parse(sc.next(), TIME),
                        Ope.from(sc.next()),
                        sc.next()
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return list;
    }

    // ================================
    // LOGIN → LOGOUT のペアからセッション抽出
    // ================================
    private static List<Session> extractSessions(List<Log> sorted) {
        List<Session> list = new ArrayList<>();

        for (int i = 1; i < sorted.size(); i++) {
            var prev = sorted.get(i - 1);
            var curr = sorted.get(i);

            if (prev.name().equals(curr.name()) &&
                prev.ope() == Ope.LOGIN &&
                curr.ope() == Ope.LOGOUT) {

                long minutes = Duration.between(prev.dateTime(), curr.dateTime()).toMinutes();
                list.add(new Session(prev.name(), minutes));
            }
        }
        return list;
    }
}
