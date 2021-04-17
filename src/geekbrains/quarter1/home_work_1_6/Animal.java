package geekbrains.quarter1.home_work_1_6;

public abstract class Animal {

    protected String name;
    protected String color;
    protected int age;
    protected int run;
    protected int swim;
    protected static int countAnimal = 0;

    Animal(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
        countAnimal++;
    }

    public abstract void run(int run);

    public abstract void swim(int swim);

    public static void getCountAnimal(){
        System.out.println("Создано " + countAnimal + " животных.");
    }
}
