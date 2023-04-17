// Написать программу, которая найдет и выведет повторяющиеся
//  имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        HashMap<String, Integer> nameCount = new HashMap<>();
        try (Scanner scanner = new Scanner(new File("phoneBook.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fi = line.split(" ");
                String name = fi[0].trim();
                Integer count = nameCount.getOrDefault(name, 0);
                nameCount.put(name, count + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(nameCount.entrySet());
        sortList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        System.out.println("Имена повторяются следующее количество раз:");
        for (Map.Entry<String, Integer> entry : sortList) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
    }
}
