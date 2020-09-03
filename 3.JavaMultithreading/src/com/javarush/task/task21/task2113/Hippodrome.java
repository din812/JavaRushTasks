package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("\uD83D\uDC0E", 3, 0));
        horses.add(new Horse("Sheppard", 3, 0));
        horses.add(new Horse("Jack", 3, 0));

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void move() {
        for (Horse horse :
                horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse :
                horses) {
            horse.print();
        }
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
    }

    public Horse getWinner() {
        Horse winner = new Horse("", 0, 0);

        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > winner.getDistance()) {
                winner = horses.get(i);
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
