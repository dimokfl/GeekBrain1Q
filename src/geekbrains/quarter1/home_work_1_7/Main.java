package geekbrains.quarter1.home_work_1_7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[7];
        cats[0] = new Cat("Барсик", 15);
        cats[1] = new Cat("Пушок", 21);
        cats[2] = new Cat("Маркиз", 22);
        cats[3] = new Cat("Карапуз", 42);
        cats[4] = new Cat("Милаш", 7);
        cats[5] = new Cat("Псих", 13);
        cats[6] = new Cat("Девастатор", 143);
        Plate plate = new Plate(45);

        int i = 0;
        while (i < cats.length){
            plate.info();
            cats[i].eat(plate);
            if(cats[i].isSatiety()){
                i++;
            } else if (!cats[i].isSatiety()) {
                System.out.println(cats[i].getName() + " смотрит как добавляется еда...");
            }
        }
        plate.info();
    }
}
