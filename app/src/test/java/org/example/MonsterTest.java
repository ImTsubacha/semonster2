package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
  @Test
  public void testSum() {
    Monster myMonster = new Monster("スライム", 0);
    String expected = "スライム:レア度[0]";
    assertEquals(expected, myMonster.toString());
  }
}
