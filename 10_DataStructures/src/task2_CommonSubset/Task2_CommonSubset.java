package task2_CommonSubset;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_CommonSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int switchPlaces;
        if (n > m) {
            switchPlaces = n;
            n = m;
            m = switchPlaces;
        }
        List<Integer> pattern = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pattern.add(sc.nextInt());

        }
        for (int i = 0; i < m; i++) {
            digits.add(sc.nextInt());

        }
        int count = 0;
        for (Integer integer : pattern) {
            if (digits.contains(integer)){
                System.out.print(integer + " ");
                count++;
            }
        }
        if (count == 0) System.out.println("NO");
    }
}
