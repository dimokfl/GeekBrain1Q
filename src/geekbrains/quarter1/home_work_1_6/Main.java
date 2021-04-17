package geekbrains.quarter1.home_work_1_6;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Маркиз", "Черный", 5);
        Cat cat2 = new Cat("Пушистик", "Серый", 2);
        Cat cat3 = new Cat("Мусса", "рыжий", 3);
        Dog dog1 = new Dog("Барбос", "Белый", 9);
        Dog dog2 = new Dog("Шарик", "Коричнеый", 7);
        Dog dog3 = new Dog("Граф", "Бурый", 6);
        Dog dog4 = new Dog("Бивень", "Орех", 8);

        cat1.run(250);
        cat2.swim(50);
        cat3.run(50);
        dog1.swim(500);
        dog2.run(450);
        dog3.run(800);
        dog4.swim(5);

        Animal.getCountAnimal();
        Cat.getCountCat();
        Dog.getCountDog();

    }
}
