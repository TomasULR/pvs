package oop.basics.inheritance.polymorphism;

import java.sql.Time;

public class HourShop {
    static void callPrint(Clock c){
        c.printTime();
    }
    public static void main(String[] args) {
        HourClock hourClock = new HourClock();
        hourClock.seconds = 7700;
        hourClock.printTime();
        Timer t = new Timer();
        t.second = 550;
        t.printTime();

        Clock[] clocks = {hourClock, t};
    }


}

class HourClock implements Clock {
    int seconds;

    @Override
    public void printTime() {
        int hours = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;
        System.out.println(hours + ":" + mins + ":" + secs);
    }

    @Override
    public int getTime() {
        return 0;
    }
}
class Timer implements Clock{
    int second;
    @Override
    public void printTime() {
        System.out.println((second/60) + ":" + second % 60);
    }

    @Override
    public int getTime() {
        return 0;
    }
}
