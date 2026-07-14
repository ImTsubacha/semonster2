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
    return this.name + ":レア度[" + this.rarity + "]";
  }

  public void summonMonster(int rarity) {
    this.rarity = rarity;

    switch (rarity){
      case 0:
        this.name = "スライム";
        break;
      case 1:
        this.name = "ゴブリン";
        break;
      case 2:
        this.name = "オーク";
        break;
      case 3:
        this.name = "ワイバーン";
        break;
      case 4:
        this.name = "ドラゴン";
        break;
      default:
        throw new IllegalArgumentException("Invalid rarity: " + rarity);
    }
  }
}
