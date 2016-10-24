package task4_CountryTour;

import java.util.*;
import java.util.Map;

public class Task4_CountryTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index = -1;
        Map<Integer, Integer> city = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            Integer distance = sc.nextInt();
            Integer food = sc.nextInt();
            city.put(distance, food);
        }

        final Set<Map.Entry<Integer, Integer>> mapValues = city.entrySet();
        int maplength = mapValues.size();
        Map.Entry<Integer, Integer>[] info = new Map.Entry[maplength];
        mapValues.toArray(info);
        int k = 0;
        int value = 0;
        int start = 0;
        int oldStart = 0;
        int allSteps = 0;
        while (k < n && allSteps < n*n) {
            allSteps++;
            for (int i = start; i < n; i++) {
                value += info[i].getValue() - info[i].getKey();
                if (value < 0) {
                    start++;
                    value = 0;
                    k=0;
                    break;
                } else k++;
                if (i == n-1 && k < n) {
                    oldStart = start;
                    start = 0;
                }
                if (k == n && value >= 0) {
                    index = i;
                    break;
                }
                if (k == n && value < 0) {
                    k=0;
                    start = oldStart;
                    ++start;
                    i = start;
                }
            }
        }
        if (index == -1) {
            System.out.println("NO");
        } else {
            index = index + 2;
            if(index > n ) index = index - n;
            System.out.println(index);
        }
    }
}
