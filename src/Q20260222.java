import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// ログのフィルタと重複ユーザー検出
public class Q20260222 {

    // ファイル名
    static String FILENAME = "question\\20260222.txt";

    // Log
    record Log(String name, Ope ope) {
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

    public static void main(String[] args) {
        File file = new File(FILENAME);

        try {
            var sc = new Scanner(file); // ファイルを開く

            List<Log> list = new ArrayList<>();

            while (sc.hasNext()) {
                list.add(new Log(sc.next(), Ope.operation(sc.next()))); // 1行ずつLogとして抽出
            }

            var listOfTarget = list.stream()
                    .filter(log -> log.ope() == Ope.LOGIN) // LOGINを抽出
                    .sorted(Comparator.comparing(log -> log.name())) // 昇順ソート
                    .toArray(Log[]::new);

            int count = 0;

            for (int i = 1; i < listOfTarget.length; i++) {
                if (listOfTarget[i - 1].name().equals(listOfTarget[i].name())) { // 1つ前と同じなら「2回以上」と判定
                    count++;
                    if (i == listOfTarget.length - 1) { // 最終行
                        System.out.println(listOfTarget[i].name());
                    }
                } else {
                    if (count > 0) {
                        System.out.println(listOfTarget[i - 1].name());
                        count = 0;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
