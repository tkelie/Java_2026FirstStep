import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 購入合計ランキング
public class Q20260225 {

    static final String FILENAME = "question\\20260225.txt";

    // Logレコード (名前, 金額)
    record Log(String name, int price) {
    }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        // 名前をkey、合計金額をvalueとするMap
        Map<String, Integer> map = new HashMap<>();

        // 名前ごとに金額を足していく
        for (var log : logs) {
            Integer sum = map.get(log.name());
            if (sum == null) {
                sum = 0;
            }
            map.put(log.name(), sum + log.price());
        }

        // Value降順 -> Key昇順
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(
                        Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(e -> e.getKey() + " " + e.getValue())
                .forEach(System.out::println);
        ;
    }

    // 入力をLogのListに格納
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String name = sc.next();
                if (!sc.hasNext())
                    break; // 不正行対策
                int price = sc.nextInt();
                list.add(new Log(name, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return list;
    }
}
