package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class PlayerTest {
  @Test
  public void testToString() {
    LinkedList<Integer> monsterNumbers = new LinkedList<>();

    // Randomを使わず、召喚する順番を固定する
    monsterNumbers.add(0);
    monsterNumbers.add(4);
    monsterNumbers.add(0);
    monsterNumbers.add(3);
    monsterNumbers.add(1);

    Player player = new Player("user", monsterNumbers);

    String newline = System.lineSeparator();

    String expected = "Deck:user" + newline
        + "スライム:レア度[0]" + newline
        + "ドラゴン:レア度[4]" + newline
        + "スライム:レア度[0]" + newline
        + "ワイバーン:レア度[3]" + newline
        + "ゴブリン:レア度[1]";

    assertEquals(expected, player.toString());
  }

  @Test
  public void testDeckSize() {
    LinkedList<Integer> monsterNumbers = new LinkedList<>();

    monsterNumbers.add(0);
    monsterNumbers.add(1);
    monsterNumbers.add(2);
    monsterNumbers.add(3);
    monsterNumbers.add(4);

    Player player = new Player("user", monsterNumbers);

    assertEquals(5, player.getMonsterDeck().size());
  }

  @Test
  public void testInvalidDeckSize() {
    LinkedList<Integer> monsterNumbers = new LinkedList<>();

    monsterNumbers.add(0);
    monsterNumbers.add(1);

    assertThrows(
        IllegalArgumentException.class,
        () -> new Player("user", monsterNumbers));
  }
}
