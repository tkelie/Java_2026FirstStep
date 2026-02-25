import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q20260224 {
    static final String FILENAME = "question\\20260224.txt";

    // 状態
    enum State {
        IN, OUT;

        static State from(String s) {
            return switch (s) {
                case "IN" -> IN;
                case "OUT" -> OUT;
                default -> throw new IllegalArgumentException("unknown state: " + s);
            };
        }
    }

    // Logレコード
    record Log(String name, State state) {
    }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        Map<String, State> map = new HashMap<>(); // 名前をkey、最後の状態をvalueとするMap

        for (var value : logs) {
            map.put(value.name(), value.state());
        }

        int number = map.entrySet().stream()
                .filter(l -> l.getValue() == State.IN) // 最後の状態がINの人をフィルタリング
                .toList()
                .size();

        System.out.println(number);
    }

    // ログ読み込み
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                list.add(new Log(
                        sc.next(),
                        State.from(sc.next())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return list;
    }
}
