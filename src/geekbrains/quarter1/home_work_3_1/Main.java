package geekbrains.quarter1.home_work_3_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arr2 = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        Character[] arr3 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        System.out.println(Arrays.toString(changeElements(arr1, 0, 5)));
        System.out.println(Arrays.toString(changeElements(arr2, 5, 2)));
        System.out.println(Arrays.toString(changeElements(arr3, 0, 5)));

        System.out.println(toArrayList(arr1));
        System.out.println(toArrayList(arr2));
        System.out.println(toArrayList(arr3));


        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple(), new Apple());
        Box <Orange> orangeBox1 = new Box<>(new Orange(), new Orange());
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple());
        Box <Orange> orangeBox2 = new Box<>(new Orange(), new Orange(), new Orange());

        appleBox1.addFruitInBox(new Apple());

        System.out.println(appleBox1.compareFruitBox(appleBox2));
        System.out.println(appleBox2.compareFruitBox(orangeBox1));

        orangeBox2.transferFruit(orangeBox1);
        orangeBox2.addFruitInBox(new Orange());

        System.out.println(orangeBox2.compareFruitBox(appleBox1));

    }

    public static <T> T[] changeElements(T[] arr, int x, int y) {
        T v1 = arr[x];
        T v2 = arr[y];
        for (int i = 0; i < arr.length; i++) {
            if (i == x) {
                arr[i] = v2;
            } else if (i == y) {
                arr[i] = v1;
            }
        }
        return arr;
    }

    public static <T> ArrayList<T> toArrayList (T[] arr){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }

}