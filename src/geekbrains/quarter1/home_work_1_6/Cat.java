package geekbrains.quarter1.home_work_1_6;

public class Cat extends Animal {

    private static int countCat = 0;
    private final int RUN_DISTANCE_CAT = 200;

    public Cat(String name, String color, int age){
        super(name, color, age);
        countCat++;
    }

    @Override
    public void run(int run){
        if(run < RUN_DISTANCE_CAT) {
            System.out.println(name + " пробежал " + run + " метров.");
        } else System.out.println(name + " как и все коты может пробежать " + RUN_DISTANCE_CAT + " метров, а он не может пробежал на " + (run - RUN_DISTANCE_CAT) + " метров больше." );
    }

    public void swim(int swim){
        System.out.println("Кот не умеет плавать!");
    }

    public static void getCountCat(){
        System.out.println("Создано " + countCat + " кот(а/ов).");
    }
}
