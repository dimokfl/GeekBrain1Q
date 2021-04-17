package geekbrains.quarter1.home_work_2_1.obstacle;

import geekbrains.quarter1.home_work_2_1.impl.CourseImp;

public class Runway implements CourseImp {

    private int lengthWay;

    public Runway(int lengthWay){
        this.lengthWay = lengthWay;
    }

    public int getLengthWay() {
        return lengthWay;
    }
}
