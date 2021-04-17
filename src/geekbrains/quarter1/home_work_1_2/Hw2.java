package geekbrains.quarter1.home_work_1_2;

import java.util.Arrays;

public class Hw2 {

    public static void main(String[] args) {

    System.out.println("1. Задание:");
    replaceNumbersOfArray(new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0});

    System.out.println("2. Задание:");
    createAndFillEmptyArray();

    System.out.println("3. Задание:");
    decreaseNumberLessTwo(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});

    System.out.print("4. Задание:");
    createAndFillDiagonalMatrix(new int[9][9]);

    System.out.println("5. Задание:");
    findMinAndMax(new int[] {50, 5, 13, 25, 11, 4, 5, 2, 400, 83, 91, 111});

    System.out.println("6. Задание:");
    checkBalance(new int[] {5, 5, 5, 5, 5, 15, 10});

    System.out.println("7. Задание:");
    offsetMethod(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, -2);

    }

    // Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла
    //     * и условия заменить 0 на 1, 1 на 0;

    public static void replaceNumbersOfArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 2. Задать пустой целочисленный массив размером 8. С помощью цикла
    //     * заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void createAndFillEmptyArray() {
        int[] arr = new int[8];
        int num_1 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num_1;
            num_1 += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 3. Задать массив пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void decreaseNumberLessTwo(int[] arr) {
        for (int i : arr) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            } else {
                arr[i] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //     * одинаковое) и с помощьюцикла(-ов) заполнить его диагональные элементы единицами;

    public static void createAndFillDiagonalMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                if ((j + i) == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }

    // Задание 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы

    public static void findMinAndMax(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("Минимальное значение массива = " + min);
        System.out.println("Максимальное значение массива = " + max);
    }

    // Задание 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод
    //     * должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны;

    public static void checkBalance(int[] a){
        int summa = 0;
        int half = 0;
        boolean r = false;
        for (int i = 0; i < a.length; i++) {
            summa += a[i];
        }
        half = summa / 2;
        if (summa % 2 == 0) {
            summa = 0;
            for (int i = 0; i < a.length; i++) {
                summa += a[i];
                if (summa == half && summa % half == 0) r = true;
            }
            if (r) {
                System.out.print(r + " - ");
                summa = 0;
                for (int i = 0; i < a.length; i++) {
                    summa += a[i];
                    if (summa % half == 0 && summa == half) {
                        System.out.print(a[i] + " || ");
                    } else if (summa != half) {
                        System.out.print(a[i] + " ");
                    }
                }
            } else System.out.println(r + " - Нет совпадений");
        } else System.out.println(r + " - Нет совпадений (массив не четный)");
        System.out.println();
    }

    // Задание 7. Написать метод, которому на вход подается одномерный массив и число n,
    //     * при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.

    public static void offsetMethod(int[] a, int n){
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < a.length-1; j++) {
                        int tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                }
            }
        };
        if (n < 0){
            for (int i = -1; i >= n; i--) {
                for (int j = a.length - 1; j > 0; j--) {
                        int tmp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = tmp;
                }
            }
        }
        System.out.print(Arrays.toString(a));
    }
}