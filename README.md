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

### [ログのフィルタと重複ユーザー検出 (2026/02/22)](question/20260222.md)
- [src/Q20260222.java](src/Q20260222.java) ：自作コード
- [src/Q20260222_new.java](src/Q20260222_new.java) ：改良版
- [question/20260222.txt](question/20260222.txt) ：サンプル入力データ

### [ログ解析・セッション時間・平均計算 (2026/02/23)](question/20260223.md)
- [src/Q20260223.java](src/Q20260223.java) ：自作コード
- [src/Q20260223_new.java](src/Q20260223_new.java) ：改良版
- [question/20260223.txt](question/20260223.txt) ：サンプル入力データ

### [ログイン人数カウント (2026/02/24)](question/20260224.md)
- [src/Q20260224.java](src/Q20260224.java) ：自作コード
- [src/Q20260224_new.java](src/Q20260224_new.java) ：改良版
- [question/20260224.txt](question/20260224.txt) ：サンプル入力データ

### [購入合計ランキング (2026/02/25)](question/20260225.md)
- [src/Q20260225.java](src/Q20260225.java) ：自作コード
- [src/Q20260225_new.java](src/Q20260225_new.java) ：改良版
- [question/20260225.txt](question/20260225.txt) ：サンプル入力データ

### [連続ログイン最長時間 (2026/02/26)](question/20260226.md)
- [src/Q20260226.java](src/Q20260226.java) ：自作コード
- [src/Q20260226_new.java](src/Q20260226_new.java) ：改良版
- [question/20260226.txt](question/20260226.txt) ：サンプル入力データ

### [文字数カウント (2026/02/27)](question/20260227.md)
- [src/Q20260227.java](src/Q20260227.java) ：自作コード
- [src/Q20260227_new.java](src/Q20260227_new.java) ：改良版
- [question/20260227.txt](question/20260227.txt) ：サンプル入力データ

### [奇数のみの合計（Stream API） (2026/02/28)](question/20260228.md)
- [src/Q20260228.java](src/Q20260228.java) ：自作コード
- [src/Q20260228_new.java](src/Q20260228_new.java) ：改良版
- [question/20260228.txt](question/20260228.txt) ：サンプル入力データ

---
以下予定
### 反転配列の表示
### Fibonacci チェッカー
### 文字列の回文判定

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
