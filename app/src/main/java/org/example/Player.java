package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
  private String name;
  private ArrayList<Monster> monsterDeck;

  public Player(String name, LinkedList<Integer> monsterNumbers) {
    if (monsterNumbers.size() != 5) {
      throw new IllegalArgumentException(
          "モンスターを決める数値は5個必要です");
    }

    this.name = name;
    this.monsterDeck = new ArrayList<>();

    // 引数のLinkedListを変更しないようにコピーする
    LinkedList<Integer> numbers = new LinkedList<>(monsterNumbers);

    while (!numbers.isEmpty()) {
      int rarity = numbers.removeFirst();

      Monster monster = new Monster("", 0);
      monster.summonMonster(rarity);
      monsterDeck.add(monster);
    }
  }

  public String getName() {
    return name;
  }

  public ArrayList<Monster> getMonsterDeck() {
    return new ArrayList<>(monsterDeck);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    result.append("Deck:").append(name);

    for (Monster monster : monsterDeck) {
      result.append(System.lineSeparator());
      result.append(monster.toString());
    }

    return result.toString();
  }
}
