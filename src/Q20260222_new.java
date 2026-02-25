import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

// ログのフィルタと重複ユーザー検出(改良版)
public class Q20260222_new {

    static String FILENAME = "question\\20260222.txt";

    record Log(String name, Ope ope) {}

    enum Ope {
        LOGIN, LOGOUT;

        static Ope operation(String op) {
            return switch (op) {
                case "LOGIN" -> LOGIN;
                case "LOGOUT" -> LOGOUT;
                default -> throw new IllegalArgumentException("unknown op: " + op);
            };
        }
    }

    public static void main(String[] args) {
        var file = new File(FILENAME);

        try (var sc = new Scanner(file)) {

            List<Log> list = new ArrayList<>();

            while (sc.hasNext()) {
                list.add(new Log(sc.next(), Ope.operation(sc.next())));
            }

            var repeated = list.stream()
                    .filter(log -> log.ope() == Ope.LOGIN)
                    .collect(Collectors.groupingBy(Log::name, Collectors.counting()))
                    .entrySet().stream()
                    .filter(e -> e.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .sorted()
                    .toList();

            repeated.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
