package task1_UniqueNumbers;


import java.util.*;

public class Task1_UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> digits = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            digits.add(sc.nextInt());

        }
        System.out.println(digits);
    }
}
