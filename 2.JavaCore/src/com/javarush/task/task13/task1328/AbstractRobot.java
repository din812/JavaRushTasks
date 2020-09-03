package com.javarush.task.task13.task1328;

import javax.accessibility.AccessibleTable;

public abstract class AbstractRobot implements Defensable, Attackable {
    private static int hitCount;
    private String name;

    public AbstractRobot(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 4) {
            hitCount = 0;
            defendedBodyPart = BodyPart.ARM;
        }
        return defendedBodyPart;
    }


    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 0;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 4) {
            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        }
        return attackedBodyPart;
    }
}
