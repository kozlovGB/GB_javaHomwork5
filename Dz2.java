import java.util.HashMap;
import java.util.Map;


public class Dz2 {
    public static void main(String[] args) {
        String[] strArray = {"Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        int k = 0;
        Map<String, Integer> db = new HashMap<>();
        for (String s : strArray) {
            for (String value : strArray) {
                if (s.split(" ")[0].equals(value.split(" ")[0])) {
                    k++;
                }
            }
            if (k > 1) {
                db.putIfAbsent(s.split(" ")[0], k);
                k = 0;
            }
        }
        var a = db.keySet();
        System.out.println(db);
        while (db.size()!=0){
            int maxValue = -1;
            String maxKey = "";
            for (String keys:a){
                if (maxValue < db.get(keys)){
                    maxValue = db.get(keys);
                    maxKey = keys;
                }
            }
            System.out.printf("[%d: %s]\n", db.get(maxKey), maxKey);
            db.remove(maxKey);
        }
    }


}
