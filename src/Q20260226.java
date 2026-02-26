import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 連続ログイン最長時間
public class Q20260226 {
    static final String FILENAME = "question/20260226.txt";
    static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm");

    // Log レコード
    record Log(LocalTime time, Ope ope, String name) {
    }

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

    // セッション（1回の滞在時間）
    record Session(String name, long durationMinutes) {
    }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        var sortedLogs = logs.stream()
                .sorted(Comparator.comparing(Log::name))
                .toList();

        // セッション抽出
        List<Session> sessions = extractSessions(sortedLogs);

        // セッションをソート
        var sortedSessions = sessions.stream()
                .sorted(Comparator.comparing(Session::durationMinutes)
                        .reversed()) // セッション時間降順
                .toList();

        // セッション時間の最大値
        long maxDuration = sortedSessions.get(0).durationMinutes();

        // セッション時間が最大値の人のリストを出力
        sortedSessions.stream()
                .filter(s -> s.durationMinutes() == maxDuration)
                .sorted(Comparator.comparing(Session::name))// 名前昇順
                .forEach(e -> System.out.println(e.name() + " " + e.durationMinutes()));
    }

    // ログ読み込み
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                list.add(new Log(
                        LocalTime.parse(sc.next(), TIME),
                        Ope.from(sc.next()),
                        sc.next()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return list;
    }

    // LOGIN → LOGOUT のペアからセッション抽出
    private static List<Session> extractSessions(List<Log> sortedLogs) {
        List<Session> list = new ArrayList<>();

        for (int i = 1; i < sortedLogs.size(); i++) {
            var prev = sortedLogs.get(i - 1);
            var curr = sortedLogs.get(i);

            if (prev.name().equals(curr.name()) &&
                    prev.ope() == Ope.LOGIN &&
                    curr.ope() == Ope.LOGOUT) {

                long minutes = Duration.between(prev.time(), curr.time()).toMinutes();
                if (minutes < 0)
                    minutes += (24 * 60);

                list.add(new Session(prev.name(), minutes));
            }
        }

        return list;
    }
}
