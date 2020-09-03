package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object i = Integer.valueOf(42);
        String s = (String)i;
    }

    public void methodThrowsNullPointerException() {
        Object obj = null;
        obj.hashCode();
    }

    public static void main(String[] args) {

    }

    public static boolean  isIsogram(String str) {
        // ...


        String[] chs = str.toLowerCase().split("");

        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs.length; j++) {
                if (i != j && chs[i].equals(chs[j])) {
                    return true;
                }
            }
        }

        return false;
    }
}
