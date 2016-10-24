package task5_ChildPlay;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task5_ChildPlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> digits = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            digits.add(Integer.parseInt(sc.next()));
        }
        int stop = 1;
        while (stop != 0) {
            stop = 1;
            for (int i = digits.size() - 1; i > 0; i--) {
                if (digits.get(i) > digits.get(i - 1)) {
                    digits.remove(digits.get(i));
                    stop++;
                }
            }
            if (stop == 1){
                stop = 0;
                count--;
            }
            count++;

        }
        System.out.println(count);
    }
}
