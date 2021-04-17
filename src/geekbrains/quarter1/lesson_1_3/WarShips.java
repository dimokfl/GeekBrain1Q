package geekbrains.quarter1.lesson_1_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WarShips {

    static final int SIZE_FIELD = 5;
    static final int COUNT_SHIPS = 3;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
//        1. Заполним карту игроков
//        2. Заполним карту компьютера
//        3. Тгорвой цикл
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите число");
//        int i = scanner.nextInt();
//
//        System.out.println("Введено число " + i);
//
//        System.out.println("Введите строку");
//        String s = scanner.nextLine();
//
//        System.out.println("Введена строка " + s);
//
//        scanner.close();
//
//        Random random = new Random();
//
//        int i = random.nextInt(10);
//        System.out.println(i);
//
//        boolean b = random.nextBoolean();
//        System.out.println(b);
//
//        int[] userField = new int[5];
//
//        int availableCountShips = 3;
//        while (availableCountShips > 0)

        do {
            System.out.println("\n===========Морской БОЙ===========\n");

            int remainingCountUserShips = COUNT_SHIPS;
            int remainingCountComputerShips = COUNT_SHIPS;

            int[] userWarField = getUserWarField();
            int[] computerWarField = getComputerWarField();

            int[] computerDidShoot = new int[userWarField.length];
            boolean isUserStep = random.nextBoolean();

            System.out.println("Игра началась!");

            while (remainingCountUserShips > 0 && remainingCountComputerShips > 0) {
                if (isUserStep) {
                    System.out.print("Укажите ячейку для атаки -> ");
                    int indCeil = scanner.nextInt();

                    if (computerWarField[indCeil] != 0) {
                        System.out.println("Убил!");

                        computerWarField[indCeil] = 0;
                        remainingCountComputerShips--;
                        isUserStep = true;

                    } else {
                        System.out.println("Промах");
                        isUserStep = false;
                    }

                } else {
                    int indCeil = random.nextInt(userWarField.length);

                    while (computerDidShoot[indCeil] == 1) {
                        indCeil = random.nextInt(userWarField.length);
                    }

                    if (userWarField[indCeil] != 0) {
                        System.out.println("Противник вас убил в ячейке: " + indCeil);
                        userWarField[indCeil] = 0;
                        System.out.println(Arrays.toString(userWarField));

                        remainingCountUserShips--;
                        isUserStep = false;
                    } else {
                        System.out.println("Противник стрелял по ячейке: " + indCeil);
                        isUserStep = true;
                    }

                    computerDidShoot[indCeil] = 1;
                }
            }

            System.out.print("Хотите ли поиграть заново? (Y/N) -> ");
        } while (scanner.next().equals("Y"));

        scanner.close();
    }

    private static int[] getComputerWarField() {
        int[] computerField = new int[SIZE_FIELD];

        int availableCountShips = COUNT_SHIPS;
        while (availableCountShips > 0) {
            int indCeil = random.nextInt(computerField.length); // n - 1

            if (computerField[indCeil] == 0) {
                computerField[indCeil] = 1;
                availableCountShips--;
            }
        }

        System.out.println("Противник закончил расстановку");
        return computerField;
    }

    private static int[] getUserWarField() {
        int[] userField = new int[SIZE_FIELD];

        int availableCountShips = COUNT_SHIPS;
        while (availableCountShips > 0) {
            System.out.print("Укажите ячейку для коробля -> ");
            int indCeil = scanner.nextInt();

            if (indCeil >= userField.length || indCeil < 0) {
                System.out.println("Указана не корректная ячейка. Доступны ячейки от 0 до "
                        + (userField.length - 1));

            } else if (userField[indCeil] != 0) {
                System.out.println("Ячейка уже занята!");

            } else {
                userField[indCeil] = 1;
                availableCountShips--;

                System.out.println(Arrays.toString(userField));
            }
        }

        System.out.println("Вы успешно расставили корабли");
        System.out.println(Arrays.toString(userField));

        return userField;



    }
}
