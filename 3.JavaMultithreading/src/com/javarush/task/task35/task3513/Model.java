package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Model {

  private static final int FIELD_WIDTH = 4;
  private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
  public int score = 0;
  public int maxTile = 0;
  private Stack<Tile[][]> previousStates = new Stack<>();
  private Stack<Integer> previousScores = new Stack<>();
  private boolean isSaveNeeded = true;

  public Tile[][] getGameTiles() {
    return gameTiles;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public boolean canMove() {
    if (!getEmptyTiles().isEmpty()) {
      return true;
    }
    for (int i = 0; i < gameTiles.length; i++) {
      for (int j = 0; j < gameTiles.length - 1; j++) {
        if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
          return true;
        }
      }
    }
    for (int j = 0; j < gameTiles.length; j++) {
      for (int i = 0; i < gameTiles.length - 1; i++) {
        if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
          return true;
        }
      }
    }
    return false;
  }

  public Model() {
    resetGameTiles();
  }

  public void resetGameTiles() {
    for (int i = 0; i < FIELD_WIDTH; i++) {
      for (int j = 0; j < FIELD_WIDTH; j++) {
        gameTiles[i][j] = new Tile();
      }
    }
    addTile();
    addTile();
  }

  private void addTile() {
    List<Tile> tiles = getEmptyTiles();
    if(!tiles.isEmpty()) {
      int i = (int) (tiles.size() * Math.random());
      tiles.get(i).value = (Math.random() < 0.9) ? 2 : 4;
    }
  }

  private List<Tile> getEmptyTiles() {
    List<Tile> emptyTiles = new ArrayList<>();

    for (int i = 0; i < FIELD_WIDTH; i++) {
      for (int j = 0; j < FIELD_WIDTH; j++) {
        if (gameTiles[i][j].isEmpty()) {
          emptyTiles.add(gameTiles[i][j]);
        }
      }
    }
    return emptyTiles;
  }

  private boolean compressTiles(Tile[] tiles) {
    int temp;
    boolean changed = false;

    int zeroC = 0;

    for (Tile zeros : tiles) {
      if (zeros.isEmpty()) {
        zeroC++;
      }
    }

    if (zeroC == tiles.length) {
      return changed;
    }

    for (int j = 0; j < tiles.length; j++) {
      for (int i = 0; i < tiles.length - 1; i++) {
        if (tiles[i].value == 0 && tiles[i + 1].value != 0) {
          temp = tiles[i + 1].value;
          tiles[i + 1].value = 0;
          tiles[i].value = temp;
          changed = true;
        }
      }
    }

    return changed;
  }

  private boolean mergeTiles(Tile[] tiles) {
    boolean changes = false;
    for (int i = 0; i < tiles.length - 1; i++) {
      if (tiles[i].value != 0 && (tiles[i].value == tiles[i + 1].value)) {
        tiles[i].value = tiles[i].value + tiles[i + 1].value;
        if (tiles[i].value > maxTile) {
          maxTile = tiles[i].value;
        }
        score += tiles[i].value;
        tiles[i + 1].value = 0;
        changes = true;
        compressTiles(tiles);
      }
    }
    return changes;
  }

  public void left() {
    if (isSaveNeeded) {
      saveState(gameTiles);
    }

    boolean changed = false;
    for (int row = 0; row < FIELD_WIDTH; row++) {
      if (compressTiles(gameTiles[row]) | mergeTiles(gameTiles[row])) {
        changed = true;
      }
    }
    if (changed) {
      addTile();
    }

    isSaveNeeded = true;
    if (changed) {
      addTile();
    }

  }

  private void gameTilesRotator() {
    Tile[][] tempArr = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    for (int y = 0; y < FIELD_WIDTH; y++) {
      for (int x = 0; x < FIELD_WIDTH; x++) {
        tempArr[y][x] = gameTiles[gameTiles.length - x - 1][y];
      }
    }
    gameTiles = tempArr;
  }

  public void right() {
    saveState(gameTiles);
    gameTilesRotator();
    gameTilesRotator();
    left();
    gameTilesRotator();
    gameTilesRotator();
  }

  public void up() {
    saveState(gameTiles);
    gameTilesRotator();
    gameTilesRotator();
    gameTilesRotator();
    left();
    gameTilesRotator();
  }

  public void down() {
    saveState(gameTiles);
    gameTilesRotator();
    left();
    gameTilesRotator();
    gameTilesRotator();
    gameTilesRotator();
  }

  private void saveState(Tile[][] matrix) {
    Tile[][] tmp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    for (int i = 0; i < FIELD_WIDTH; i++) {
      for (int j = 0; j < FIELD_WIDTH; j++) {
        tmp[i][j] = new Tile(matrix[i][j].value);
      }
    }
    previousStates.push(tmp);
    previousScores.push(score);
    isSaveNeeded = false;
  }

  public void rollback() {
    if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
      gameTiles = previousStates.pop();
      score = previousScores.pop();
    }
  }

  public void randomMove() {
    int n = ((int) (Math.random() * 100)) % 4;
    switch (n) {
      case 0: {
        left();
      }
      break;
      case 1: {
        right();
      }
      break;
      case 2: {
        up();
      }
      break;
      case 3: {
        down();
      }
      break;
    }
  }

  public boolean hasBoardChanged() {
    Tile[][] tmp = previousStates.peek();
    int sum = 0;
    int sumPrev = 0;
    for (int i = 0; i < FIELD_WIDTH; i++) {
      for (int j = 0; j < FIELD_WIDTH; j++) {
        sum += gameTiles[i][j].value;
        sumPrev += tmp[i][j].value;
      }
    }
    return sum != sumPrev;
  }

  private MoveEfficiency getMoveEfficiency(Move move) {
    MoveEfficiency moveEfficiency;
    move.move();
    if (hasBoardChanged()) {
      moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
    } else {
      moveEfficiency = new MoveEfficiency(-1, 0, move);
    }
    rollback();
    return moveEfficiency;
  }

  public void autoMove() {
    PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
    priorityQueue.offer(getMoveEfficiency(this::left));
    priorityQueue.offer(getMoveEfficiency(this::right));
    priorityQueue.offer(getMoveEfficiency(this::up));
    priorityQueue.offer(getMoveEfficiency(this::down));

    priorityQueue.peek().getMove().move();
  }
}
