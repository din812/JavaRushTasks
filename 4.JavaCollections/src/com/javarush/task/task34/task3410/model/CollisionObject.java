package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {


  public CollisionObject(int x, int y) {
    super(x, y);
  }

  public boolean isCollision(GameObject gameObject, Direction direction) {
    if (gameObject == null) {
      return false;
    }

    switch (direction) {
      case LEFT:
        return this.getY() == gameObject.getY() && this.getX() - Model.FIELD_CELL_SIZE == gameObject
            .getX();
      case RIGHT:
        return this.getY() == gameObject.getY() && this.getX() + Model.FIELD_CELL_SIZE == gameObject
            .getX();
      case UP:
        return this.getX() == gameObject.getX() && this.getY() - Model.FIELD_CELL_SIZE == gameObject
            .getY();
      case DOWN:
        return this.getX() == gameObject.getX() && this.getY() + Model.FIELD_CELL_SIZE == gameObject
            .getY();
    }

    return false;
  }
}
