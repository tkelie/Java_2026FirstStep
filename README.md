# Java Practice Codes (2026)

このリポジトリは、Java エンジニア復帰のための学習記録です。  
Java 1.4 時代からのブランク（約20年）を埋めるために、  
**現代的な Java（Java 17+）の書き方を使ったミニ問題集と解答**をまとめています。

## 🎯 学習の目的

- Stream API / ラムダ式 / Comparator / Optional など  
  **Java 8 以降のモダン構文を習得する**
- record / enum / switch 式など  
  **Java 14+ のシンプルで安全な書き方を体得する**
- Date & Time API（java.time.*）に慣れる
- 実務でも使われるコードの書き方（責務の分離、読みやすさ、保守性）
- GitHub でコード管理（コミット・ブランチ・README 記述の練習）

---

## 📂 ディレクトリ構成

```

src/
Q20260222.java       # ログのフィルタと重複ユーザー検出：自作コード
Q20260222_new.java   # (同上) モダン化した改良版
Q20260223.java       # ログ解析・セッション時間・平均計算：自作コード
Q20260223_new.java   # (同上) モダン化した改良版
question/
20260222.md          # 2026/02/22の練習問題
20260222.txt         # (同上)用入力データ
20260223.md          # 2026/02/23の練習問題
20260223.txt         # (同上)用入力データ

```

---

## 📝 問題概要

### Q20260222 — 「LOGIN が複数回あるユーザーを抽出」
ログファイルの形式（例）：

```

Alice LOGIN
Bob LOGIN
Alice LOGIN
Charlie LOGIN
Bob LOGOUT

```

**やること**
- LOGIN のみ抽出
- ユーザー名でソート
- 2 回以上ログインしているユーザーを出力

**学んだこと**
- record によるデータクラスの簡潔な表現  
- enum の switch を使った安全なパース  
- Stream の filter / sorted / toArray  
- Map に頼らずシンプルに集計するテクニック

---

### Q20260223 — 「ログからセッション時間を求める」
ログ形式（例）：

```

2025-02-21 09:00 LOGIN Alice
2025-02-21 12:00 LOGOUT Alice
2025-02-21 09:00 LOGIN Bob
2025-02-21 10:00 LOGOUT Bob

```

**解く内容**
1. ユーザーごとの LOGIN 回数（昇順）
2. セッション（Login → Logout）の時間計算
3. 最も合計滞在時間が長いユーザー
4. 平均セッション時間の算出

**学んだこと**
- `LocalDate`, `LocalTime`, `LocalDateTime` の運用  
- `Duration.between()` による時間差計算  
- Comparator の多段ソート（名前 → 日付 → 時刻 → 操作）  
- `Collectors.groupingBy()` + `summingLong()`  
- `record` を使ったデータの明確な建て付け  
- try-with-resources による安全なファイル読み込み

---

## 🧠 使用したモダン Java の機能

| 機能 | 使用例 |
|-----|--------|
| **record** | `record Log(LocalDate date, ...)` |
| **enum + switch 式** | `switch (s) { case "LOGIN" -> LOGIN; ... }` |
| **Stream API** | filter / map / sorted / groupingBy |
| **Comparator.comparing** | 多段ソートの実装 |
| **java.time API** | LocalDate / LocalTime / Duration |
| **summarizingLong** | 集計の一括処理 |
| **メソッド参照 ::** | `Log[]::new` など |
| **try-with-resources** | 自動クローズによる安全な I/O |

---

## 🧩 今後の予定（ToDo）

- [ ] JUnit による自動テスト追加  
- [ ] 例外パターン（ログ欠損・順番崩れ）のハンドリング  
- [ ] ログ集計ツールとしてクラス分割（LogReader, SessionAnalyzer）  
- [ ] Stream → Map をより関数型的に改善  
- [ ] Spring Boot / CLI ツール化して実際に動くアプリとして仕上げる  

---

## 🚀 開発環境

- Java 25
- VSCode（Extension Pack for Java）
- GitHub（バージョン管理）
- Windows 11

---

---

---

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
