import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dz4 {
    public static boolean searchDuplicate(Map<Character, Integer>[] array, Map<Character, Integer> fn) {
        boolean search = false;
        var key = (fn).keySet();
        for (Character a : key) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    if (array[i].get(a) == fn.get(a)) {
                        search = true;
                    }
                }
            }
        }
        return search;
    }

    public static Map<Character, Integer>[] inputRandom(Map<Character, Integer> db, Map<Character, Integer>[] array, int i) {
        Map<Character, Integer> fn = new HashMap<>();
        String dict = "ABCDEFGH"; //строка содержит все доступные символы
        int r = (int) (Math.random() * dict.length() + 1);
        char keyValue = dict.charAt(r - 1); //в переменную с записывается случайный эллемент строки
        int value = (int) (Math.random() * 8 + 1);
        int counter = 0;
        if (!db.containsKey(keyValue) && !db.containsValue(value)) {
            db.put(keyValue, value);
            fn.put(keyValue, value);
            if (!searchDuplicate(array, fn)) {
                array[i] = fn;
            }
        } else {
            if (db.containsValue(value)) {
                var a = db.keySet();
                for (Character key : a) {
                    if (db.get(key).equals(value)) {
                        if (key.equals(keyValue)) {
                            counter++;
                        }
                    }
                }
                if (counter == 0) {
                    db.put(keyValue, value);
                    fn.put(keyValue, value);
                    if (!searchDuplicate(array, fn)) {
                        array[i] = fn;
                    }
                }
                counter = 0;
            }
            if (db.containsKey(keyValue)) {
                var a = db.get(keyValue);
                if (a.equals(value)) {
                    counter++;
                }
                if (counter == 0) {
                    db.put(keyValue, value);
                    fn.put(keyValue, value);
                    if (!searchDuplicate(array, fn)) {
                        array[i] = fn;
                    }
                }
            }
        }
        return array;
    }

    static void printArray(Map<Character, Integer>[] arr) {
        for (Map<Character, Integer> j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Ввидите колличество ферзей, которых вы хотите расставить ?");
        int size = iScanner.nextInt();
        if (size > 64) {
            System.out.println("Извините, но на доске только 64 ячейки");
        } else {
            Map<Character, Integer> db = new HashMap<>();
            Map<Character, Integer>[] array;
            array = new Map[size];
            int i = 0;
            while (i != size) {
                inputRandom(db, array, i);
                if (array[i] != null) {
                    i++;
                }
            }
            printArray(array);
        }
    }
}