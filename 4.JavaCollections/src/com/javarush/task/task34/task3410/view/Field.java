package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Field extends JPanel {

  private View view;
  private EventListener eventListener;

  public void setEventListener(EventListener eventListener) {
    this.eventListener = eventListener;
  }

  public Field(View view) {
    this.view = view;
    this.addKeyListener(new KeyHandler());
    this.setFocusable(true);
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

    for (GameObject object : view.getGameObjects().getAll()) {
      object.draw(g);
    }
  }

  public class KeyHandler extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          eventListener.move(Direction.LEFT);
          break;
        case KeyEvent.VK_RIGHT:
          eventListener.move(Direction.RIGHT);
          break;
        case KeyEvent.VK_DOWN:
          eventListener.move(Direction.DOWN);
          break;
        case KeyEvent.VK_UP:
          eventListener.move(Direction.UP);
          break;
        case KeyEvent.VK_R:
          eventListener.restart();
          break;
      }
    }
  }



}
