package geekbrains.quarter1.home_work_2_1.team;

import geekbrains.quarter1.home_work_2_1.impl.Actions;

public class Robot implements Actions {

    private String name;
    private int heightJump;
    private int weightRun;

    public Robot(String name, int heightJump, int weightRun){
        this.name = name;
        this.heightJump = heightJump;
        this.weightRun = weightRun;
    }

    @Override
    public boolean jump(int obstacleHeight) {
        if(obstacleHeight<=heightJump) {
            System.out.println("Робот " + name + " не смог перепрыгнуть дистанцию.");
            return true;
        }
        return false;
    }

    @Override
    public boolean run(int lengthHeight) {
        if(lengthHeight<=weightRun) {
            System.out.println("Робот " + name + " не смог пробежать дистанцию.");
            return true;
        }
        return false;
    }
}
