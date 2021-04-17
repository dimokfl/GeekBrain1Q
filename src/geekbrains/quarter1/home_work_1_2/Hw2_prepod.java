package geekbrains.quarter1.home_work_1_2;

import java.util.Arrays;

public class Hw2_prepod {

    public static void main(String[] args) {
        replaceNumbersOfArray(new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        createAndFillEmptyArray();
        decreaseNumberLessTwo(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        createAndFillDiagonalMatrix();
        findMinAndMax(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        System.out.println(findBalance(new int[]{1,2,4}));
        shiftArray1(new int[]{1, 2, 3}, -1);
        shiftArray2(new int[]{1, 2, 3}, 2);
    }

    private static void replaceNumbersOfArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static void createAndFillEmptyArray() {
        int[] array = new int[8];

        for (int i = 0, j = 0; i < array.length; i++, j+=3) {
            array[i] = j;
        }

        System.out.println(Arrays.toString(array));
    }

    private static void decreaseNumberLessTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static void createAndFillDiagonalMatrix() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " , ");
            }
            System.out.println();
        }
    }

    private static void findMinAndMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        int min = array[0];

        for (int i = 0; i < array.length; i++) {
//            if (i == 0) {
//                min = array[i];
//                max = array[i];
//            }

            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    // Поиск баланса
    private static boolean findBalance(int[] array) {
        int sumLeft = 0;

        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            int sumRight = getSumArraySlice(i + 1, array.length, array);

            if (sumRight == sumLeft) {
                return true;
            }
        }

        return false;
    }

    private static int getSumArraySlice(int from, int to, int[] array) {
        int sum = 0;
        for (int i = from, j = 0; i < to; i++, j++) {
            sum += array[i];
        }

        return sum;
    }

    // Сдвиг массива
    private static void shiftArray1(int[] array, int shiftValue) {
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            // Circular Array Rotation
            result[i] = array[(array.length + i - shiftValue) % array.length];
        }

        System.out.println(Arrays.toString(result));
    }

    private static void shiftArray2(int[] array, int shiftValue) {
        boolean isRight = shiftValue >= 0;
        int countShiftTimes = Math.abs(shiftValue); // |-1| = 1 |1| = 1

        for (int k = 0; k < countShiftTimes; k++) {
            shiftArray(array, isRight);
        }

        System.out.println(Arrays.toString(array));
    }

    private static void shiftArray(int[] array, boolean isRight) {
        if (isRight) {
            shiftArrayRight(array);

        } else {
            shiftArrayLeft(array);
        }
    }

    private static void shiftArrayLeft(int[] array) {
        for(int i = array.length - 1; i > 0; i--) {
            swap(i, i - 1, array);
        }
    }

    private static void shiftArrayRight(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            swap(i, i + 1, array);
        }
    }

    private static void swap(int i1, int i2, int[] array) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
