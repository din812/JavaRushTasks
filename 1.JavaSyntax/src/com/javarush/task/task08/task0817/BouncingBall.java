package com.javarush.task.task08.task0817;

public class BouncingBall {
    public void bouncingBall2(){
        int i = BouncingBall.bouncingBall(30.0, 0.66, 1.5);
        System.out.println(i);
    }
    public static int bouncingBall(double h, double bounce, double window) {
        // your code
        if (h <= 0.0 || ((1.0 <= bounce) && (bounce <= 0.0)) || window < h){
            return -1;
        }
        int bcount = 1;

        while (true) {
            if (h*bounce > window){
                bcount+=2;
                h*=bounce;
            }
            else {
                break;
            }
        }
        return bcount;
    }
}
