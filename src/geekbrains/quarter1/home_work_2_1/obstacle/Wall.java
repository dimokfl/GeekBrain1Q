package geekbrains.quarter1.home_work_2_1.obstacle;

import geekbrains.quarter1.home_work_2_1.impl.CourseImp;

public class Wall implements CourseImp {

    private int heightWall;

    public Wall(int heightWall){
        this.heightWall = heightWall;
    }

    public int getHeightWall() {
        return heightWall;
    }
}
