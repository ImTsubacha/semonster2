package org.example;

public class Monster {
  // フィールドの定義（名前とレア度）
  private String name;
  private int rarity; // 0〜4を想定

  //コンストラクタ
  public Monster(String name, int rarity) {
    this.name = name;
    this.rarity = rarity;
  }

  // 3. テスト表示用
  @Override
  public String toString() {
    return this.name + " (レア度: " + this.rarity + ")";
  }
}
