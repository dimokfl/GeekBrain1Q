package geekbrains.quarter1.home_work_2_1;

import geekbrains.quarter1.home_work_2_1.obstacle.Course;
import geekbrains.quarter1.home_work_2_1.obstacle.Runway;
import geekbrains.quarter1.home_work_2_1.obstacle.Wall;
import geekbrains.quarter1.home_work_2_1.team.Cat;
import geekbrains.quarter1.home_work_2_1.team.Human;
import geekbrains.quarter1.home_work_2_1.team.Robot;
import geekbrains.quarter1.home_work_2_1.team.Team;

public class Main {
    public static void main(String[] args) {
//        Course c = new Course(...); // Создаем полосу препятствий
//        Team team = new Team(...); // Создаем команду
//        c.doIt(team); // Просим команду пройти полосу
//        team.showResults(); // Показываем результаты

        Team team = new Team();
        team.getGroupList().add(new Cat("Вася", 1, 100));
        team.getGroupList().add(new Human("Петр", 2, 500));
        team.getGroupList().add(new Robot("Девастатор", 10, 10000));
        team.getGroupList().add(new Cat("Феликс", 3, 1000));

        Course course = new Course();
        course.getGroupCourse().add(new Wall(2));
        course.getGroupCourse().add(new Runway(100));

        course.doIt(team);








    }
}
