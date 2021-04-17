package geekbrains.quarter1.home_work_1_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner scr = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (winCheckHor(DOT_X) || winCheckVert(DOT_X) || winCheckDiag(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (winCheckHor(DOT_O) || winCheckVert(DOT_O) || winCheckDiag(DOT_O)) {
                System.out.println("Победил Искусственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap(){
        System.out.println("Для победы соберите " + DOTS_TO_WIN + " крестика в ряд:");
        for (int i = 0; i <= SIZE;i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scr.nextInt() - 1;
            y = scr.nextInt() - 1;
        } while (isNotCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn(){
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (isNotCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isNotCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
        return map[y][x] != DOT_EMPTY;
    }

    public static boolean isMapFull(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean winCheck0(char symb){
        if (map[0][0] == symb && map[0][1] == symb && map [0][2] == symb) return true;
        if (map[1][0] == symb && map[1][1] == symb && map [1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map [2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map [2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map [2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map [2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map [2][2] == symb) return true;
        if (map[0][2] == symb && map[1][1] == symb && map [2][0] == symb) return true;
        return false;
    }

    public static boolean winCheckHor(char symb){
        for (int i = 0; i < SIZE; i++){
            int a = 0;
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == symb) {
                    a++;
                } else if (a == DOTS_TO_WIN){
                    break;
                } else if (map[i][j] != symb){
                    a = 0;
                }
            }
            if (a >= DOTS_TO_WIN) {
                return true;
            }
        }return false;
    }

    public static boolean winCheckVert(char symb){
        for (int i = 0; i < SIZE; i++){
            int a = 0;
            for (int j = 0; j < SIZE; j++){
                if (map[j][i] == symb){
                    a++;
                } else if (a == DOTS_TO_WIN){
                    break;
                } else if (map[j][i] != symb){
                    a = 0;
                }
            }
            if (a >= DOTS_TO_WIN) {
                return true;
            }
        }return false;
    }

    public static boolean winCheckDiag(char symb){
        int a = 0;
        int b = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                a++;
            } else if (a == DOTS_TO_WIN){
                break;
            } else if (map[i][i] != symb){
                a = 0;
            }
            if (map[i][SIZE - 1 - i] == symb) {
                b++;
            } else if (b == DOTS_TO_WIN){
                break;
            } else if (map[i][SIZE - 1 - i] != symb){
                b = 0;
            }
        }
        if (a >= DOTS_TO_WIN) {
            return true;
        }
        if (b >= DOTS_TO_WIN) {
            return true;
        }
        return false;
    }
}
