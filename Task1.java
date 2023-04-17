// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;
import java.io.*;

public class Task1 {

    public static void addNumber(Map<String, ArrayList<Integer>> map) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String key = sc.nextLine().trim();
        System.out.print("Введите телефон: ");
        int value = sc.nextInt();

        if (map.containsKey(key)) {
            map.get(key).add((int) value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }

    public static void printBook(Map<String, ArrayList<Integer>> map) {
        for (var item : map.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }

    public static void main(String[] args) {

        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {

            System.out.println("1 - Добавление номера");
            System.out.println("2 - Вывод всех контактов");
            System.out.println("3 - Выйти");

            choice = sc.nextInt();
            if (choice > 3) {
                System.out.println("Введите цифру от 1 до 3");
            }
            switch (choice) {
                case 1:
                    addNumber(bookPhone);
                    break;
                case 2:
                    printBook(bookPhone);
                    break;
            }
            ;

        } while (choice != 3);

    }
}