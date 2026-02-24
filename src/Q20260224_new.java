import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Q20260224_new {
    static final String FILENAME = "question/20260224.txt";

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

    record Log(String name, State state) {
    }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        Map<String, State> map = new HashMap<>();
        for (var log : logs) {
            map.put(log.name(), log.state());
        }

        // 改善
        int number = (int) map.values().stream() // キーは使っていないからvalues()のほうがわかりやすい
                .filter(state -> state == State.IN)
                .count(); // List.size()より自然 (longを返すからintでいいならキャスト)

        System.out.println(number);
    }

    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String name = sc.next();
                if (!sc.hasNext())
                    break; // 不正行対策
                State state = State.from(sc.next());
                list.add(new Log(name, state));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return list;
    }
}