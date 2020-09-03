package com.javarush.task.task34.task3410.model;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends CollisionObject implements Movable{

  public Player(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.create();
    graphics.setColor(Color.YELLOW);
    graphics.fillOval(this.x, this.y, this.width, this.height);
  }

  @Override
  public void move(int x, int y) {
    this.x += x;
    this.y += y;
  }
}
