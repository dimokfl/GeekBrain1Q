package geekbrains.quarter1.home_work_1_1;

public class Main {

    // Задание 1. Создать метод main

    public static void main(String[] args) {
        System.out.println(calc(1.2f, 5.7f, 87.4f, 38.8f));
        System.out.println(task10and20(11, 5));
        isPositiveOrNegative(-1);
        System.out.println(isNegative(-10));
        greetings("Дмитрий");
        visokosnyGod(2021);
    }

    // Задание 2. Создание всех типов данных

    public static void prim() {
        byte by = 10;
        short sh = 200;
        int in = 300000;
        long lo = 400000000;
        float fl = 50.50f;
        double dou = 60.60164646516846516541684;
        char ch = 'g';
        boolean bool = true;
    }

    // Задание 3. Написать метод вычисляющий выражение a * (b + (c / d))

    public static float calc(float a, float b, float c, float d) {
        return a * (b + c / d);
    }

    // Задание 4. Написать метод, принимающий на вход два числа и проверяющий что их сумма лежит в
    //     * пределах от 10 до 20(включительно)

    public static boolean task10and20(int x1, int x2){
        return x1 + x2 >= 10 && x1 + x2 <= 20;
    }

    // Задание 5. Написать метод, которому в качестве параметра передается целое число, метод должен
    //     * напечатать в консоль, положительное ли число передали или отрицательное

    public static void isPositiveOrNegative(int x) {
        if (x >= 0){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 6. Написать метод, которому в качестве параметра передается целое число. Метод жолжен
    //     * вернуть true, если число отрицательное, и вернуть false если положительное

    public static boolean isNegative(int in){
        if (in <= 0){
            return true;
        }
        return false;
    }

    // Задание 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    //     * Метод должен вывести в консоль сообщение "Привет, указанное_имя!"

    public static void greetings(String name){
        System.out.println("Привет, " + name + "!");
    }

    // Задание 8. Написать метод, который определяет, является ли год високосным. Каждый 4-й год
    //     * является високосным, кроме каждого 100-го, при этом каждый 400-й - високосный

    public static void visokosnyGod(int year) {
        if ((year % 4 == 0) && !(year % 100 == 0)) {
            System.out.println("Високосный год");
        } else if (year % 400 == 0) {
            System.out.println("Високосный год");
        } else {
            System.out.println("Обычный год");
        }
    }
}
