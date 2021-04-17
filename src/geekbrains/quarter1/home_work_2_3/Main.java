package geekbrains.quarter1.home_work_2_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] setsWords = {"Мяч", "Пистолет", "Платье", "Автомобиль", "Телефон", "Самолет", "Кресло", "Автомобиль",
                "Ружье", "Мяч", "Телефон", "Одежда", "Платье", "Пистолет", "Кружка", "Автомобиль", "Приставка",
                "Планшет", "Автомобиль", "Телефон", "Ведро", "Море", "Самолет", "Наушники", "Звезда", "Мяч"};
        System.out.println(uniList(setsWords));
        System.out.println(checkList(setsWords));

        Phonebook phonebook = new Phonebook();
        phonebook.addInfo("Иванов", "+7-927-856-67-36");
        phonebook.addInfo("Петров", "+7-926-556-87-39");
        phonebook.addInfo("Сидоров", "+7-905-156-77-76");
        phonebook.addInfo("Крайнов", "+7-999-877-34-46");
        phonebook.addInfo("Иванов", "+7-927-823-74-71");
        phonebook.addInfo("Метелкин", "+7-917-423-87-58");
        phonebook.addInfo("Пупкин", "+7-917-951-32-91");
        phonebook.addInfo("Дорогов", "+7-916-753-44-34");
        phonebook.addInfo("Петров", "+7-928-888-00-88");
        phonebook.addInfo("Иванов", "+7-926-244-74-27");

        System.out.println(phonebook.getInfo("Иванов"));
        System.out.println(phonebook.getInfo("Крайнов"));
        System.out.println(phonebook.getInfo("Петров"));

        phonebook.getSoutInfo("Сидоров");
        phonebook.getSoutInfo("Иванов");
        phonebook.getSoutInfo("Дорогов");
    }

    public static Set<String> uniList (String[] setsWords){
        Set<String> set = new HashSet<>();
        Collections.addAll(set, setsWords);
        return set;
    }

    public static Map<String, Integer> checkList (String[] setsWords){
        Map<String, Integer> map = new HashMap<>();
        for (String setsWord : setsWords) {
            if (!map.containsKey(setsWord)){
                map.put(setsWord, 0);
            }
            map.put(setsWord, map.get(setsWord) + 1);
        }
        return map;
    }
}
