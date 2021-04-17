package geekbrains.quarter1.home_work_2_2;

public class Main {

    private static final int SIZE_MASSIVE = 4;

    public static void main(String[] argv) {
        String[][] s1 = {{"1", "25", "33", "47"},
                {"13", "8", "35", "84"},
                {"89", "5", "57", "8"},
                {"16", "2", "37", "55"}};

        try {
            System.out.println(sumMassive(s1));
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }

    }

    public static void checkSizeMassive(String[][] massive) throws MyArraySizeException{
        for (int i = 0; i < massive.length; i++){
            for (int j = 0; j < massive[i].length; j++){
                try {
                    if (massive.length != SIZE_MASSIVE) {
                        throw new MyArraySizeException("Размер массива не верный");
                    }
                    if (massive[j].length != SIZE_MASSIVE) {
                        throw new MyArraySizeException("Размер массива не верный");
                    }
                } catch (MyArraySizeException e) {
                    throw new MyArraySizeException("Размер массива не верный в " + (j + 1) + " ряду");
                }
            }
        }
    }

    public static void checkIntMassive(String[][] massive) throws MyArrayDataException {
        for (int i = 0; i < massive.length; i++){
            for (int j = 0; j < massive[i].length; j++){
                try {
                    Integer.parseInt(massive[i][j]);
//                    throw new MyArrayDataException("Не число");
                } catch (MyArrayDataException e) {
                    throw new MyArrayDataException("Формат данных не является числом");
                }

            }
        }
    }

    public static int sumMassive(String[][] massive) throws MyArrayDataException, MyArraySizeException{
        checkIntMassive(massive);
        checkSizeMassive(massive);
        int res = 0;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
               res += Integer.parseInt(massive[i][j]);
            }
        }
        return res;
    }

}


