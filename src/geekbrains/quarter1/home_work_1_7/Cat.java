package geekbrains.quarter1.home_work_1_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (satiety){
            System.out.println("Котик " + name + " больше не хочет кушать - он сыт.");
        } else if (appetite <= plate.amountFood() && !satiety){
            satiety = true;
            plate.decreaseFood(appetite);
            System.out.println("Котик " + name + " скушал " + appetite + " единиц еды и наелся.");
        } else if (!satiety) {
            System.out.println(name + " не смог покушать, так как в тарелке не достаточно еды.");
            plate.addFood();
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
