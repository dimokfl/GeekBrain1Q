package geekbrains.quarter1.home_work_2_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Phonebook {

    private Map<String, LinkedList<String>> phone = new HashMap<>();

    public Phonebook(){
        phone = new HashMap<>();
    }

    public void addInfo(String name, String number){
        if (!phone.containsKey(name)){
            phone.put(name, new LinkedList<>());
        }
        phone.get(name).add(number);
    }

    public LinkedList<String> getInfo(String name){
        return phone.get(name);
    }

    public void getSoutInfo(String name){
        System.out.println(phone.get(name));
    }

}
