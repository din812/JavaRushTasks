package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

public class Controller implements EventListener{

  public View view;
  public Model model;

  public Controller() {
    this.view = new View(this);
    this.model = new Model();
    view.init();
    model.restart();
    view.setEventListener(this);
    model.setEventListener(this);
  }

  public GameObjects getGameObjects() {
    return model.getGameObjects();
  }


  public static void main(String[] args) {
    Controller controller = new Controller();
  }

  @Override
  public void move(Direction direction) {
    model.move(direction);
    view.update();
  }

  @Override
  public void restart() {
    model.restart();
    view.update();
  }

  @Override
  public void startNextLevel() {
    model.startNextLevel();
    view.update();
  }

  @Override
  public void levelCompleted(int level) {
    view.completed(level);
  }
}
