package com.javarush.task.task40.task4004;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        return new Polygon(polygon.stream().mapToInt(i -> i.x).toArray()
            ,polygon.stream().mapToInt(i -> i.y).toArray(),
            polygon.size()).contains(new java.awt.Point(point.x, point.y));
    }

}

