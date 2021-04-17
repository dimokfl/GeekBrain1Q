package geekbrains.quarter1.home_work_2_1.obstacle;

import geekbrains.quarter1.home_work_2_1.impl.Actions;
import geekbrains.quarter1.home_work_2_1.impl.CourseImp;
import geekbrains.quarter1.home_work_2_1.team.Team;

import java.util.ArrayList;

public class Course {

    private final ArrayList<CourseImp> groupCourse = new ArrayList<>();

    public Course() {
    }

    public ArrayList<CourseImp> getGroupCourse() {
        return groupCourse;
    }

    public void doIt(Team team){
        for (int i = 0; i < groupCourse.size(); i++){
            for (int j = 0; j < team.getGroupList().size(); j++) {
                Actions actions = team.getGroupList().get(j);
                if (groupCourse.get(i) instanceof Wall){
                    Wall wall = (Wall) groupCourse.get(i);
                    if (!(actions.jump(wall.getHeightWall()))){
                        team.getGroupList().remove(j);
                        j--;
                    }
                }
                if (groupCourse.get(i) instanceof Runway){
                    Runway runway = (Runway) groupCourse.get(i);
                    actions.run(runway.getLengthWay());
                }
            }
        }
    }
}
