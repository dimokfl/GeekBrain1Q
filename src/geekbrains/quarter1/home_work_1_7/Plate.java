package geekbrains.quarter1.home_work_1_7;

public class Plate {
    private int food;
    private final int AUTO_FOOD = 100;
    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке: " + food + " единиц еды.");
    }

    public void decreaseFood(int countDecreaseFood) {
        if (food - countDecreaseFood >= 0) {
            food -= countDecreaseFood;
        }
    }

    public int amountFood(){
        return food;
    }

    public void addFood(){
        food += AUTO_FOOD;
        System.out.println("Сработала автокормушка и добавила в миску " + AUTO_FOOD + " единиц еды.");
    }


}
