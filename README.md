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

### [反転配列の表示 (2026/03/01)](question/20260301.md##-%E5%95%8F%E9%A1%8C-2--%E5%8F%8D%E8%BB%A2%E9%85%8D%E5%88%97%E3%81%AE%E8%A1%A8%E7%A4%BA%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E5%8F%82%E7%85%A7stream)
- [src/Q20260301_2.java](src/Q20260301_2.java) ：自作コード
- [src/Q20260301_2_new.java](src/Q20260301_2_new.java) ：改良版
- [question/20260301_Q2.txt](question/20260301_Q2.txt) ：サンプル入力データ

### [Fibonacci チェッカー (2026/03/01)](question/20260301.md#-%E5%95%8F%E9%A1%8C-3--fibonacci-%E3%83%81%E3%82%A7%E3%83%83%E3%82%AB%E3%83%BCoptional-%E3%82%92%E6%B4%BB%E7%94%A8)
- [src/Q20260301_3.java](src/Q20260301_3.java) ：自作コード
- [src/Q20260301_3_new.java](src/Q20260301_3_new.java) ：改良版
- [question/20260301_Q3.txt](question/20260301_Q3.txt) ：サンプル入力データ

### [文字列の回文判定 (2026/03/01)](question/20260301.md#-%E5%95%8F%E9%A1%8C-4--%E6%96%87%E5%AD%97%E5%88%97%E3%81%AE%E5%9B%9E%E6%96%87%E5%88%A4%E5%AE%9Amodern-switch-%E5%BC%8F)
- [src/Q20260301_4.java](src/Q20260301_4.java) ：自作コード
- [src/Q20260301_4_new.java](src/Q20260301_4_new.java) ：改良版
- [question/20260301_Q4.txt](question/20260301_Q4.txt) ：サンプル入力データ

### [日付データ集計 (2026/03/01)](question/20260301.md#-%E5%95%8F%E9%A1%8C-5--%E6%97%A5%E4%BB%98%E3%83%87%E3%83%BC%E3%82%BF%E9%9B%86%E8%A8%88date--time-api)
- [src/Q20260301_5.java](src/Q20260301_5.java) ：自作コード
- [src/Q20260301_5_new.java](src/Q20260301_5_new.java) ：改良版
- [question/20260301_Q5.txt](question/20260301_Q5.txt) ：サンプル入力データ

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
