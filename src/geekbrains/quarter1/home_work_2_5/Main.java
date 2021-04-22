package geekbrains.quarter1.home_work_2_5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
//    static final int QUAD = SIZE/4;
//    static final int DOUBLEQUAD = SIZE/8;

    public static void main(String[] args) {
//        Main e1 = new Main();
        System.out.println("Расчет начался:");
        Main.singleThread();
        Main.dualThread();

    }

    private static void singleThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(("singleThread выполнялся " + (System.currentTimeMillis() - a)/1000%60) + " сек.");
    }

    private static void dualThread() {

        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread thread1 = new Thread(() -> countHalf(a1));
        Thread thread2 = new Thread(() -> countHalf(a2));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println(("dualThread выполнялся " + (System.currentTimeMillis() - a)/1000%60) + " сек.");
    }

    public static float[] countHalf(float[] a){
        for (int i = 0; i < HALF; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return a;
    }










//    private void quadThread() {
//
//        float[] arr = new float[SIZE];
//        for (int i = 0; i < SIZE; i++){
//            arr[i] = 1;
//        }
//        long a = System.currentTimeMillis();
//        float[] a1 = new float[QUAD];
//        float[] a2 = new float[QUAD];
//        float[] a3 = new float[QUAD];
//        float[] a4 = new float[QUAD];
//
//        System.arraycopy(arr, 0, a1, 0, QUAD);
//        System.arraycopy(arr, QUAD, a2, 0, QUAD);
//        System.arraycopy(arr, HALF, a3, 0, QUAD);
//        System.arraycopy(arr, HALF+QUAD, a4, 0, QUAD);
//
//        Thread thread1 = new Thread(() -> countQuad(a1));
//        Thread thread2 = new Thread(() -> countQuad(a2));
//        Thread thread3 = new Thread(() -> countQuad(a3));
//        Thread thread4 = new Thread(() -> countQuad(a4));
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//            thread4.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        System.arraycopy(a1, 0, arr, 0, QUAD);
//        System.arraycopy(a2, 0, arr, QUAD, QUAD);
//        System.arraycopy(a3, 0, arr, HALF, QUAD);
//        System.arraycopy(a4, 0, arr, HALF+QUAD, QUAD);
//
//        System.out.println(("quadThread выполнялся " + (System.currentTimeMillis() - a)/1000%60) + " сек.");
//    }

//    private void doubleQuadThread() {
//
//        float[] arr = new float[SIZE];
//        for (int i = 0; i < SIZE; i++){
//            arr[i] = 1;
//        }
//        long a = System.currentTimeMillis();
//        float[] a1 = new float[QUAD];
//        float[] a2 = new float[QUAD];
//        float[] a3 = new float[QUAD];
//        float[] a4 = new float[QUAD];
//        float[] a5 = new float[QUAD];
//        float[] a6 = new float[QUAD];
//        float[] a7 = new float[QUAD];
//        float[] a8 = new float[QUAD];
//
//        System.arraycopy(arr, 0, a1, 0, DOUBLEQUAD);
//        System.arraycopy(arr, DOUBLEQUAD, a2, 0, DOUBLEQUAD);
//        System.arraycopy(arr, QUAD, a3, 0, DOUBLEQUAD);
//        System.arraycopy(arr, HALF-DOUBLEQUAD, a4, 0, DOUBLEQUAD);
//        System.arraycopy(arr, HALF, a5, 0, DOUBLEQUAD);
//        System.arraycopy(arr, HALF+DOUBLEQUAD, a6, 0, DOUBLEQUAD);
//        System.arraycopy(arr, HALF+QUAD, a7, 0, DOUBLEQUAD);
//        System.arraycopy(arr, SIZE-DOUBLEQUAD, a8, 0, DOUBLEQUAD);
//
//        Thread thread1 = new Thread(() -> countQuad(a1));
//        Thread thread2 = new Thread(() -> countQuad(a2));
//        Thread thread3 = new Thread(() -> countQuad(a3));
//        Thread thread4 = new Thread(() -> countQuad(a4));
//        Thread thread5 = new Thread(() -> countQuad(a5));
//        Thread thread6 = new Thread(() -> countQuad(a6));
//        Thread thread7 = new Thread(() -> countQuad(a7));
//        Thread thread8 = new Thread(() -> countQuad(a8));
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//            thread4.join();
//            thread5.join();
//            thread6.join();
//            thread7.join();
//            thread8.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        System.arraycopy(a1, 0, arr, 0, DOUBLEQUAD);
//        System.arraycopy(a2, 0, arr, DOUBLEQUAD, DOUBLEQUAD);
//        System.arraycopy(a3, 0, arr, QUAD, DOUBLEQUAD);
//        System.arraycopy(a4, 0, arr, DOUBLEQUAD+QUAD, DOUBLEQUAD);
//        System.arraycopy(a5, 0, arr, HALF, DOUBLEQUAD);
//        System.arraycopy(a6, 0, arr, HALF+DOUBLEQUAD, DOUBLEQUAD);
//        System.arraycopy(a7, 0, arr, HALF+QUAD, DOUBLEQUAD);
//        System.arraycopy(a8, 0, arr, HALF-DOUBLEQUAD, DOUBLEQUAD);
//
//        System.out.println(("doableQuadThread выполнялся " + (System.currentTimeMillis() - a)/1000%60) + " сек.");
//    }

//    public float[] countQuad(float[] a){
//        for (int i = 0; i < QUAD; i++) {
//            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        return a;
//    }

//    public float[] countDoubleQuad(float[] a){
//        for (int i = 0; i < DOUBLEQUAD; i++) {
//            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        return a;
//    }
}
