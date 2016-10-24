package task6_WordReplacement;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task6_WordReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = sc.nextInt();
        String[] split = input.split(" ");
        Map<String, String> words = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            String value = sc.next();
            words.put(key, value);
            for (int j = count; j < split.length; j++) {
                for (String keys : words.keySet()) {
                    if (split[j].equalsIgnoreCase(keys)) {
                        split[j] = words.get(key);
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + " ");

        }
    }
}
