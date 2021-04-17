package geekbrains.quarter1.home_work_1_5;

public class Main {
    public static void main(String[] args) {

        Person[] persArr = new Person[5];
        persArr[0] = new Person("Сергей Сергеевич Плячин", "Инженер", "ss.plach@mail.ru",
                "89584623358", 45000, 38);
        persArr[1] = new Person("Кирилл Андреевич Полищук", "Менеджер", "poliKA@yandex.ru",
                "82584561425", 23000,22);
        persArr[2] = new Person("Артем Константинович Васильев", "Начальник закупок", "vasyadoc@gmail.com",
                "85856623535", 55000, 43);
        persArr[3] = new Person("Дмитрий Алексеевич Аристов", "Технолог", "aristovda@list.ru",
                "89556444511", 33000, 48);
        persArr[4] = new Person("Аркадий Семенович Крапивин", "Зам директора", "askrap@mail.ru",
                "89965536644", 180000,53);

        for (int i = 0; i < persArr.length; i++){
            if(persArr[i].getAge()>40){
                persArr[i].printInfo();
            }
        }
    }
}
