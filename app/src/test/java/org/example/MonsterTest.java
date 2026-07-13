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
}
