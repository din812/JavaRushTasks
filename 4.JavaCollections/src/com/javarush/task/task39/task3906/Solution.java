package com.javarush.task.task39.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
        // SecuritySystem - внутри переключается булевую перменную методами turnOn/Off..
        SecuritySystem securitySystem = new SecuritySystem();
        // внутри объект SecuritySystem сеттится и в методе press() - вызваются методы turnOn/Off..
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(securitySystem);

        // пример Toggle кнопки т.е. повторное нажатию на ту же кнопку = деактивация
        electricPowerSwitch.press();
        electricPowerSwitch.press();

        LightBulb lightBulb = new LightBulb();
        ElectricPowerSwitch electricPowerSwitch2 = new ElectricPowerSwitch(lightBulb);
        electricPowerSwitch2.press();
        electricPowerSwitch2.press();
    }
}
