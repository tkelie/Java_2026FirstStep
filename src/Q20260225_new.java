import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// 購入合計ランキング(改良版)
public class Q20260225_new {

    static final String FILENAME = "question\\20260225.txt";

    // Logレコード (名前, 金額)
    record Log(String name, int price) {
    }

    public static void main(String[] args) {
        List<Log> logs = readLogs(FILENAME);

        // 名前ごとに金額を集計（Map.merge を使ってシンプルに）
        Map<String, Integer> summed = new HashMap<>();
        logs.forEach(log -> summed.merge(log.name(), log.price(), Integer::sum));

        // 並び替え：金額 降順 → 名前 昇順
        summed.entrySet().stream()
                .sorted( // Comparator をより簡潔に
                        Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                                .reversed()
                                .thenComparing(Map.Entry::getKey))
                .map(e -> e.getKey() + " " + e.getValue())
                .forEach(System.out::println);
    }

    // ファイル読み込み：Log の List を作る
    private static List<Log> readLogs(String filename) {
        List<Log> list = new ArrayList<>();

        try (var sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String name = sc.next();
                if (!sc.hasNextInt())
                    break; // 不正行対策
                int price = sc.nextInt();
                list.add(new Log(name, price));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }

        return list;
    }
}