package geekbrains.quarter1.home_work_1_5;

public class Person {

    private String name;
    private String position;
    private String email;
    private String numberPhone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String numberPhone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("ФИО: " + name + "; Должность: " + position + "; E-mail: " + email + "; Телефон: " +
                numberPhone + "; Зарплата: " + salary + "; Возраст: " + age + ".");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
