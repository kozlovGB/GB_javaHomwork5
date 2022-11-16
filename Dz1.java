package GB_javaHomwork5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Dz1 {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        enter(db);
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Кого будем искать ?");
        String secondName = iScanner.nextLine();
        printer(db, secondName);
    }

    public static void printer(Map<Integer, String> sf, String value) {
        if (sf.containsValue(value)) {
            var a = sf.keySet();
            for (Integer key : a) {
                if (sf.get(key).equals(value)) {
                    System.out.println(key);
                }
            }
        }
    }

    public static void enter(Map<Integer, String> sf) {
        System.out.println("Введите колличество людей, которых вы хотите записать");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Введите имя пользователя");
            iScanner.nextLine(); // костыль
            String k = iScanner.nextLine();
            System.out.println("Введите колличество теллефонных номеров пользователя");
            int l = iScanner.nextInt();
            for (int j = 0; j < l; j++) {
                System.out.println("Введите номер пользователя");
                int number = iScanner.nextInt();
                sf.put(number, k);
            }

        }

    }

}

