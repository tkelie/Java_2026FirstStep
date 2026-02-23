import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q20260223 {
    // ファイル名
    static String FILENAME = "question\\20260223.txt";

    // Log
    record Log(LocalDate date, LocalTime time, Ope ope, String name) {
    }

    // Operation
    enum Ope {
        LOGIN, LOGOUT;

        static Ope operation(String operation) {
            return switch (operation) {
                case "LOGIN" -> LOGIN;
                case "LOGOUT" -> LOGOUT;
                default -> throw new IllegalArgumentException("unknown operation: " + operation);
            };
        }
    }

    // Session
    record Session(String name, int duration) {
    }

    // 日付と時刻をくっつけるメソッド
    private static LocalDateTime mergeDateAndTime(Log log) {
        return LocalDateTime.of(log.date(), log.time());
    }

    public static void main(String[] args) {
        File file = new File(FILENAME);

        try (var sc = new Scanner(file)) { // ファイルを開く

            List<Log> list = new ArrayList<>();

            while (sc.hasNext()) {
                list.add(new Log( // 1行ずつLogとして抽出
                        LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalTime.parse(sc.next(), DateTimeFormatter.ofPattern("HH:mm")),
                        Ope.operation(sc.next()),
                        sc.next()));
            }

            // 【問1】ユーザーごとのログイン回数を数え、昇順で出力
            list.stream()
                    .filter(log -> log.ope() == Ope.LOGIN) // ログインでフィルタ
                    .collect(Collectors.groupingBy(Log::name, Collectors.counting()))
                    .entrySet().stream()
                    .map(e -> e.getKey() + " " + e.getValue())
                    .sorted() // 昇順でソート
                    .forEach(System.out::println);

            var sortedList = list.stream()
                    .sorted(Comparator.comparing(Log::name) // 名前順ソート
                            .thenComparing(Log::date) // 日付順ソート
                            .thenComparing(Log::time)) // 時刻順ソート
                    .toList();

            // Session(名前とセッション時間)をListに格納
            List<Session> sessions = new ArrayList<>();

            for (int i = 1; i < sortedList.size(); i++) {
                Log presentLog = sortedList.get(i);
                LocalDateTime presentTime = mergeDateAndTime(presentLog);

                Log previousLog = sortedList.get(i - 1);
                LocalDateTime previousTime = mergeDateAndTime(previousLog);

                if (presentLog.ope() == Ope.LOGOUT) { // 対象レコードがログアウトの時
                    if (previousLog.ope() == Ope.LOGIN // 直前がログインなら
                            && presentLog.name().equals(previousLog.name())) { // かつ名前が同じなら
                        sessions.add(new Session(presentLog.name(),
                                Math.toIntExact(Duration.between(previousTime, presentTime).toMinutes())));
                    }
                }
            }
            System.out.println(); // 改行

            // 【問2】最もログイン時間が長かったユーザーを出力

            // 名前ごとにセッション時間を合計
            Map<String, Integer> sumOfSessions = sessions.stream()
                    .collect(Collectors.groupingBy( // 名前でグルーピング、時間を合計
                            Session::name, Collectors.summingInt(Session::duration)));

            // 最大値とそのときのキーを初期化
            String maxKey = null;
            Integer maxValue = 0;

            // entrySetメソッドでマップのキーとValueを一つずつ取得
            for (Map.Entry<String, Integer> entry : sumOfSessions.entrySet()) {

                // 最大値とValueを比較してValueが大きければ、そのときのキーとValueを代入
                if (entry.getValue() > maxValue) {
                    maxKey = entry.getKey();
                    maxValue = entry.getValue();
                }
            }

            System.out.println(maxKey + " " + maxValue);

            System.out.println(); // 改行

            // 【問3】その日の平均セッション時間
            System.out.println("average " +
                    sessions.stream()
                            .collect(Collectors.summingInt(Session::duration))
                            / sessions.stream().count());

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
