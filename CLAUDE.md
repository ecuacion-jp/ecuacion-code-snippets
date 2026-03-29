# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

Jakarta Bean Validation（旧JSR-380）のコードスニペット集。ecuacion-libフレームワークを使ったバリデーションパターンのサンプルコードを提供する。各モジュールは独立した実行可能なデモプログラム。

## ビルドと実行

```bash
# 特定モジュールをコンパイルして実行
cd <module-directory>
mvn compile exec:java

# ルートからモジュール指定で実行
mvn -pl <module-name> compile exec:java
```

テストフレームワーク・Lintツールは導入されていない。動作確認は `mvn compile exec:java` で Main.java を実行して行う。

カスタムMavenリポジトリ: `https://maven-repo.ecuacion.jp/public`

## モジュール構成

13モジュールが2カテゴリに分類される。

**Core（`ecuacion-lib-core-*`）**：ecuacion-libのコアユーティリティ使用例
- `JakartaValidationExceptionUtil` — ConstraintViolationException処理
- `JakartaValidationItemName` — バリデーションメッセージへの項目名埋め込み
- `JakartaValidationItemNamePattern` — 項目名パターン処理
- `JakartaValidationList` — List・ネストコレクションのバリデーション
- `JakartaValidationMessaging` — メッセージフォーマット・ローカライズ
- `JakartaValidationPrefix` — メッセージプレフィックス

**Validation（`ecuacion-lib-validation-*`）**：カスタム制約のサンプル
- `AnyNotEmpty` — いずれか1つ以上が必須（XORバリデーション）
- `AssertTrueWithPropertyPath` — `@AssertTrue`でpropertyPathをカスタム指定
- `ClassLevelValidator` — クラスレベルバリデーション
- `ItemAndItemContainer` — ネストオブジェクトのバリデーション
- `LessThan` — 比較制約
- `NotEmptyWhen` — 条件付きバリデーション
- `PatternWithDescription` — `@Pattern`に説明メタデータを付加

## アーキテクチャ

各モジュールの構造：
```
<module>/
├── pom.xml
├── src/main/java/.../
│   ├── Main.java          # 実行エントリポイント（複数パターンを順に実演）
│   └── モデルクラス群
├── src/main/resources/
│   └── ValidationMessages.properties  # 日本語バリデーションメッセージ
└── src/module-info.java
```

- 各モジュールのpom.xmlはルートpom.xmlを親として参照
- `exec-maven-plugin`でMain.javaを直接実行できるよう設定済み
- Java 21、Hibernate Validator 8.x〜9.x、Jakarta EL 4.x を使用
