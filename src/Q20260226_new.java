import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 連続ログイン最長時間(改良版)
public class Q20260226_new {
    static final String FILENAME = "question/20260226.txt";
    static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm");

    // Log レコード
    record Log(LocalTime time, Ope ope, String name) {}

    // 操作
    enum Ope {
        LOGIN, LOGOUT;

        static Ope from(String s) {
            return switch (s) {
                case "LOGIN" -> LOGIN;
                case "LOGOUT" -> LOGOUT;
                default -> throw new IllegalArgumentException("unknown operation: " + s);
            };
        }
    }

    // セッション
    record Session(String name, long durationMinutes) {}

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        // 入力ログが空の場合の処理
        if (logs.isEmpty()) {
            System.out.println("0");
            return;
        }

        // name → time の複合キーでソート（ログ順がバラバラでもOK）
        var sortedLogs = logs.stream()
                .sorted(Comparator.comparing(Log::name)
                        .thenComparing(Log::time))
                .toList();

        // セッション抽出（Mapで最後のLOGIN保持）
        List<Session> sessions = extractSessions(sortedLogs);

        // セッションが1つも無いなら終了
        if (sessions.isEmpty()) {
            System.out.println("0");
            return;
        }

        // 最大セッション時間を取得
        long max = sessions.stream()
                .mapToLong(Session::durationMinutes)
                .max()
                .orElse(0);

        // 最大時間の人を名前昇順で出力
        sessions.stream()
                .filter(s -> s.durationMinutes == max)
                .sorted(Comparator.comparing(Session::name))
                .forEach(s -> System.out.println(s.name() + " " + s.durationMinutes()));
    }

    // ログ読み込み
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                list.add(new Log(
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

    // LOGIN → LOGOUT のペアからセッション抽出（Mapを使って簡潔に）
    private static List<Session> extractSessions(List<Log> logs) {
        Map<String, LocalTime> loginMap = new HashMap<>();
        List<Session> result = new ArrayList<>();

        for (var log : logs) {
            switch (log.ope) {
                case LOGIN -> loginMap.put(log.name, log.time);
                case LOGOUT -> {
                    LocalTime loginTime = loginMap.remove(log.name);
                    if (loginTime != null) {
                        long min = Duration.between(loginTime, log.time).toMinutes();
                        if (min < 0) min += 24 * 60; // 日付跨ぎ対応
                        result.add(new Session(log.name, min));
                    }
                }
            }
        }

        return result;
    }
}