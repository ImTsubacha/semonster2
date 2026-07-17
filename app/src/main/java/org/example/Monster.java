package org.example;

public class Monster {
  // フィールドの定義（名前とレア度）
  private String name;
  private int rarity; // 0〜4を想定

  // コンストラクタ
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

    switch (rarity) {
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

  // 進化演出：少し間を置きながらメッセージを表示する
  private void playEvolutionEffect(String newName) {
    try {
      System.out.println("……" + this.name + "の様子がおかしい！");
      Thread.sleep(800);
      System.out.println("まばゆい光に包まれた…！");
      Thread.sleep(800);
      System.out.println("＊＊＊ 進化 ＊＊＊");
      Thread.sleep(800);
      System.out.println(this.name + "は " + newName + " に進化した！！");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  // レア度が3以上の時に進化する
  // レア度3 → レア度4のドラゴンに進化
  // レア度4 → 竜王に進化
  public Monster evolve() {
    if (this.rarity == 3) {
      playEvolutionEffect("ドラゴン");
      return new Monster("ドラゴン", 4);
    }
    if (this.rarity == 4) {
      playEvolutionEffect("竜王");
      return new Monster("竜王", 4);
    }
    // レア度3未満は進化しない
    System.out.println(this.name + "は進化しなかった…（レア度[" + this.rarity + "]）");
    return this;
  }
}
