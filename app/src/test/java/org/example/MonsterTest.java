package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
  @Test
  public void testToString() {
    Monster myMonster = new Monster("スライム", 0);
    String expected = "スライム:レア度[0]";
    assertEquals(expected, myMonster.toString());
  }

  @Test
  public void testSummonMonster() {
    Monster myMonster = new Monster("スライム", 0);
    myMonster.summonMonster(4);
    String expected = "ドラゴン:レア度[4]";
    assertEquals(expected, myMonster.toString());
  }

  // コンストラクタに名前とレア度の2つの引数を指定し，
  // 指定された引数にもとづいて名前とレア度が決定されることを toString の出力でテストする
  @Test
  public void testConstructor() {
    Monster m1 = new Monster("デュラハン", 0);
    Monster m2 = new Monster("ワイバーン", 3);
    Monster m3 = new Monster("ドラゴン", 4);

    assertEquals("デュラハン:レア度[0]", m1.toString());
    assertEquals("ワイバーン:レア度[3]", m2.toString());
    assertEquals("ドラゴン:レア度[4]", m3.toString());
  }

  // レア度3 → レア度4のドラゴンに進化する
  @Test
  public void testEvolveRarity3() {
    Monster myMonster = new Monster("ワイバーン", 3);
    Monster evolved = myMonster.evolve();
    String expected = "ドラゴン:レア度[4]";
    assertEquals(expected, evolved.toString());
  }

  // レア度4 → 竜王に進化する
  @Test
  public void testEvolveRarity4() {
    Monster myMonster = new Monster("ドラゴン", 4);
    Monster evolved = myMonster.evolve();
    String expected = "竜王:レア度[4]";
    assertEquals(expected, evolved.toString());
  }

  // レア度3未満は進化しない（自分自身が返る）
  @Test
  public void testEvolveLowRarity() {
    Monster myMonster = new Monster("スライム", 0);
    Monster evolved = myMonster.evolve();
    assertSame(myMonster, evolved);
    assertEquals("スライム:レア度[0]", evolved.toString());
  }

  // 2段階進化：ワイバーン → ドラゴン → 竜王
  @Test
  public void testEvolveTwice() {
    Monster myMonster = new Monster("ワイバーン", 3);
    Monster evolved = myMonster.evolve().evolve();
    String expected = "竜王:レア度[4]";
    assertEquals(expected, evolved.toString());
  }
}
