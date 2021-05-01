package geekbrains.quarter1.home_work_3_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> contFruits;

    public Box(T... fruits) {
        this.contFruits = new ArrayList<>();
    }

    public float getWeightFruitBox(){
        float weight = 0.0f;
        for (int i = 0; i < contFruits.size(); i++){
            weight += contFruits.get(i).getWeight();
        }
        return weight;
    }

    public boolean compareFruitBox (Box<?> another){
        return Math.abs(this.getWeightFruitBox() - another.getWeightFruitBox()) < 0.001;
    }

    public void addFruitInBox(T fruit) {
        this.contFruits.add(fruit);
    }

    public void transferFruit (Box<? super T> another){
        another.contFruits.addAll(this.contFruits);
        this.contFruits.clear();
    }

}
