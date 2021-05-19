package geekbrains.quarter1.home_work_3_5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier berrier;
    public String getName() {
        return name;
    }


    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier berrier) {
        this.race = race;
        this.speed = speed;
        this.berrier = berrier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            berrier.await();
            berrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            berrier.await();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
