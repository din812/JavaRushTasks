package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{
   //String country = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
