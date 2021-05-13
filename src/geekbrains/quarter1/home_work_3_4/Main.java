package geekbrains.quarter1.home_work_3_4;

public class Main {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread1 = new Thread(() -> {
            main.printA();
        });

        Thread thread2 = new Thread(() -> {
            main.printB();
        });

        Thread thread3 = new Thread(() -> {
            main.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }

    public void printA(){
        synchronized (mon){
            try {
                for (int i = 0; i < 10; i++){
                    while (currentLetter != 'A'){
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (mon){
            try {
                for (int i = 0; i < 10; i++){
                    while (currentLetter != 'B'){
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (mon){
            try {
                for (int i = 0; i < 10; i++){
                    while (currentLetter != 'C'){
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
