package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    //String country = Country.UKRAINE;

    @Override
    public int getCountOfEggsPerMonth() {
        return 2;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
