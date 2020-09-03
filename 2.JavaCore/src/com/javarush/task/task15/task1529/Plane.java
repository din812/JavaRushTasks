package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    int passangers = 0;
    @Override
    public void fly() {

    }

    public Plane(int passangers) {
        this.passangers = passangers;
    }
}
