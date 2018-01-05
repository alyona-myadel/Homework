package by.myadel.Homework10.Task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static String key1 = "men";
    private static String key2 = "women";
    
    public static void main(String[] args) {
        PeopleDataStore womenDataStore = new PeopleDataStore();
        womenDataStore.addPerson(new Person("Ekaterina", "Kozlova", "Viktorovna"));
        womenDataStore.addPerson(new Person("Aliona", "Myadel", "Yavgenevna"));
        womenDataStore.addPerson(new Person("Genya", "Vasileva", "Valerevna"));
        PeopleDataStore menDataStore = new PeopleDataStore();
        menDataStore.addPerson(new Person("Nikita", "Vorobey", "Valerevich"));
        menDataStore.addPerson(new Person("Yavgeny", "Drobushevskey", "Valerevich"));
        menDataStore.addPerson(new Person("Oleg", "Lishco", "Valerevich"));
        Map<String, PeopleDataStore> peopleMap = new HashMap<>();
        peopleMap.put(key1, menDataStore);
        peopleMap.put(key2, womenDataStore);
        System.out.println("Enter women or men:");
        Scanner inputScanner = new Scanner(System.in);
        String keyPerson = inputScanner.next();
        peopleMap.get(keyPerson).printRandomPerson();
    }
}
