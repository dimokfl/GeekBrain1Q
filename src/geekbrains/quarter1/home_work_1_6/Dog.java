package geekbrains.quarter1.home_work_1_6;

public class Dog extends Animal{

    private static int countDog = 0;
    private final int RUN_DISTANCE_CAT = 500;
    private final int SWIM_DISTANCE_CAT = 10;

    public Dog(String name, String color, int age){
        super(name, color, age);
        countDog++;
    }

    @Override
    public void run(int run){
        if(run < RUN_DISTANCE_CAT) {
            System.out.println(name + " пробежал " + run + " метров.");
        } else System.out.println(name + " как и все собаки может пробежать " + RUN_DISTANCE_CAT + " метров, он не может пробежал на " + (run - RUN_DISTANCE_CAT) + " метров больше." );
    }

    public void swim(int swim){
        if(swim < SWIM_DISTANCE_CAT) {
            System.out.println(name + " проплыл " + swim + " метров.");
        } else System.out.println(name + " как и все собаки может проплыть " + SWIM_DISTANCE_CAT + " метров, он не может проплыть на " + (swim - SWIM_DISTANCE_CAT) + " метров больше." );
    }

    public static void getCountDog(){
        System.out.println("Создано " + countDog + " собак(и).");
    }
}
