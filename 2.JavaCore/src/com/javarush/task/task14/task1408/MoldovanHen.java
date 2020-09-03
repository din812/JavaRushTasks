package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    //String country = Country.MOLDOVA;

    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
