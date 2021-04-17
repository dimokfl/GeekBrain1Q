package geekbrains.quarter1.home_work_1_3;

import java.util.Random;
import java.util.Scanner;

public class Hw3 {

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        // Задание 1. Игра УГАДАЙ ЧИСЛО

        do {
            int min = 0;
            int max = 9;
            System.out.println("Угадайте число от " + min + " до " + max + ". У Вас 3 попытки:");
            int value = rand.nextInt(10);
            int trails = 3;
            while (trails > 0) {
                int number = scanner.nextInt();
                if (number < min || number > max) {
                    trails--;
                    System.out.println("Число не входит в диапазон от " + min + " до " + max + ", " +
                            "осталось попыток: " + trails + " - введите число снова:");
                } else if (number > value && trails > 1) {
                    trails--;
                    System.out.println("Число меньше загаданного, осталось попыток: " + trails);
                } else if (number < value && trails > 1) {
                    trails--;
                    System.out.println("Число больше загаданного, осталось попыток: " + trails);
                } else if (number == value) {
                    System.out.println("Вы угадали!!!");
                    break;
                } else {
                    System.out.println("Вы проиграли(((");
                    trails--;
                }
            }
            System.out.print("Хотите ли поиграть заново? (y/n) -> ");
        }
        while (scanner.next().equals("y"));

        // Задание 2. Игра УГАДАЙ СЛОВО

        do {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                    "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                    "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            System.out.println("Угадайте овощ/фрукт:");
            int order = rand.nextInt(words.length);
            String prod = words[order];
            String quest = scanner.next();
            char[] blank = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
            for (int i = 0; i < prod.length() && i < quest.length(); i++) {
                char compare_1 = prod.charAt(i);
                char compare_2 = quest.charAt(i);
                if (compare_1 == compare_2) {
                    blank[i] = compare_2;
                }
            }
            for (char i : blank) {
                System.out.print(i);
            }
            System.out.println();
            System.out.print("Хотите ли поиграть заново? (y/n) -> ");
        }
        while (scanner.next().equals("y"));

        scanner.close();
    }

}
