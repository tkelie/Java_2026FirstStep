# Java Practice – First Step (2026)

このリポジトリは  
**Java エンジニア復帰に向けた基礎トレーニングの記録**です。

Java の基本文法やコレクション、  
Java 8 以降のモダン機能（Stream / Optional / Date API など）を  
小さな問題を解きながら復習しました。

このリポジトリで基礎を整理した後、  
次の段階として

👉  [Java_2026SecondStep](https://github.com/tkelie/Java_2026SecondStep)

で **テスト・設計・CLIツール化など実務寄りの学習**に進んでいます。

---

# 🎯 学習の目的

- Java 基本文法の復習
- Stream API の理解
- Optional の扱い
- Comparator を使ったソート処理
- java.time API の扱い
- 小さな問題を **モダン Java で書き直す練習**

---

# 📂 構成

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

※問題ごとに Java ファイルを作成し解答。

---

# 🧩 練習内容

問題は **日付ごとに作成**し、  
少しずつモダン Java の書き方へ書き換えています。

---

## 基本文法・コレクション

- 配列処理
- List / Map
- ファイル読み込み
- ループ処理

---

## Stream API

- filter
- map
- collect
- groupingBy
- counting

例

```java
Map<String, Long> result =
    logs.stream()
        .collect(Collectors.groupingBy(
            Log::userId,
            Collectors.counting()
        ));
````

---

## Optional

null チェックの代わりに
`Optional` を利用した安全な処理。

```java
Optional<List<Log>> logs = reader.read(path);
```

---

## Comparator

コレクションのソート処理。

```java
logs.sort(
    Comparator.comparing(Log::time)
);
```

---

## java.time API

旧 `Date` / `Calendar` の代わりに

* LocalDate
* LocalDateTime
* Duration

などを利用。

---

# 🧠 使用した Java 機能

| 機能             | 内容       |
| -------------- | -------- |
| Stream API     | コレクション処理 |
| Optional       | null 安全  |
| Comparator     | ソート      |
| java.time      | 日付処理     |
| File / Scanner | ファイル読み込み |

---

# 🚀 次のステップ

このリポジトリで基礎を復習した後、
より実務的な内容として以下を学習。

👉
**Java Practice – Second Step**

[https://github.com/tkelie/Java_2026SecondStep](https://github.com/tkelie/Java_2026SecondStep)

内容

* JUnit テスト
* 例外設計
* クラス分割（責務分離）
* Stream API 発展
* CLIツール作成

---

# 💻 開発環境

* Java 25
* VSCode
* GitHub
* Windows 11
